package com.bcopstein.ctrlcorredor_v7_CLEAN.adaptadores.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bcopstein.ctrlcorredor_v7_CLEAN.negocio.repositorios.IEventoRepository;
import com.bcopstein.ctrlcorredor_v7_CLEAN.negocio.entidades.Evento;

@Repository
public interface IEventoRepositoryCustom extends CrudRepository<Evento, Long> {

  List<Evento> findAll();

}
