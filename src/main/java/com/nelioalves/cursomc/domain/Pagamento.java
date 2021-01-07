package com.nelioalves.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nelioalves.cursomc.domain.enums.EstadoPagamento;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Inheritance é a anotação responsável por criar uma tabela para cada subclasse no caso PagamentoCartao e PagamentoBoleto
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {
  public static final long serivalVersionUID = 1L;

  public Pagamento(Integer id, EstadoPagamento estadoPagamento, Pedido pedido) {
    this.id = id;
    this.estadoPagamento = estadoPagamento.getCod();
    this.pedido = pedido;
  }

  public Pagamento() {
  }

  @Id
  private Integer id;
  private Integer estadoPagamento;

  @JsonBackReference
  @OneToOne
  @JoinColumn(name = "pedido_id")
  @MapsId
  private Pedido pedido;


  public static long getSerivalVersionUID() {
    return serivalVersionUID;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public EstadoPagamento getEstadoPagamento() {
    return EstadoPagamento.toEnum(estadoPagamento);
  }

  public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
    this.estadoPagamento = estadoPagamento.getCod();
  }
}
