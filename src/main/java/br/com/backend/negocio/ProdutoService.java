package br.com.backend.negocio;

import java.lang.invoke.MethodHandles;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;

import br.com.backend.entidades.Produto;
import br.com.backend.persistencia.ProdutoRepository;


@Service
public class ProdutoService {
	
    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    private final ProdutoRepository produtoRepo;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepo=produtoRepository;
    }
    
    public List<Produto> getProduto(){
        if(logger.isInfoEnabled()){
            logger.info("Buscando todos os produtos");
        }
        Iterable<Produto> lista = this.produtoRepo.findAll();
        if (lista == null) {
        	return new ArrayList<Produto>();
        }
        return IteratorUtils.toList(lista.iterator());
    }
    
    public Produto getProdutoById(String id){
        if(logger.isInfoEnabled()){
            logger.info("Buscando Cotacao com o codigo {}",id);
        }
        Optional<Produto> retorno = this.produtoRepo.findById(id);
        if(!retorno.isPresent()){
            throw new RuntimeException("Cotacao com o id "+id+" nao encontrada");
        }
        return retorno.get();
    }
    
    public Produto saveProduto(Produto produto){
        if(logger.isInfoEnabled()){
            logger.info("Salvando o Produto com os detalhes {}",produto.toString());
        }
        return this.produtoRepo.save(produto);
    }
    
    public void deleteProduto(String id){
        if(logger.isInfoEnabled()){
            logger.info("Excluindo o produto com id {}",id);
        }
        this.produtoRepo.deleteById(id);
    }

}
