package br.com.danielamaral.mineradora.ativos.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value  = "Usuario")
public class UsuarioDto {
	
	private String usuario;
	private String senha;

}
