package registros;

import registros.Registro;

public class Eleitor extends Registro{ //Classe para criacao de um objeto Eleitor. Mais informacoes no classe Registro;

	private String nome;
	private long titulo;
	private String municipio;
	private int zona;
	private int secao;
	
	public Eleitor(String linha) {
		String[] palavra = linha.split("; ");
		this.nome = palavra[0];
		this.titulo = Long.parseLong(palavra[1]);
		this.municipio = palavra[2];
		this.zona = Integer.parseInt(palavra[3]);
		this.secao = Integer.parseInt(palavra[4]);
	}
	
	@Override
	public String getNome() {
		return nome;
	}
	
	@Override
	public String getIndice() {
		return Long.toString(titulo);
	}
	
	@Override
	public String getAssocia() {
		return Integer.toString(zona) + Integer.toString(secao);
	}

	@Override
	public String toString(){
		return nome + ";" + titulo;
	}
}
