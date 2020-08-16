package br.com.danielamaral.mineradora.ativos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.danielamaral.mineradora.ativos.repository.UsuarioRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AutenticacaoService autenticacaoService;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private UsuarioRepository usuarioRepository;

	// Configuracoes de autenticacao
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	// config de autorizacao
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		boolean ligarSeguranca = false;

		if (ligarSeguranca) {
			http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/api/v1/autenticacao", "/actuator/**", "/v2/api-docs", "/configuration/ui",
							"/swagger-resources/**", "/configuration/**", "/swagger-ui.html", "/webjars/**")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.addFilterBefore(new AutenticacaoFilter(tokenService, usuarioRepository),
							UsernamePasswordAuthenticationFilter.class);
		} else {
			http.csrf().disable();
		}
	}

	// config de recursos estaticos
	@Override
	public void configure(WebSecurity web) throws Exception {
	}


}
