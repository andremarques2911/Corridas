package com.bcopstein.ctrlcorredor_v7_CLEAN.negocio.entidades;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "corredores")
// @JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_corredor", scope = Corredor.class)
public class Corredor {

  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(allocationSize = 1, name = "id_corredor_seq", sequenceName = "id_corredor_seq")
  @GeneratedValue(generator = "id_corredor_seq", strategy = GenerationType.SEQUENCE)
  @Column(name = "id_corredor")
  private Long id;

  @Column(nullable = false, unique = true)
  private String cpf;

  @Column(nullable = false)
  private String nome;

  @Column(name = "dt_nascimento", nullable = false)
  private LocalDate dataNascimento;

  @Column(nullable = false)
  private String genero;

  @JsonManagedReference
  @OneToMany(mappedBy = "corredor", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Evento> eventos;

  public Corredor() {

  }

  public Corredor(String cpf, String nome, LocalDate dataNascimento, String genero) {
    this.cpf = cpf;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.genero = genero;
    this.eventos = new ArrayList<>();
  }

  public String getCpf() {
    return cpf;
  }

  public String getNome() {
    return nome;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public String getGenero() {
    return genero;
  }

  public List<Evento> getEventos() {
    return eventos;
  }

}
