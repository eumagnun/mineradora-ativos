package br.com.danielamaral.mineradora.ativos.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueDto {

	@ApiModelProperty(accessMode = AccessMode.READ_ONLY)
	private long id;
	private long quantidade;
	private ManutencaoDto controleManutencaoDto;
}
