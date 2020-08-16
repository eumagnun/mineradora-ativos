package br.com.danielamaral.mineradora.ativos.repository;

import org.springframework.stereotype.Service;

import br.com.danielamaral.mineradora.ativos.model.Usuario;

@Service
public class UsuarioRepository {
	
	public Usuario findById(Long id) {
		if(id==1984) {
			return getUsuario();
		}
		return null;
	}
	
	public Usuario findByUsuario(String usuario) {
		if(usuario!=null && usuario.equals("admin")) {
			return getUsuario();
		}
		return null;
	}
	
	private Usuario getUsuario() {
		Usuario u = new Usuario();
		u.setId(1984L);
		u.setLogin("admin");
		u.setNome("PUC Minas");
		u.setSenha("$2a$10$2ZjaMuilGK8xh.vFin6kH.r9IHi2v5p2J1y2GCzHcaAi/n.8CdVkK");
		
		return u;
	}

}
