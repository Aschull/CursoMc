package com.nelioalves.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@Entity
public class Produto implements Serializable{
  public static final long serivalVersionUID = 1L;

  public Produto(Integer id, String nome, Double preco) {
    this.id = id;
    this.nome = nome;
    this.preco = preco;
  }

  public Produto() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private Double preco;

  @JsonIgnore
  @ManyToMany
  @JoinTable(name = "PRODUTO_CATEGORIA",
   joinColumns = @JoinColumn(name = "produto_id"),
   inverseJoinColumns = @JoinColumn(name = "categoria_id")
  )
  private List<Categoria> categorias = new ArrayList<>();

  //Set é uma coleção tal qual o List porém o Set garante que não existirá itens repetidos dentro da coleção
  @JsonIgnore
  @OneToMany(mappedBy = "id.produto")
  private Set<ItemPedido> itens = new HashSet<>();


  @JsonIgnore
  private List<Pedido> getPedidos(){
    List<Pedido> lista = new ArrayList<>();

    for(ItemPedido x : itens){
      lista.add(x.getPedido());
    }
    return lista;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Produto produto = (Produto) o;
    return Objects.equals(id, produto.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public static long getSerivalVersionUID() {
    return serivalVersionUID;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public List<Categoria> getCategorias() {
    return categorias;
  }

  public void setCategorias(List<Categoria> categorias) {
    this.categorias = categorias;
  }

  public Set<ItemPedido> getItens() {
    return itens;
  }

  public void setItens(Set<ItemPedido> itens) {
    this.itens = itens;
  }
}
