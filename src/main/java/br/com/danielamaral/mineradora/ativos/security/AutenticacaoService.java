package br.com.danielamaral.mineradora.ativos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.danielamaral.mineradora.ativos.model.Usuario;
import br.com.danielamaral.mineradora.ativos.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioRepository.findByUsuario(username);
		if (username.equals(usuario.getLogin())) {
			return usuario;
		}

		throw new UsernameNotFoundException("Dados inválidos!");
	}

}
