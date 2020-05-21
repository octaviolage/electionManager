package registros;

import registros.Registro;

public class Eleitor extends Registro{

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
	
	public String getMunicipio() {
		return municipio;
	}

	public int getZona() {
		return zona;
	}

	public int getSecao() {
		return secao;
	}

	@Override
	public String toString(){
		return nome + "; " + titulo + "; " + municipio + "; " + zona + "; " + secao;
	}
}
