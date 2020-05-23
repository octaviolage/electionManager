package registros;

import arquivos.ArquivoEscrever;
import registros.lista.Lista;

public class Municipio extends Registro{ //Classe para criacao de um objeto Municipio. Mais informacoes no classe Registro;

	private String nome;
	private String estado;
	private int habitantes;
	private int vagasVereador;
	private Lista candidatos = new Lista();

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
		Registro[] aux = candidatos.getRegistro();
		arquivo.abrirArquivo(nome +".txt");
		arquivo.escrever(toString());
		for(int i = 0; i < aux.length; i++) {
			arquivo.escrever(aux[i].toString());
		}
		arquivo.fecharArquivo();
		
	}
	
	@Override
	public void setRegistro(Registro candidato) {
		candidatos.inserir(candidato);
	}
	@Override
	public String getIndice() {
		return nome;
	}
	
	@Override
	public String toString() {
		return nome + ";" + estado + ";" + vagasVereador;
	}
}
