package com.bcopstein.CtrlCorredorV1.entity;

import java.util.Date;

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

  @Id
  @SequenceGenerator(allocationSize = 1, name = "id_corredor_seq", sequenceName = "id_corredor_seq")
  @GeneratedValue(generator = "id_corredor_seq", strategy = GenerationType.SEQUENCE)
  @Column(name = "id_corredor")
  private Long id;

  @Column
  private String cpf;

  @Column
  private String nome;

//    @Column( name = "dt_nascimento" )
//    private Date dataNascimento;

  @Column
  private Integer dia;

  @Column
  private Integer mes;

  @Column
  private Integer ano;

  @Column
  private String genero;

}
