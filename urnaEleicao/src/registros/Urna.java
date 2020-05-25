package registros;

import arquivos.ArquivoEscrever;
import registros.lista.Lista;

public class Urna extends Registro{

	private String municipio;
	private int zona;
	private int secao;
	private Lista eleitores = new Lista();
	
	public Urna(String linha) {
		String[] palavra = linha.split(";");
		this.municipio = palavra[0];
		this.zona = Integer.parseInt(palavra[1]);
		this.secao = Integer.parseInt(palavra[2]);
	}
	
	@Override
	public Lista getLista(){
		return eleitores;
	}

	@Override
	public void setRegistro(Registro registro) {
		eleitores.inserir(registro);
	}

	
}
