package br.com.danielamaral.mineradora.ativos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.danielamaral.mineradora.ativos.dto.ControleManutencaoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ControleManutencao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private TipoPeriodoManutencao tipoPeriodoManutencao;

	private Date dataUltimaManutencao;

	private Date dataProximaManutencao;

	public static ControleManutencao parseModel(ControleManutencaoDto p) {
		ControleManutencao controleManutencao = new ControleManutencao();
		controleManutencao.setId(p.getId());
		controleManutencao.setDataProximaManutencao(p.getDataProximaManutencao());
		controleManutencao.setDataUltimaManutencao(p.getDataUltimaManutencao());
		controleManutencao.setTipoPeriodoManutencao(p.getTipoPeriodoManutencao());
		return controleManutencao;

	}
}
