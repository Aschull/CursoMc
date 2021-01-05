package com.nelioalves.cursomc.domain;

import com.nelioalves.cursomc.domain.enums.EstadoPagamento;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class PagamentoCartao extends Pagamento{
  public static final long serivalVersionUID = 1L;

  public PagamentoCartao(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Integer numeroParcela) {
    super(id, estadoPagamento, pedido);
    this.numeroParcela = numeroParcela;
  }

  public PagamentoCartao(){
  }

  private Integer numeroParcela;
}
