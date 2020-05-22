package registros;

import arquivos.ArquivoEscrever;
import registros.pilha.Pilha;

public class Urna extends Registro{

	private String municipio;
	private int zona;
	private int secao;
	private Pilha eleitores = new Pilha();
	
	public Urna(String linha) {
		String[] palavra = linha.split("; ");
		this.municipio = palavra[0];
		this.zona = Integer.parseInt(palavra[1]);
		this.secao = Integer.parseInt(palavra[2]);
	}
	
	@Override
	public void exportar() {
		ArquivoEscrever arquivo = new ArquivoEscrever();
		Pilha pilha = eleitores;
		Registro aux = pilha.desempilhar();
		arquivo.abrirArquivo("Urna" + getComparacao() +".txt");
		arquivo.escrever(toString());
		while(aux != null) {
			arquivo.escrever(aux.toString());
			aux = pilha.desempilhar();
		}
		arquivo.fecharArquivo();
		
	}
	
	@Override
	public void setRegistro(Registro eleitor) {
		eleitores.empilhar(eleitor);
	}
	
	@Override
	public String getComparacao() {
		return Integer.toString(zona)  + Integer.toString(secao);
	}

	@Override
	public String toString() {
		return municipio + "; " + zona + "; " + secao;
	}
}
