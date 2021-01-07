package com.nelioalves.cursomc.resources;

import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.services.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class PedidoResource {

  PedidoService pedidoService;

  public PedidoResource(PedidoService pedidoService) {
    this.pedidoService = pedidoService;
  }

  @GetMapping(value = "pedidos/{id}")
  public ResponseEntity<?> Listar(@PathVariable Integer id){

    Pedido obj = pedidoService.buscar(id);

    return ResponseEntity.ok().body(obj);
  }
}