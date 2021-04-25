package com.bcopstein.ctrlcorredor_v7_CLEAN.adaptadores.repositorios;

import java.time.LocalDate;
import java.util.List;

import com.bcopstein.ctrlcorredor_v7_CLEAN.negocio.entidades.Corredor;
import com.bcopstein.ctrlcorredor_v7_CLEAN.negocio.repositorios.ICorredorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CorredorRepository implements ICorredorRepository {
  private ICorredorRepositoryCustom iCorredorRepositoryCustom;

  @Autowired
  public CorredorRepository(ICorredorRepositoryCustom iCorredorRepositoryCustom) {
    this.iCorredorRepositoryCustom = iCorredorRepositoryCustom;
  }

  public List<Corredor> todos() {
    return this.iCorredorRepositoryCustom.findAll();
  }

  public void removeTodos() {
    this.iCorredorRepositoryCustom.deleteAll();
  }

  public boolean cadastra(Corredor corredor) {
    return this.iCorredorRepositoryCustom.save(corredor) != null;
  }
}
