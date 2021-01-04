package com.nelioalves.cursomc.resources;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/")
public class CategoriaResource {

  /*@RequestMapping(method=RequestMethod.GET)
  public String Teste(){
    return "REST funcionando!";
  }*/

  /*@Autowired
  CategoriaService categoriaService;*/

  CategoriaService categoriaService;

  public CategoriaResource(CategoriaService categoriaService) {
    this.categoriaService = categoriaService;
  }

 @GetMapping(value = "categorias/{id}")
  public ResponseEntity<?> Listar(@PathVariable Integer id){

    Categoria obj = categoriaService.buscar(id);

    return ResponseEntity.ok().body(obj);
  }

 /* @RequestMapping(value="/{id}",method = RequestMethod.GET)
  public ResponseEntity<?> find(@PathVariable Integer id){

    Categoria obj = categoriaService.buscar(id);

    return ResponseEntity.ok().body(obj);
  }*/
}
