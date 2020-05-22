package registros;

import registros.Registro;

public class Partido extends Registro{
	
	private String nome;
	private String sigla;
	
	public Partido(String linha) {
		String[] palavra = linha.split("; ");
		this.nome = palavra[0];
		this.sigla = palavra[1];
	}

	@Override
	public String toString() {
		return nome + "; " + sigla;
	}
}
