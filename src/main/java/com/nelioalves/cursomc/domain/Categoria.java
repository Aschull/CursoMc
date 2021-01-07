package com.nelioalves.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
public class Categoria implements Serializable {
  public static final long serivalVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  @JsonManagedReference
  @ManyToMany(mappedBy = "categorias")
  private List<Produto> produtos = new ArrayList<>();

  public Categoria(Integer id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Categoria() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Categoria categoria = (Categoria) o;
    return id.equals(categoria.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
