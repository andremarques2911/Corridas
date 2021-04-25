package com.bcopstein.ctrlcorredor_v7_CLEAN.adaptadores.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bcopstein.ctrlcorredor_v7_CLEAN.negocio.repositorios.ICorredorRepository;
import com.bcopstein.ctrlcorredor_v7_CLEAN.negocio.entidades.Corredor;

@Repository
public interface ICorredorRepositoryCustom extends CrudRepository<Corredor, Long> {

  List<Corredor> findAll();

}
