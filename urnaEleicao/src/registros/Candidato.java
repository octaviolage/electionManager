package registros;

import registros.Registro;

public class Candidato extends Registro{
	
	private String nome;
	private int numero;
	private String municipio;
	private String partido;
	private char cargo;
	
	public Candidato(String linha) {
		String[] palavra = linha.split(";");
		this.nome = palavra[0];
		this.numero = Integer.parseInt(palavra[1]);
		this.partido = palavra[2];
		this.cargo = palavra[3].charAt(0);
	}
	@Override
	public Long getIndice() {
		return Long.valueOf(numero);
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public String toString(){
		return nome + "; " + numero + "; " + partido + "; " + cargo;
	}
}
