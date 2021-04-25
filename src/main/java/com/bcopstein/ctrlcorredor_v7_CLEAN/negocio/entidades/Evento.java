package com.bcopstein.ctrlcorredor_v7_CLEAN.negocio.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.bcopstein.ctrlcorredor_v7_CLEAN.negocio.entidades.utils.CustomDate;
import com.bcopstein.ctrlcorredor_v7_CLEAN.negocio.entidades.utils.CustomTime;

@Entity
@Table(name = "eventos")
// @JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_evento", scope = Evento.class)
public class Evento {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(allocationSize = 1, name = "id_evento_seq", sequenceName = "id_evento_seq")
  @GeneratedValue(generator = "id_evento_seq", strategy = GenerationType.SEQUENCE)
  @Column(name = "id_evento")
  private Long id;

  @Column( nullable = false )
  private String nome;

  @Embedded
  private CustomDate dataEvento;

  @Column( nullable = false )
  private int distancia;

  @Embedded
  private CustomTime horaEvento;

  @JsonBackReference
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "id_corredor",  nullable = false)
  private Corredor corredor;

  public Evento() {

  }

  public Evento(Long id, String nome, CustomDate dataEvento, int distancia, CustomTime horaEvento, Corredor corredor) {
    this.id = id;
    this.nome = nome;
    this.dataEvento = dataEvento;
    this.distancia = distancia;
    this.horaEvento = horaEvento;
    this.corredor = corredor;
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public CustomDate getDataEvento() {
    return dataEvento;
  }

  public int getDistancia() {
    return distancia;
  }

  public CustomTime getHoraEvento() {
    return horaEvento;
  }

  public Corredor getCorredor() {
    return corredor;
  }
  public int getDia() {
    return dataEvento.getDia();
  }

  public int getMes() {
    return dataEvento.getMes();
  }

  public int getAno() {
    return dataEvento.getAno();
  }

  public int getHoras() {
    return horaEvento.getHoras();
  }

  public int getMinutos() {
    return horaEvento.getMinutos();
  }

  public int getSegundos() {
    return horaEvento.getSegundos();
  }

  @Override
  public String toString() {
    return  "Evento [id=" + id + ", dataEvento=" + dataEvento + ", distancia=" + distancia + ", horaEvento=" + horaEvento +  ", nome=" + nome + "]";
  }
}
