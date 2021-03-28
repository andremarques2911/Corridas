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
import com.bcopstein.CtrlCorredorV1.entity.CorredorEntity;
import com.bcopstein.CtrlCorredorV1.entity.EventoEntity;
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

    EstatisticasDTO estatisticas = EstatisticasDTO.builder()
      .media(this.calculaMedia(tempos))
      .mediana(this.calculaMediana(tempos))
      .build();
    return estatisticas;
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

  private CorredorDTO montaCorredorDTO(CorredorEntity entity) {
    return CorredorDTO.builder()
      .cpf(entity.getCpf())
      .nome(entity.getNome())
      .dia(entity.getDia())
      .mes(entity.getMes())
      .ano(entity.getAno())
      .genero(entity.getGenero())
      .build();
  }

  private CorredorEntity montaCorredorEntity(CorredorDTO dto) {
    return CorredorEntity.builder()
      .cpf(dto.getCpf())
      .nome(dto.getNome())
      .dia(dto.getDia())
      .mes(dto.getMes())
      .ano(dto.getAno())
      .genero(dto.getGenero())
      .build();
  }

}
