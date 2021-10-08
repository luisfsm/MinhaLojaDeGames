package br.com.minhaLojaDeGames.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="TB_USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Size(min =3)
	private String usuario;
	
	@NotBlank
	@Size(min=8)
	private String senha;

	@OneToMany(mappedBy="usuarios", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuarios")
	private List<ProdutoModel> produtos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<ProdutoModel> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}
	
	
	
	
}
