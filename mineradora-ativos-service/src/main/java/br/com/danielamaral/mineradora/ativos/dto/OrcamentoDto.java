package br.com.danielamaral.mineradora.ativos.dto;

import java.util.Date;

import br.com.danielamaral.mineradora.ativos.model.Ativo;
import br.com.danielamaral.mineradora.ativos.model.Orcamento;
import br.com.danielamaral.mineradora.ativos.model.Situacao;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value  = "OrcamentoAtivo")
public class OrcamentoDto {
	
	@ApiModelProperty(accessMode = AccessMode.READ_ONLY)
	private long id;
	private Ativo ativo;
	private Double valor=0D;
	
	@ApiModelProperty(example = "2020-12-28")
	private String dataVencimento;
	private Situacao situacaoOrcamento=Situacao.pendente;
	
	@ApiModelProperty(example = "2020-12-28 10:30:00")
	private Date dataAvaliacao;
	private String nomeAvaliador;
	
	
	public static OrcamentoDto parseDto(Orcamento p) {
		OrcamentoDto orcamentoDto = new OrcamentoDto();
		orcamentoDto.setId(p.getId());
		orcamentoDto.setSituacaoOrcamento(p.getSituacaoOrcamento());
		orcamentoDto.setAtivo(p.getAtivo());
		orcamentoDto.setDataAvaliacao(p.getDataAvaliacao());
		orcamentoDto.setDataVencimento(p.getDataVencimento());
		orcamentoDto.setNomeAvaliador(p.getNomeAvaliador());
		orcamentoDto.setValor(p.getValor());
		return orcamentoDto;
	}

}
