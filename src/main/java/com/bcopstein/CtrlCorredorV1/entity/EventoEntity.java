package com.bcopstein.CtrlCorredorV1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.time.LocalDate;
import java.time.LocalTime;

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

  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(allocationSize = 1, name = "id_evento_seq", sequenceName = "id_evento_seq")
  @GeneratedValue(generator = "id_evento_seq", strategy = GenerationType.SEQUENCE)
  @Column( name = "id_evento" )
  private Long id;

  @Column( nullable = false )
  private String nome;

  @Column( name = "dt_evento", nullable = false )
  private LocalDate dataEvento;

  @Column( nullable = false )
  private double distancia;

  @Column( nullable = false )
  private LocalTime tempo;

}
