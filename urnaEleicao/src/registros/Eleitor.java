package registros;

import registros.Registro;

public class Eleitor extends Registro{

	private String nome;
	private long titulo;
	private String municipio;
	private int zona;
	private int secao;
	
	public Eleitor(String linha) {
		String[] palavra = linha.split(";");
		this.nome = palavra[0];
		this.titulo = Long.parseLong(palavra[1]);
	}
	
	@Override
	public String getNome() {
		return nome;
	}
	
	@Override
	public Long getIndice() {
		return titulo;
	}

	@Override
	public String toString(){
		return nome + "; " + titulo;
	}
}
