package br.com.danielamaral.mineradora.ativos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Manutencao> manutencoes;
	
	public void addManutencao(Manutencao manutencao) {
		if(this.manutencoes == null) {
			this.manutencoes = new ArrayList<>();
		}
		
		this.manutencoes.add(manutencao);
	}
	
	public void removeManutencao(Manutencao manutencao) {
		if(this.manutencoes == null) {
			this.manutencoes = new ArrayList<>();
		}
		
		this.manutencoes.remove(manutencao);
	}

	public static Ativo parseModel(AtivoDto p) {
		Ativo ativo = new Ativo();
		ativo.setId(p.getId());
		ativo.setDataAquisicao(p.getDataAquisicao());
		ativo.setDescricao(p.getDescricao());
		ativo.setTipo(p.getTipo());
		ativo.setSituacao(p.getSituacao());
		
		if(p.getManutencoesDto() != null) {
			List<Manutencao> manutencoes = new ArrayList<>();
			p.getManutencoesDto().forEach(m -> manutencoes.add(Manutencao.parseModel(m)));
			ativo.setManutencoes(manutencoes);
		}
		return ativo;
	}
}
