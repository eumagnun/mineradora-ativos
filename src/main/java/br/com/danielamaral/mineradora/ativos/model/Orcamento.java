package br.com.danielamaral.mineradora.ativos.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.danielamaral.mineradora.ativos.dto.OrcamentoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Orcamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nomeFornecedor;

	@ManyToOne(cascade = CascadeType.ALL)
	private Ativo ativo;
	private Double valor;
	private String dataVencimento;
	private Situacao situacaoOrcamento;
	private Date dataAvaliacao;
	private String nomeAvaliador;

	public static Orcamento parseModel(OrcamentoDto p) {
		Orcamento orcamento = new Orcamento();
		orcamento.setId(p.getId());
		orcamento.setSituacaoOrcamento(p.getSituacaoOrcamento());
		orcamento.setAtivo(p.getAtivo());
		orcamento.setDataAvaliacao(p.getDataAvaliacao());
		orcamento.setDataVencimento(p.getDataVencimento());
		orcamento.setNomeAvaliador(p.getNomeAvaliador());
		orcamento.setValor(p.getValor());
		return orcamento;
	}

}
