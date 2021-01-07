package com.nelioalves.cursomc.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class Pedido implements Serializable {
  public static final long serivalVersionUID = 1L;

  public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoEntrega) {
    this.id = id;
    this.instante = instante;
    this.cliente = cliente;
    this.enderecoEntrega = enderecoEntrega;
  }

  public Pedido() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Date instante;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
  private Pagamento pagamento;

  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @ManyToOne
  @JoinColumn(name = "endereco_entrega_id")
  private Endereco enderecoEntrega;

  //Set é uma coleção tal qual o List porém o Set garante que não existirá itens repetidos dentro da coleção
  @OneToMany(mappedBy = "id.pedido")
  private Set<ItemPedido> itens = new HashSet<>();




  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pedido pedido = (Pedido) o;
    return id.equals(pedido.id);
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

  public Date getInstante() {
    return instante;
  }

  public void setInstante(Date instante) {
    this.instante = instante;
  }

  public Pagamento getPagamento() {
    return pagamento;
  }

  public void setPagamento(Pagamento pagamento) {
    this.pagamento = pagamento;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Endereco getEnderecoEntrega() {
    return enderecoEntrega;
  }

  public void setEnderecoEntrega(Endereco enderecoEntrega) {
    this.enderecoEntrega = enderecoEntrega;
  }

  public Set<ItemPedido> getItens() {
    return itens;
  }

  public void setItens(Set<ItemPedido> itens) {
    this.itens = itens;
  }
}
