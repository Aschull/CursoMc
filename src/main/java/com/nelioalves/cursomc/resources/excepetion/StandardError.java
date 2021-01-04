package com.nelioalves.cursomc.resources.excepetion;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class StandardError implements Serializable {
  public static final long serivalVersionUID = 1L;

  private Integer status;
  private String msg;
  private Long timeStamp;
}
