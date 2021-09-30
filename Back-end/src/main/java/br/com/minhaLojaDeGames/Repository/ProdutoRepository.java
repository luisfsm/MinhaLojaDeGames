package br.com.minhaLojaDeGames.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.minhaLojaDeGames.Model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
	
	public List<ProdutoModel> findAllByProdutoContainingIgnoreCase(String produto);
	
	@Query(value ="SELECT ID, data,preco,produto,estoque_produto,categoria_id FROM TB_PRODUTOS  WHERE estoque_produto > 0", nativeQuery =true )
	public  List<ProdutoModel> findByAllProdutosEstoquePositivo();
	
	@Query(value ="SELECT ID, data,preco,produto,estoque_produto,categoria_id FROM TB_PRODUTOS  WHERE estoque_produto <=0", nativeQuery =true )
	public  List<ProdutoModel> findByAllProdutosEstoqueNegativo();
}
