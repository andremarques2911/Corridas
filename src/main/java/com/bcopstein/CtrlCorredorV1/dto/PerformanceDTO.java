package com.bcopstein.CtrlCorredorV1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PerformanceDTO {
  private String nomeProva1;
  private String nomeProva2;
}
