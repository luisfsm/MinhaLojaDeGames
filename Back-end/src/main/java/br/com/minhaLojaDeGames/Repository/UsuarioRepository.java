package br.com.minhaLojaDeGames.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.minhaLojaDeGames.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByUsuario(String usuario);
}
