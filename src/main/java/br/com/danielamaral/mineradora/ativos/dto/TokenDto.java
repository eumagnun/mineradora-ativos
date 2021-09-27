package br.com.danielamaral.mineradora.ativos.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel(value  = "Token")
public class TokenDto {
	
	
	private String token;
	private String tipo;

}
