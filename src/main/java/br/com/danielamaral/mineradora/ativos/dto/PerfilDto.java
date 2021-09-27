package br.com.danielamaral.mineradora.ativos.dto;

import org.springframework.security.core.GrantedAuthority;

public class PerfilDto implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	private String nome;

	@Override
	public String getAuthority() {
		return this.nome;
	}
}
