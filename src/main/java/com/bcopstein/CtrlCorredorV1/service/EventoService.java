package com.bcopstein.CtrlCorredorV1.service;

import java.util.List;
import java.util.stream.Collectors;

import com.bcopstein.CtrlCorredorV1.dto.EventoDTO;
import com.bcopstein.CtrlCorredorV1.entity.EventoEntity;
import com.bcopstein.CtrlCorredorV1.repository.EventoRepository;

import org.springframework.stereotype.Service;

@Service
public class EventoService extends AbstractService<EventoEntity, EventoRepository> {

  public boolean cadastraEvento(EventoDTO dto) {
    return this.repository.save(this.montaEventoEntity(dto)) != null;
  }

  public List<EventoDTO> listarTodos() {
    return this.listAll()
      .stream()
      .map(evento -> this.montaEventoDTO(evento))
      .collect(Collectors.toList());
  }

  public List<EventoDTO> findByDistancia(double distancia) {
    return this.repository.findByDistancia(distancia)
      .stream()
      .map(evento -> this.montaEventoDTO(evento))
      .collect(Collectors.toList());
  }

  private EventoDTO montaEventoDTO(EventoEntity entity) {
    return EventoDTO.builder()
      .id(entity.getId())
      .nome(entity.getNome())
      .dia(entity.getDia())
      .mes(entity.getMes())
      .ano(entity.getAno())
      .distancia(entity.getDistancia())
      .tempo(entity.getTempo())
      .build();
  }

  private EventoEntity montaEventoEntity(EventoDTO dto) {
    return EventoEntity.builder()
      .id(dto.getId())
      .nome(dto.getNome())
      .dia(dto.getDia())
      .mes(dto.getMes())
      .ano(dto.getAno())
      .distancia(dto.getDistancia())
      .tempo(dto.getTempo())
      .build();
  }
}
