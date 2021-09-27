package br.com.danielamaral.mineradora.ativos.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.danielamaral.mineradora.ativos.model.Usuario;
import br.com.danielamaral.mineradora.ativos.util.LoggerUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${jwt.expiration}")
	private String expiration;

	@Value("${jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authentication) {
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		Usuario u = ((Usuario) authentication.getPrincipal());
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("nome", u.getNome());

		return Jwts.builder().setIssuer("br.com.danielamaral.mineradora.ativos.security").setSubject(u.getId() + "")
				.setIssuedAt(hoje).addClaims(claims).setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public boolean isTokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;

		}

	}

	public Long getIdUsuario(String token) {
		Claims body = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(body.getSubject());
	}
}
