package com.nelioalves.cursomc.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Categoria implements Serializable {
  public static final long serivalVersionUID = 1L;

  @Id
  private Integer id;
  private String nome;

  public Categoria() {
  }

  public Categoria(Integer id, String nome) {
    this.id = id;
    this.nome = nome;
  }
}
