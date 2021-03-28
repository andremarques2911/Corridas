package com.bcopstein.CtrlCorredorV1.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.bcopstein.CtrlCorredorV1.dto.CorredorDTO;
import com.bcopstein.CtrlCorredorV1.dto.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.dto.EventoDTO;
import com.bcopstein.CtrlCorredorV1.dto.PerformanceDTO;
import com.bcopstein.CtrlCorredorV1.entity.CorredorEntity;
import com.bcopstein.CtrlCorredorV1.repository.CorredorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorredorService extends AbstractService<CorredorEntity, CorredorRepository> {

  @Autowired
  private EventoService eventoService;

  public boolean cadastraCorredor(CorredorDTO dto) {
      return this.repository.save(this.montaCorredorEntity(dto)) != null;
  }

  public List<CorredorDTO> listarTodos() {
    return this.listAll()
      .stream()
      .map(corredor -> this.montaCorredorDTO(corredor))
      .collect(Collectors.toList());
  }

  public EstatisticasDTO estatisticas(double distancia) {

    List<EventoDTO> lista = this.eventoService.findByDistancia(distancia);

    List<LocalTime> tempos = new ArrayList<>();
    for(EventoDTO evento : lista) tempos.add(evento.getTempo());

    LocalTime media = this.calculaMedia(tempos);
    LocalTime mediana = this.calculaMediana(tempos);
    LocalTime desvioPadrao = this.calculaDesvioPadrao(tempos, media);

    EstatisticasDTO estatisticas = EstatisticasDTO.builder()
      .media(media)
      .mediana(mediana)
      .desvioPadrao(desvioPadrao)
      .quantidadeCorridas(tempos.size())
      .build();
    return estatisticas;
  }

  public PerformanceDTO aumentoPerformance(double distancia, int ano) {
    List<EventoDTO> eventos = this.eventoService.buscaPorDistanciaEDataEvento(distancia, ano);
    LocalTime melhorPerformance = LocalTime.of(0, 0, 0);
    String nomeMelhorEvento1 = null;
    String nomeMelhorEvento2 = null;

    for(int i=0; i<eventos.size()-1; i++){
      EventoDTO evento1 = eventos.get(i);
      EventoDTO evento2 = eventos.get(i+1);
      if (evento1.getTempo().isAfter(evento2.getTempo())) {
        LocalTime performanceAtual = evento1.getTempo().minusSeconds(evento2.getTempo().toSecondOfDay());
        if (performanceAtual.isAfter(melhorPerformance)) {
          melhorPerformance = performanceAtual;
          nomeMelhorEvento1 = evento1.getNome();
          nomeMelhorEvento2 = evento2.getNome();
        }
      }
    }

    return PerformanceDTO.builder()
      .nomeEvento1(nomeMelhorEvento1)
      .nomeEvento2(nomeMelhorEvento2)
      .build();
  }

  private LocalTime calculaMedia(List<LocalTime> tempos) {
    return LocalTime.ofSecondOfDay((long) tempos.stream()
      .mapToInt(LocalTime::toSecondOfDay)
      .average()
      .getAsDouble());
  }

  private LocalTime calculaMediana(List<LocalTime> tempos) {
    Collections.sort(tempos);
    int tipo = tempos.size() % 2;
    if (tipo == 1) {
      return tempos.get(((tempos.size() + 1) / 2) - 1);
    } else {
      int m = tempos.size() / 2;
      return this.calculaMedia(Arrays.asList(tempos.get(m - 1), tempos.get(m)));
    }
  }

  private LocalTime calculaDesvioPadrao(List<LocalTime> tempos, LocalTime media) {
    double standardDeviation = 0.0;
    for(LocalTime tempo : tempos) standardDeviation += Math.pow(tempo.toSecondOfDay() - media.toSecondOfDay(), 2);
    return LocalTime.ofSecondOfDay((long) Math.sqrt(standardDeviation / tempos.size()));
  }

  private CorredorDTO montaCorredorDTO(CorredorEntity entity) {
    return CorredorDTO.builder()
      .cpf(entity.getCpf())
      .nome(entity.getNome())
      .dataNascimento(entity.getDataNascimento())
      .genero(entity.getGenero())
      .build();
  }

  private CorredorEntity montaCorredorEntity(CorredorDTO dto) {
    return CorredorEntity.builder()
      .cpf(dto.getCpf())
      .nome(dto.getNome())
      .dataNascimento(dto.getDataNascimento())
      .genero(dto.getGenero())
      .build();
  }

}
