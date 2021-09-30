package br.com.minhaLojaDeGames.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.minhaLojaDeGames.Model.ProdutoModel;
import br.com.minhaLojaDeGames.Repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository repository;

	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> getAllProdutos(){		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/estoque/positivo")
	public ResponseEntity<List<ProdutoModel>> getProdutosEstoquePositivo(){
		return ResponseEntity.ok(repository.findByAllProdutosEstoquePositivo());
	}
	
	@GetMapping("/estoque/negativo")
	public ResponseEntity<List<ProdutoModel>> getProdutosEstoqueNegativo(){
		return ResponseEntity.ok(repository.findByAllProdutosEstoqueNegativo());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> getProdutoById(@PathVariable("id") long id){
		return repository.findById(id)
			   .map(resposta -> ResponseEntity.ok(resposta))
			   .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/filter/{produto}")
	public ResponseEntity<List<ProdutoModel>> getAllProdutoContaining(@PathVariable("produto") String produto){
		return ResponseEntity.ok(repository.findAllByProdutoContainingIgnoreCase(produto));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoModel> postProduto(@RequestBody ProdutoModel model){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(model));
	}
	
	@PutMapping
	public ResponseEntity<ProdutoModel> putProduto(@RequestBody ProdutoModel model){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(model));
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable("id") long id) {
		repository.deleteById(id);
	}
	
}
