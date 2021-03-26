package com.bcopstein.CtrlCorredorV1.service;

import java.util.List;
import java.util.stream.Collectors;

import com.bcopstein.CtrlCorredorV1.dto.EventoDTO;
import com.bcopstein.CtrlCorredorV1.entity.EventoEntity;
import com.bcopstein.CtrlCorredorV1.repository.EventoRepository;

import org.springframework.stereotype.Service;

@Service
public class EventoService extends AbstractService<EventoEntity, EventoRepository> {

  public boolean cadastraCorredor(EventoDTO dto) {
    return this.repository.save(this.montaEventoEntity(dto)) != null;
  }

  public List<EventoDTO> listarTodos() {
    return this.listAll()
      .stream()
      .map(it -> EventoDTO.builder()
        .id(it.getId())
        .nome(it.getNome())
        .dia(it.getDia())
        .mes(it.getMes())
        .ano(it.getAno())
        .distancia(it.getDistancia())
        .horas(it.getHoras())
        .minutos(it.getMinutos())
        .segundos(it.getSegundos())
        .build())
      .collect(Collectors.toList());
  }

  private EventoEntity montaEventoEntity(EventoDTO dto) {
    return EventoEntity.builder()
      .id(dto.getId())
      .nome(dto.getNome())
      .dia(dto.getDia())
      .mes(dto.getMes())
      .ano(dto.getAno())
      .distancia(dto.getDistancia())
      .horas(dto.getHoras())
      .minutos(dto.getMinutos())
      .segundos(dto.getSegundos())
      .build();
  }

}
