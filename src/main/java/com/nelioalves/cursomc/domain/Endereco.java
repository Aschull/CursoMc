package com.nelioalves.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Endereco implements Serializable {
  public static final long serivalVersionUID = 1L;


  public Endereco(Integer id, String logradouro, String numero, String complemento, String bairro, String cep, Cliente cliente,Cidade cidade) {
    this.id = id;
    this.logradouro = logradouro;
    this.numero = numero;
    this.complemento = complemento;
    this.bairro = bairro;
    this.cep = cep;
    this.cliente = cliente;
    this.cidade = cidade;
  }

  public Endereco() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String logradouro;
  private String numero;
  private String complemento;
  private String bairro;
  private String cep;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @ManyToOne
  @JoinColumn(name = "cidade_id")
  private Cidade cidade;



}
