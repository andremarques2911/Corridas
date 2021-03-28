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
public class EstatisticasDTO {
  private LocalTime media;
  private LocalTime mediana;
  private double desvioPadrao;
  private int qtdCorridas;
}
