package br.com.backend.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.backend.Produto;

@RepositoryRestResource(collectionResourceRel = "produtos", path = "produtos")
public interface ProdutoCrud extends CrudRepository <Produto,Long> {

}
