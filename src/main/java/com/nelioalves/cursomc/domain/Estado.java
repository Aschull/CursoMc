package com.nelioalves.cursomc.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Estado implements Serializable {
  public static final long serivalVersionUID = 1L;

  public Estado(Integer id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Estado() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;

  @OneToMany(mappedBy = "estado")
  private List<Cidade> cidades = new ArrayList<>();
}

