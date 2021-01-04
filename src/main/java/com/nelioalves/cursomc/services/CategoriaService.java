package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.services.serviceException.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoriaService {

  /*@Autowired
  private CategoriaRepository categoriaRepository;*/

  private CategoriaRepository categoriaRepository;

  public CategoriaService(CategoriaRepository categoriaRepository) {
    this.categoriaRepository = categoriaRepository;
  }

  public Categoria buscar(Integer id){
      Categoria obj = categoriaRepository.findById(id).orElse(null);

      if(obj == null) {
        throw new ObjectNotFoundException("Objeto não encontrado! id:" + id + "| Tipo: " + Categoria.class.getName());
      }

    return obj;
  }
}
