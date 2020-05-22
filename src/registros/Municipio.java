package registros;

import arquivos.ArquivoEscrever;
import registros.pilha.Pilha;

public class Municipio extends Registro{

	private String nome;
	private String estado;
	private int habitantes;
	private int vagasVereador;
	private Pilha candidatos = new Pilha();

	public Municipio(String linha) {
		String[] palavra = linha.split("; ");
		this.nome = palavra[0];
		this.estado = palavra[1];
		this.habitantes = Integer.parseInt(palavra[2]);
		this.vagasVereador = Integer.parseInt(palavra[3]);
	}
	
	@Override
	public void exportar() {
		ArquivoEscrever arquivo = new ArquivoEscrever();
		Pilha pilha = candidatos;
		Registro aux = pilha.desempilhar();
		arquivo.abrirArquivo(nome +".txt");
		arquivo.escrever(toString());
		while(aux != null) {
			arquivo.escrever(aux.toString());
			aux = pilha.desempilhar();
		}
		arquivo.fecharArquivo();
		
	}
	
	@Override
	public void setRegistro(Registro candidato) {
		candidatos.empilhar(candidato);
	}
	
	@Override
	public String getComparacao() {
		return nome;
	}
	
	@Override
	public String toString() {
		return nome + "; " + estado + "; " + vagasVereador;
	}
}
