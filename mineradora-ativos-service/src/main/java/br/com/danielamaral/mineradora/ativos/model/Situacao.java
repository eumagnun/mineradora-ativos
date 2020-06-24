package br.com.danielamaral.mineradora.ativos.model;

public enum Situacao {
	pendente(1), reprovado(2), aprovado(3);

	private final int valor;

	Situacao(int tipo) {
		valor = tipo;
		}

	public int getValor() {
		return valor;
	}
}
