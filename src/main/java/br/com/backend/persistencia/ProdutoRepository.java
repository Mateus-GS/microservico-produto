package br.com.backend.persistencia;

import java.util.List;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import br.com.backend.entidades.Produto;

@EnableScan()
public interface ProdutoRepository extends CrudRepository<Produto, String> {
	List<Produto> findByDescricao(String descricao);
}
