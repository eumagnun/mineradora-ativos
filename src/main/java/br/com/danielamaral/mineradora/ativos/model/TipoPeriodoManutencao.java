package br.com.danielamaral.mineradora.ativos.model;

public enum TipoPeriodoManutencao {
	quinzenal(1), mensal(2), anual(3);

	private final int valor;

	TipoPeriodoManutencao(int tipo) {
		valor = tipo;
		}

	public int getValor() {
		return valor;
	}
}
