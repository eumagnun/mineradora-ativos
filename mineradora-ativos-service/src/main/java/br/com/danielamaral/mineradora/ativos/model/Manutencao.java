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

	private Date dataUltimaManutencao;

	private Date dataProximaManutencao;

	public static Manutencao parseModel(ManutencaoDto p) {
		Manutencao manutencao = new Manutencao();
		manutencao.setId(p.getId());
		manutencao.setDataProximaManutencao(p.getDataProximaManutencao());
		manutencao.setDataUltimaManutencao(p.getDataUltimaManutencao());
		manutencao.setTipoPeriodoManutencao(p.getTipoPeriodoManutencao());
		return manutencao;

	}
}
