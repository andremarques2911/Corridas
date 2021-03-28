package com.bcopstein.CtrlCorredorV1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventoDTO {
  private Long id;
  private String nome;
  private Integer dia;
  private Integer mes;
  private Integer ano;
  private double distancia;
  private LocalTime tempo;
}
