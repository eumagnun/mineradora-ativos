package br.com.danielamaral.mineradora.ativos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueDto {

	private long id;
	private long quantidade;
	private ManutencaoDto controleManutencaoDto;
}
