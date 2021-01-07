package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.repositories.ProdutoRepository;
import com.nelioalves.cursomc.services.serviceException.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

  public ProdutoService(ProdutoRepository produtoRepository) {
    this.produtoRepository = produtoRepository;
  }

  private ProdutoRepository produtoRepository;

  public Produto buscar(Integer id){
    Produto obj = produtoRepository.findById(id).orElse(null);

    if(obj == null) {
      throw new ObjectNotFoundException("Cliente não encontrado! id:" + id + "| Tipo: " + Produto.class.getName());
    }
    return obj;
  }

}
