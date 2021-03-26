package com.bcopstein.CtrlCorredorV1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "eventos")
public class EventoEntity extends AbstractEntity {

  @Id
  @SequenceGenerator(allocationSize = 1, name = "id_evento_seq", sequenceName = "id_evento_seq")
  @GeneratedValue(generator = "id_evento_seq", strategy = GenerationType.SEQUENCE)
  @Column(name = "id_evento")
  private Long id;

  @Column( name = "nome", nullable = false )
  private String nome;

  // Data do evento
  @Column( name = "dia", nullable = false )
  private Integer dia;

  @Column( name = "mes", nullable = false )
  private Integer mes;

  @Column( name = "ano", nullable = false )
  private Integer ano;

  // Distancia percorrida
  @Column( name = "distancia", nullable = false )
  private Integer distancia; // metros
  
  // Tempo que o corredor levou para percorrer a distancia
  @Column( name = "horas" )
  private Integer horas;

  @Column( name = "minutos" )
  private Integer minutos;

  @Column( name = "segundos" )
  private Integer segundos;

  @Override
  public String toString() {
    return "Evento [ano=" + ano + ", dia=" + dia + ", distancia=" + distancia + ", horas=" + horas + ", id=" + id
      + ", mes=" + mes + ", minutos=" + minutos + ", nome=" + nome + ", segundos=" + segundos + "]";
  }
}
