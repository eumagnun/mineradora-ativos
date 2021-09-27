package br.com.danielamaral.mineradora.ativos.model;

public enum TipoAtivo {
	veiculo(1), movel(2), eletronico(3), imovel(4);

	private final int valor;

	TipoAtivo(int tipo) {
		valor = tipo;
		}

	public int getValor() {
		return valor;
	}
}
