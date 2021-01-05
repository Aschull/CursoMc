package com.nelioalves.cursomc.domain.enums;

import lombok.Getter;

@Getter
public enum TipoCliente {

  PESSOAFISICA(1, "Pessoa Física"),
  PESSOAJURIDICA(2, "Pessoa Jurídica");

  private Integer cod;
  private String desc;

  //Construtores em calsses ENUMS são "private"
  private TipoCliente(Integer cod, String desc) {
    this.cod = cod;
    this.desc = desc;
  }

  public static TipoCliente toEnum(Integer cod){
    if (cod == null){
      return null;
    }
    for (TipoCliente x : TipoCliente.values()){
      if(cod.equals(x.getCod())){
        return x;
      }
    }
    throw new IllegalArgumentException("Id inválido: " + cod);
  }

}
