package br.com.backend.rest;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.backend.entidades.Produto;
import br.com.backend.negocio.ProdutoService;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "produto")
public class ProdutoController {
	
	 private final ProdutoService produtoService;

	    public ProdutoController(ProdutoService produtoService){
	        this.produtoService=produtoService;
	    }

	    @GetMapping(value = "")
	    public List<Produto> getProduto(){
	        return produtoService.getProduto();
	    }
	    
	    @GetMapping(value="{id}")
	    public Produto getCotacaoById(@PathVariable String id) throws Exception{
	        if(!ObjectUtils.isEmpty(id)){
	           return produtoService.getProdutoById(id);
	        }
	        throw new Exception("Produto com codigo "+id+" nao encontrada");
	    }

	    @ResponseStatus(HttpStatus.CREATED)
	    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public Produto createProduto(@RequestBody @NotNull Produto produto) throws Exception {
	         return produtoService.saveProduto(produto);
	    }
	    
	    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public Produto updateCotacao(@PathVariable String id, 
	    		@RequestBody @NotNull Produto produto) throws Exception {
	         return produtoService.saveProduto(produto);
	    }

	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    @DeleteMapping(value = "{id}")
	    public boolean updateProduto(@PathVariable String id) throws Exception {
	         produtoService.deleteProduto(id);
	         return true;
	    }
	
	

}
