package com.bcopstein.CtrlCorredorV1.dto;

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
  private Integer dia;
  private Integer mes;
  private Integer ano;
  private String genero;
}
