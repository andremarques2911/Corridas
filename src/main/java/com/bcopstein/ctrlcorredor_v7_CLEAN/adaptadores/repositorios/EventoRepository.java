package com.bcopstein.ctrlcorredor_v7_CLEAN.adaptadores.repositorios;

import java.util.List;

import com.bcopstein.ctrlcorredor_v7_CLEAN.negocio.entidades.Evento;
import com.bcopstein.ctrlcorredor_v7_CLEAN.negocio.repositorios.IEventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventoRepository implements IEventoRepository {
  private IEventoRepositoryCustom iEventoRepositoryCustom;

  @Autowired
  public EventoRepository(IEventoRepositoryCustom iEventoRepositoryCustom) {
    this.iEventoRepositoryCustom = iEventoRepositoryCustom;
  }

  public List<Evento> todos() {
    return this.iEventoRepositoryCustom.findAll();
  }

  public boolean cadastra(Evento evento) {
    return this.iEventoRepositoryCustom.save(evento) != null;
  }
}
