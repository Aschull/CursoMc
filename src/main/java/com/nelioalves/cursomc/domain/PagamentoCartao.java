package com.nelioalves.cursomc.domain;

import com.nelioalves.cursomc.domain.enums.EstadoPagamento;

import javax.persistence.Entity;

@Entity
public class PagamentoCartao extends Pagamento{
  public static final long serivalVersionUID = 1L;

  public PagamentoCartao(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Integer numeroParcela) {
    super(id, estadoPagamento, pedido);
    this.numeroParcela = numeroParcela;
  }

  public PagamentoCartao(){
  }

  private Integer numeroParcela;

  public static long getSerivalVersionUID() {
    return serivalVersionUID;
  }

  public Integer getNumeroParcela() {
    return numeroParcela;
  }

  public void setNumeroParcela(Integer numeroParcela) {
    this.numeroParcela = numeroParcela;
  }
}
