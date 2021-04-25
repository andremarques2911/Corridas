package com.bcopstein.ctrlcorredor_v7_CLEAN.negocio.entidades.utils;

import javax.persistence.Embeddable;
import javax.persistence.Column;

@Embeddable
public class CustomDate {
  @Column( nullable = false )
  private int dia;

  @Column( nullable = false )
  private int mes;

  @Column( nullable = false )
  private int ano;

  public CustomDate() {

  }

  public CustomDate(int dia, int mes, int ano) {
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
  }

  public int getDia() {
    return dia;
  }

  public int getMes() {
    return mes;
  }

  public int getAno() {
    return ano;
  }
}
