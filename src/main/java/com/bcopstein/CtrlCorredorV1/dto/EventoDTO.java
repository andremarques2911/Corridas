package com.bcopstein.CtrlCorredorV1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventoDTO {
  private Long id;
  private String nome;
  private LocalDate dataEvento;
  private double distancia;
  private LocalTime tempo;
}
