package com.nelioalves.cursomc.domain;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
public class ItemPedido implements Serializable {
  private static final long serivalVersionUID = 1L;

  public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
    id.setPedido(pedido);
    id.setProduto(produto);
    this.desconto = desconto;
    this.quantidade = quantidade;
    this.preco = preco;
  }

  public ItemPedido() {
  }

  //Classe de relacionamento Item x Pedido n deve possuir ID proprio, deve-se ter uma chave composta a partir da classe Item e a classe Pedido
  //Nesse caso o id será a instancia da classe ItemPedidoPK

  //Id imbutido por uma classe auxiliar
  @EmbeddedId
  private ItemPedidoPK id = new ItemPedidoPK();
  private Double desconto;
  private Integer quantidade;
  private Double preco;


  public Pedido getPedido(){
    return id.getPedido();
  }

  public Produto getProduto(){
    return id.getProduto();
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ItemPedido that = (ItemPedido) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public static long getSerivalVersionUID() {
    return serivalVersionUID;
  }

  public ItemPedidoPK getId() {
    return id;
  }

  public void setId(ItemPedidoPK id) {
    this.id = id;
  }

  public Double getDesconto() {
    return desconto;
  }

  public void setDesconto(Double desconto) {
    this.desconto = desconto;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }



}
