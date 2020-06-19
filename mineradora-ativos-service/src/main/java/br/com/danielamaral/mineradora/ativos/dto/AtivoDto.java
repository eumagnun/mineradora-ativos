package br.com.danielamaral.mineradora.ativos.dto;

import java.util.Date;

import br.com.danielamaral.mineradora.ativos.model.Ativo;
import br.com.danielamaral.mineradora.ativos.model.Situacao;
import br.com.danielamaral.mineradora.ativos.model.TipoAtivo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Ativo")
public class AtivoDto {

	@ApiModelProperty(readOnly = true)
	private long id;

	private String descricao;

	private Date dataAquisicao;

	private TipoAtivo tipo;
	
	private Situacao situacao = Situacao.pendente;

	private ControleManutencaoDto controleManutencaoDto;

	public static AtivoDto parseDto(Ativo p) {
		AtivoDto ativoDto = new AtivoDto();
		ativoDto.setId(p.getId());
		ativoDto.setDataAquisicao(p.getDataAquisicao());
		ativoDto.setDescricao(p.getDescricao());
		ativoDto.setTipo(p.getTipo());
		ativoDto.setSituacao(p.getSituacao());
		
		if(p.getControleManutencao() != null) {
			ativoDto.setControleManutencaoDto(ControleManutencaoDto.parseDto(p.getControleManutencao()));
		}
		return ativoDto;
	}
}
