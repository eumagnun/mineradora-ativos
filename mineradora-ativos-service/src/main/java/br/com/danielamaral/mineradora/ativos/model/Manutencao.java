package br.com.danielamaral.mineradora.ativos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.danielamaral.mineradora.ativos.dto.ManutencaoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Manutencao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private TipoPeriodoManutencao tipoPeriodoManutencao;

	private Date dataPlanejada;

	private Date dataRealizada;
	
	private String comentario;

	public static Manutencao parseModel(ManutencaoDto p) {
		Manutencao manutencao = new Manutencao();
		manutencao.setId(p.getId());
		manutencao.setDataPlanejada(p.getDataPlanejada());
		manutencao.setDataRealizada(p.getDataRealizada());
		manutencao.setTipoPeriodoManutencao(p.getTipoPeriodoManutencao());
		manutencao.setComentario(p.getComentario());
		return manutencao;

	}
}
