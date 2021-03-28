package com.bcopstein.CtrlCorredorV1.repository;


import java.time.LocalDate;
import java.util.List;

import com.bcopstein.CtrlCorredorV1.entity.EventoEntity;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends CrudRepository<EventoEntity, Long> {

  List<EventoEntity> findAll();

  List<EventoEntity> findByDistancia(double distancia);

  List<EventoEntity> findByDistancia(double distancia, Sort Sort);

}
