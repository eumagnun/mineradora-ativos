package br.com.danielamaral.mineradora.ativos.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.danielamaral.mineradora.ativos.dto.AtivoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ativo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String descricao;
	
	private Date dataAquisicao;
	
	private TipoAtivo tipo;
	
	private Situacao situacao = Situacao.pendente;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ControleManutencao controleManutencao;

	public static Ativo parseModel(AtivoDto p) {
		Ativo ativo = new Ativo();
		ativo.setId(p.getId());
		ativo.setDataAquisicao(p.getDataAquisicao());
		ativo.setDescricao(p.getDescricao());
		ativo.setTipo(p.getTipo());
		ativo.setSituacao(p.getSituacao());
		
		if(p.getControleManutencaoDto() != null) {
			ativo.setControleManutencao(ControleManutencao.parseModel(p.getControleManutencaoDto()));
		}
		return ativo;
	}
}
