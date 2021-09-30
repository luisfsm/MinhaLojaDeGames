package br.com.minhaLojaDeGames.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="TB_CATEGORIA")
public class CategoriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	

	@Size(min = 3, max =20)
	@NotNull
	private String distribuidora;
	
	@Size(min = 3, max =50)
	@NotNull
	private String plataforma;
	
	@Size(min =3, max=20)
	@NotNull
	private String categoria;
	
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL )
	@JsonIgnoreProperties("categoria")
	private List<ProdutoModel> listaProduto;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDistribuidora() {
		return distribuidora;
	}

	public void setDistribuidora(String distribuidora) {
		this.distribuidora = distribuidora;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public List<ProdutoModel> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<ProdutoModel> listaProduto) {
		this.listaProduto = listaProduto;
	}

	
	
}
