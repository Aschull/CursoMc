package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.services.serviceException.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

  public ClienteService(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
  }

  ClienteRepository clienteRepository;

  public Cliente buscar(Integer id){
    Cliente obj = clienteRepository.findById(id).orElse(null);

        if(obj == null) {
          throw new ObjectNotFoundException("Cliente não encontrado! id:" + id + "| Tipo: " + Cliente.class.getName());
        }
      return obj;
    }
}
