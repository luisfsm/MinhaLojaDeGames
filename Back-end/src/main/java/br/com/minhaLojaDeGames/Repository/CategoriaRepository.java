package br.com.minhaLojaDeGames.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.minhaLojaDeGames.Model.CategoriaModel;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
	
	public List<CategoriaModel> findAllByDistribuidoraContainingIgnoreCase(String distribuidora);
	public List<CategoriaModel> findAllByPlataformaContainingIgnoreCase(String plataforma);
	public List<CategoriaModel> findAllByCategoriaContainingIgnoreCase(String categoria);
}
