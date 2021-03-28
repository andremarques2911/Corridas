package com.bcopstein.CtrlCorredorV1.service;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.bcopstein.CtrlCorredorV1.dto.CorredorDTO;
import com.bcopstein.CtrlCorredorV1.dto.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.entity.CorredorEntity;
import com.bcopstein.CtrlCorredorV1.entity.EventoEntity;
import com.bcopstein.CtrlCorredorV1.service.EventoService;
import com.bcopstein.CtrlCorredorV1.repository.CorredorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalTime;


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
      .map(it -> CorredorDTO.builder()
        .cpf(it.getCpf())
        .nome(it.getNome())
        .dia(it.getDia())
        .mes(it.getMes())
        .ano(it.getAno())
        .genero(it.getGenero())
        .build())
      .collect(Collectors.toList());
  }

  public EstatisticasDTO estatisticas(double distancia) {
    List<EventoEntity> lista = this.eventoService.findByDistancia(distancia);
    double somaSegundos = 0;
    // for(EventoEntity evento : lista) {
    //   double horaSegundos = Double.valueOf(evento.getTempo().getHour());
    //   double minutosSegundos = Double.valueOf(evento.getTempo().getMinute());
    //   double segundos = Double.valueOf(evento.getTempo().getSecond());
    //   somaSegundos += horaSegundos + minutosSegundos + segundos;
    // };
    List<LocalTime> tempos = new ArrayList<>();
    for(EventoEntity evento : lista) {
      tempos.add(evento.getTempo());
    }
    LocalTime media = LocalTime.ofSecondOfDay((long) tempos.stream()
        .mapToInt(LocalTime::toSecondOfDay)
        .average()
        .getAsDouble());
    // double media = somaSegundos / lista.size();
    EstatisticasDTO estatisticas = EstatisticasDTO.builder().media(media).build();
    return estatisticas;
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
