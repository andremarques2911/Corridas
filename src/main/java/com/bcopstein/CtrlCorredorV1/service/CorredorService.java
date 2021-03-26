package com.bcopstein.CtrlCorredorV1.service;

import java.util.List;
import java.util.stream.Collectors;

import com.bcopstein.CtrlCorredorV1.dto.CorredorDTO;
import com.bcopstein.CtrlCorredorV1.entity.CorredorEntity;
import com.bcopstein.CtrlCorredorV1.repository.CorredorRepository;

import org.springframework.stereotype.Service;

@Service
public class CorredorService extends AbstractService<CorredorEntity, CorredorRepository> {

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
