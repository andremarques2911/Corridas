package com.bcopstein.CtrlCorredorV1.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CorredorDTO {
  private String cpf;
  private String nome;
  private LocalDate dataNascimento;
  private String genero;
}
