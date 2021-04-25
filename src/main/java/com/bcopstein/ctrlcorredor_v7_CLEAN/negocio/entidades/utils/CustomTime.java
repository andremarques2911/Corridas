package com.bcopstein.ctrlcorredor_v7_CLEAN.negocio.entidades.utils;

import javax.persistence.Embeddable;
import javax.persistence.Column;

@Embeddable
public class CustomTime {
  @Column( nullable = false )
  private int horas;

  @Column( nullable = false )
  private int minutos;

  @Column( nullable = false )
  private int segundos;

  public CustomTime() {

  }

  public CustomTime(int horas, int minutos, int segundos) {
    this.horas = horas;
    this.minutos = minutos;
    this.segundos = segundos;
  }

  public int getHoras() {
    return horas;
  }

  public int getMinutos() {
    return minutos;
  }

  public int getSegundos() {
    return segundos;
  }
}
