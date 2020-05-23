package registros;

import arquivos.ArquivoEscrever;
import registros.lista.Lista;

public class Urna extends Registro{ //Classe para criacao de um objeto Urna. Mais informacoes no classe Registro;

	private String municipio;
	private int zona;
	private int secao;
	private Lista eleitores = new Lista();
	
	public Urna(String linha) {
		String[] palavra = linha.split("; ");
		this.municipio = palavra[0];
		this.zona = Integer.parseInt(palavra[1]);
		this.secao = Integer.parseInt(palavra[2]);
	}

	@Override
	public void exportar() {
		ArquivoEscrever arquivo = new ArquivoEscrever();
		Registro[] aux = eleitores.getRegistro();
		arquivo.abrirArquivo("Urna" + getIndice() +".txt");
		arquivo.escrever(toString());
		for (int i = 0; i < aux.length; i++) {
			arquivo.escrever(aux[i].toString());
		}
		arquivo.fecharArquivo();
		
	}
	@Override
	public void setRegistro(Registro eleitor) {
		eleitores.inserir(eleitor);
	}
	
	@Override
	public String getIndice() {
		return Integer.toString(zona)  + Integer.toString(secao);
	}

	@Override
	public String toString() {
		return municipio + ";" + zona + ";" + secao;
	}
}
