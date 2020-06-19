package br.com.danielamaral.mineradora.ativos.dto;

import java.util.Date;

import br.com.danielamaral.mineradora.ativos.model.Ativo;
import br.com.danielamaral.mineradora.ativos.model.ControleManutencao;
import br.com.danielamaral.mineradora.ativos.model.TipoPeriodoManutencao;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "ControleManutencao")
public class ControleManutencaoDto {
	
	private long id;
	
	private TipoPeriodoManutencao tipoPeriodoManutencao;
	
	private Date dataUltimaManutencao;
	
	private Date dataProximaManutencao;
	
	public static ControleManutencaoDto parseDto(ControleManutencao p) {
		ControleManutencaoDto controleManutencaoDto = new ControleManutencaoDto();
		controleManutencaoDto.setId(p.getId());
		controleManutencaoDto.setDataProximaManutencao(p.getDataProximaManutencao());
		controleManutencaoDto.setDataUltimaManutencao(p.getDataUltimaManutencao());
		controleManutencaoDto.setTipoPeriodoManutencao(p.getTipoPeriodoManutencao());
		return controleManutencaoDto;
	}
}
