package com.nelioalves.cursomc.domain;

import com.nelioalves.cursomc.domain.enums.EstadoPagamento;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
public class PagamentoBoleto extends Pagamento{
  public static final long serivalVersionUID = 1L;


  public PagamentoBoleto(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Date dataVencimento, Date dataPagamento) {
    super(id, estadoPagamento, pedido);
    this.dataVencimento = dataVencimento;
    this.dataPagamento = dataPagamento;
  }

  public PagamentoBoleto(){
  }

  private Date dataVencimento;
  private Date dataPagamento;
}
