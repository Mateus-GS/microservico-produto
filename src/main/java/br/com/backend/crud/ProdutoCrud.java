package br.com.backend.crud;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import br.com.backend.Produto;

@EnableScan()
public interface ProdutoCrud extends CrudRepository<Produto, String> {
	
	List<Produto> findByDescricao(String descricao);
	
}