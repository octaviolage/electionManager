package registros;

import registros.Registro;

public class Partido extends Registro{ //Classe para criacao de um objeto Partido. Mais informacoes no classe Registro;
	
	private String nome;
	private String sigla;
	
	public Partido(String linha) {
		String[] palavra = linha.split("; ");
		this.nome = palavra[0];
		this.sigla = palavra[1];
	}
	
	@Override
	public String getIndice() {
		return sigla;
	}

	@Override
	public String toString() {
		return nome + ";" + sigla;
	}
}
