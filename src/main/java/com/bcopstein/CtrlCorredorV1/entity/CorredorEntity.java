package com.bcopstein.CtrlCorredorV1.entity;

import java.time.LocalDate;

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
@Table( name = "corredores")
public class CorredorEntity extends AbstractEntity {

  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(allocationSize = 1, name = "id_corredor_seq", sequenceName = "id_corredor_seq")
  @GeneratedValue(generator = "id_corredor_seq", strategy = GenerationType.SEQUENCE)
  @Column(name = "id_corredor")
  private Long id;

  @Column( nullable = false, unique = true )
  private String cpf;

  @Column( nullable = false )
  private String nome;

   @Column( name = "dt_nascimento", nullable = false )
   private LocalDate dataNascimento;

  @Column( nullable = false )
  private String genero;

}
