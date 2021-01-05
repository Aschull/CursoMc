package com.nelioalves.cursomc.domain;

import com.nelioalves.cursomc.domain.enums.EstadoPagamento;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Pagamento implements Serializable {
  public static final long serivalVersionUID = 1L;

  public Pagamento(Integer id, EstadoPagamento estadoPagamento, Pedido pedido) {
    this.id = id;
    this.estadoPagamento = estadoPagamento;
    this.pedido = pedido;
  }

  public Pagamento() {
  }

  @Id
  private Integer id;
  private EstadoPagamento estadoPagamento;

  @OneToOne
  @JoinColumn(name = "pedido_id")
  @MapsId
  private Pedido pedido;
}
