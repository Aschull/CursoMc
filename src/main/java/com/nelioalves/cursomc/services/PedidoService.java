package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.repositories.PedidoRepository;
import com.nelioalves.cursomc.services.serviceException.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

  public PedidoService(PedidoRepository pedidoRepository) {
    this.pedidoRepository = pedidoRepository;
  }

  PedidoRepository pedidoRepository;

  public Pedido buscar(Integer id){
    Pedido obj = pedidoRepository.findById(id).orElse(null);

        if(obj == null) {
          throw new ObjectNotFoundException("Pedido não encontrado! id:" + id + "| Tipo: " + Cliente.class.getName());
        }
      return obj;
    }
}
