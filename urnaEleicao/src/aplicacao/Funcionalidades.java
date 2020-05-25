package aplicacao;

import arquivos.ArquivoLer;
import registros.*;
import registros.lista.Lista;
import java.util.Scanner;
import aplicacao.Main;



public class Funcionalidades {

	private Urna urna;
	private Municipio municipio;

	public void importaArquivoUrna() {

			ArquivoLer arquivo = new ArquivoLer();

			arquivo.abrirArquivo("Urna.txt");
			String linha = arquivo.ler();

			urna = new Urna(linha);
			linha = arquivo.ler();

			while (linha != null) {
				Eleitor eleitor = new Eleitor(linha);
				urna.setRegistro(eleitor);
				linha = arquivo.ler();
			}
			arquivo.fecharArquivo();

	}

	public void importaArquivoMunicipio() {

		ArquivoLer arquivo = new ArquivoLer();

		arquivo.abrirArquivo("Municipio.txt");
		String linha = arquivo.ler();

		municipio = new Municipio(linha);
		linha = arquivo.ler();

		while (linha != null) {
			Candidato candidato = new Candidato(linha);
			municipio.setRegistro(candidato);
			linha = arquivo.ler();
		}
		arquivo.fecharArquivo();
	}

	public boolean verificaEleitor(long titulo) {

		Scanner ler = new Scanner(System.in);
		long aux = titulo;
		Lista lista = urna.getLista();

			return (lista.localizar(titulo)==null)? false: true;
	}

	public void eleitorJustifica(Long titulo){
		System.out.println("Sessao justificada!");
		Eleitor eleitor = new Eleitor("Justificado;" + titulo);	
		urna.setRegistro(eleitor);
	}
/*
	public void exportacao() {
		associaDados();
		String[] aux = municipios.getNomes();
		for (int i = 0; i < (aux.length); i++) {
			municipios.buscar(aux[i]).exportar();
		}
		aux = urnas.getNomes();
		for (int i = 0; i < (aux.length); i++) {
			urnas.buscar(aux[i]).exportar();
		}
		System.out.println("Arquivos gerados!");
	}

	private void associaDados() {
		Pilha pilha = eleitores;
		Registro aux = pilha.desempilhar();
		while (aux != null) {
			if (urnas.buscar(aux.getIndice()) != null) {
				urnas.buscar(aux.getIndice()).setRegistro(aux);
			} else
				System.err.println("AVISO: O eleitor " + aux.getNome() + " não entrou na lista"
						+ " porque a urna correspondente nao foi cadastrada.");
			aux = pilha.desempilhar();
		}
		pilha = candidatos;
		aux = pilha.desempilhar();
		while (aux != null) {
			if (municipios.buscar(aux.getIndice()) != null) {
				municipios.buscar(aux.getIndice()).setRegistro(aux);
			} else
				System.err.println("O candidato " + aux.getNome() + " não entrou na lista"
						+ " porque o seguinte municipio nao esta cadastrado: " + aux.getIndice());
			aux = pilha.desempilhar();
		}
	}
	*/

}
