package br.com.minhaLojaDeGames.service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.minhaLojaDeGames.Model.Usuario;
import br.com.minhaLojaDeGames.Model.UsuarioLogin;
import br.com.minhaLojaDeGames.Repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repository;
	
	public List<Usuario> listarUsuarios(){

		return repository.findAll();

	}
	
	
	public Optional<Usuario> cadastrarUsuario(Usuario usuario) {
		if (repository.findByUsuario(usuario.getUsuario()).isPresent())
			return Optional.empty();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);

		return Optional.of(repository.save(usuario));
	}
	
	public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> user){
		BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByUsuario(user.get().getUsuario());
		
		if(usuario.isPresent()) {
			if(enconder.matches(user.get().getSenha(), usuario.get().getSenha())) {
				String auth = user.get().getUsuario()+" : "+user.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic "+new String(encodeAuth);
				
				user.get().setId(usuario.get().getId());
				user.get().setNome(usuario.get().getNome());
				user.get().setSenha(usuario.get().getSenha());
				user.get().setToken(authHeader);

				return user;
			}
		}
		
		return Optional.empty();
	}
	
	
}
