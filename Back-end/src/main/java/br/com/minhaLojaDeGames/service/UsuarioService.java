package br.com.minhaLojaDeGames.service;

import java.nio.charset.Charset;
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
	
	
	public Usuario cadastrarUsuario(Usuario usuario) {
		BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
		String senhaEnconder = enconder.encode(usuario.getSenha());
		usuario.setSenha(senhaEnconder);
		
		return repository.save(usuario); 
	}
	
	public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> user){
		BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByUsuario(user.get().getUsuario());
		
		if(usuario.isPresent()) {
			if(enconder.matches(user.get().getSenha(), usuario.get().getSenha())) {
				String auth = user.get().getUsuario()+" : "+user.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic "+new String(encodeAuth);
				
				user.get().setToken(authHeader);
				user.get().setUsuario(usuario.get().getUsuario());
				return user;
			}
		}
		
		return null;
	}
	
	
}
