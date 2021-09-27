package br.com.danielamaral.mineradora.ativos.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.danielamaral.mineradora.ativos.model.Ativo;
import br.com.danielamaral.mineradora.ativos.model.Situacao;
import br.com.danielamaral.mineradora.ativos.model.TipoAtivo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Ativo")
public class AtivoDto {

	@ApiModelProperty(accessMode = AccessMode.READ_ONLY)
	private long id;

	private String descricao;

	private Date dataAquisicao;

	private TipoAtivo tipo;
	
	private Situacao situacao = Situacao.pendente;

	
	private List<ManutencaoDto> manutencoesDto;
	
	
	public void addManutencao(ManutencaoDto manutencaoDto) {
		if(this.manutencoesDto == null) {
			this.manutencoesDto = new ArrayList<>();
		}
		
		this.manutencoesDto.add(manutencaoDto);
	}
	
	public void removeManutencao(ManutencaoDto manutencaoDto) {
		if(this.manutencoesDto == null) {
			this.manutencoesDto = new ArrayList<>();
		}
		
		this.manutencoesDto.remove(manutencaoDto);
	}

	public static AtivoDto parseDto(Ativo p) {
		AtivoDto ativoDto = new AtivoDto();
		ativoDto.setId(p.getId());
		ativoDto.setDataAquisicao(p.getDataAquisicao());
		ativoDto.setDescricao(p.getDescricao());
		ativoDto.setTipo(p.getTipo());
		ativoDto.setSituacao(p.getSituacao());
		
		if(p.getManutencoes() != null) {
			List<ManutencaoDto> manutencoesDto = new ArrayList<>();
			p.getManutencoes().forEach(m -> manutencoesDto.add(ManutencaoDto.parseDto(m)));
			ativoDto.setManutencoesDto(manutencoesDto);
		}
		return ativoDto;
	}
}
