package com.nelioalves.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

  @JsonIgnore
  @OneToMany(mappedBy = "estado")
  private List<Cidade> cidades = new ArrayList<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Estado estado = (Estado) o;
    return id.equals(estado.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

