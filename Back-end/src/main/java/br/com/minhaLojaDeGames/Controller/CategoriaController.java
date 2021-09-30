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
import org.springframework.web.servlet.function.EntityResponse;

import br.com.minhaLojaDeGames.Model.CategoriaModel;
import br.com.minhaLojaDeGames.Repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
	
	@Autowired
	CategoriaRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> getAllCategoria(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> getByIdCategoria(@PathVariable long id){
		return repository.findById(id)
			   .map(resposta -> ResponseEntity.ok(resposta))
			   .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/listcategoria/{categoria}")
	public ResponseEntity<List<CategoriaModel>> getAllContainingCategoria(@PathVariable("categoria") String categoria){
	
		return ResponseEntity.ok(repository.findAllByCategoriaContainingIgnoreCase(categoria));
	}
	
	@GetMapping("/plataforma/{plataforma}")
	public ResponseEntity<List<CategoriaModel>> getAllContaingPlataforma(@PathVariable("plataforma") String platafroma){
		return ResponseEntity.ok(repository.findAllByPlataformaContainingIgnoreCase(platafroma));
	}
	
	@GetMapping("/distribuidora/{distribuidora}")
	public ResponseEntity<List<CategoriaModel>> getAllContainingPlataforma(@PathVariable("distribuidora") String distribuidora){
		return ResponseEntity.ok(repository.findAllByDistribuidoraContainingIgnoreCase(distribuidora));
	}
	
	
	@PostMapping
	public ResponseEntity<CategoriaModel> postCategoria(@RequestBody CategoriaModel model){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(model));
	}

	
	@PutMapping
	public ResponseEntity<CategoriaModel> putCategoria(@RequestBody CategoriaModel model){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(model));
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
