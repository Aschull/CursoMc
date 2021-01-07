package com.nelioalves.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

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

  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name="estado_id")
  private Estado estado;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cidade cidade = (Cidade) o;
    return id.equals(cidade.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
