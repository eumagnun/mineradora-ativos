package br.com.danielamaral.mineradora.ativos.dto;

import java.util.Date;

import br.com.danielamaral.mineradora.ativos.model.Ativo;
import br.com.danielamaral.mineradora.ativos.model.Manutencao;
import br.com.danielamaral.mineradora.ativos.model.TipoPeriodoManutencao;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Manutencao")
@EqualsAndHashCode
public class ManutencaoDto {
	
	private long id;
	
	private TipoPeriodoManutencao tipoPeriodoManutencao;
	
	private Date dataUltimaManutencao;
	
	private Date dataProximaManutencao;
	
	public static ManutencaoDto parseDto(Manutencao p) {
		ManutencaoDto manutencaoDto = new ManutencaoDto();
		manutencaoDto.setId(p.getId());
		manutencaoDto.setDataProximaManutencao(p.getDataProximaManutencao());
		manutencaoDto.setDataUltimaManutencao(p.getDataUltimaManutencao());
		manutencaoDto.setTipoPeriodoManutencao(p.getTipoPeriodoManutencao());
		return manutencaoDto;
	}
}
