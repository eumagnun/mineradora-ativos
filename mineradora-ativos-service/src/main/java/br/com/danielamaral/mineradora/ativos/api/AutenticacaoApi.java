package br.com.danielamaral.mineradora.ativos.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielamaral.mineradora.ativos.dto.TokenDto;
import br.com.danielamaral.mineradora.ativos.dto.UsuarioDto;
import br.com.danielamaral.mineradora.ativos.security.TokenService;
import br.com.danielamaral.mineradora.ativos.util.LoggerUtil;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/autenticacao")
public class AutenticacaoApi {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	@CrossOrigin(origins = "*")
	@ApiOperation(value = "autenticar")
	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<TokenDto> autenticar(@RequestBody UsuarioDto usuarioDto) {

		try {
			UsernamePasswordAuthenticationToken passwordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					usuarioDto.getUsuario(), usuarioDto.getSenha());
			Authentication authentication = authenticationManager.authenticate(passwordAuthenticationToken);

			String token = tokenService.gerarToken(authentication);
			System.out.println(token);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		} catch (AuthenticationException e) {
			LoggerUtil.logError("Erro ao logar", AutenticacaoApi.this.toString(), e.getMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().build();

		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.unprocessableEntity().build();
		}
	}

}
