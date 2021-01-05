package com.nelioalves.cursomc.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cidade {


  public Cidade(Integer id, String nome, Estado estado) {
    this.id = id;
    this.nome = nome;
    this.estado = estado;
  }

  public Cidade() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;

  @ManyToOne
  @JoinColumn(name="estado_id")
  private Estado estado;
}
