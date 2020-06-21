package br.com.danielamaral.mineradora.ativos.dto;

import java.util.Date;

import br.com.danielamaral.mineradora.ativos.model.Ativo;
import br.com.danielamaral.mineradora.ativos.model.Manutencao;
import br.com.danielamaral.mineradora.ativos.model.TipoPeriodoManutencao;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
	
	
	@ApiModelProperty(readOnly = true)
	private long id;
	
	private TipoPeriodoManutencao tipoPeriodoManutencao;
	
	private Date dataPlanejada;
	
	private Date dataRealizada;
	
	private String comentario;
	
	public static ManutencaoDto parseDto(Manutencao p) {
		ManutencaoDto manutencaoDto = new ManutencaoDto();
		manutencaoDto.setId(p.getId());
		manutencaoDto.setDataRealizada(p.getDataPlanejada());
		manutencaoDto.setDataPlanejada(p.getDataRealizada());
		manutencaoDto.setTipoPeriodoManutencao(p.getTipoPeriodoManutencao());
		manutencaoDto.setComentario(p.getComentario());
		return manutencaoDto;
	}
}
