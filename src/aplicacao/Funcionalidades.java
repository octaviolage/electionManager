package aplicacao;

import arquivos.ArquivoLer;
import registros.*;
import registros.arvore.Arvore;
import registros.pilha.Pilha;

public class Funcionalidades {

	private static Arvore municipios = new Arvore();
	private static Arvore urnas = new Arvore();
	private static Pilha partidos = new Pilha();
	private static Pilha candidatos = new Pilha();
	private static Pilha eleitores = new Pilha();
	private static boolean[] valida = new boolean[5];

	public static void cadastroMunicipio() {
		if (!valida[0]) {
			ArquivoLer arquivo = new ArquivoLer();
			int cont = 0;
			arquivo.abrirArquivo("municipios.txt");
			String linha = arquivo.ler();
			while (linha != null) {
				Municipio municipio = new Municipio(linha);
				municipios.inserir(municipio);
				linha = arquivo.ler();
				cont++;
			}
			arquivo.fecharArquivo();
			System.out.println(cont + " municipios cadastrados!");
			valida[0] = true;
		} else
			System.out.println("Arquivo de municipios já cadastrado!");
	}

	public static void cadastroUrna() {
		if (!valida[1]) {
			ArquivoLer arquivo = new ArquivoLer();
			int cont = 0;
			arquivo.abrirArquivo("urnas.txt");
			String linha = arquivo.ler();
			while (linha != null) {
				Urna urna = new Urna(linha);
				urnas.inserir(urna);
				linha = arquivo.ler();
				cont++;
			}
			arquivo.fecharArquivo();
			System.out.println(cont + " urnas cadastradas!");
			valida[1] = true;
		} else
			System.out.println("Arquivo de urnas já cadastrado!");
	}

	public static void cadastroCandidato() {
		if (!valida[2]) {
			ArquivoLer arquivo = new ArquivoLer();
			int cont = 0;
			arquivo.abrirArquivo("candidatos.txt");
			String linha = arquivo.ler();
			while (linha != null) {
				Candidato candidato = new Candidato(linha);
				candidatos.empilhar(candidato);
				cont++;
				linha = arquivo.ler();
			}
			arquivo.fecharArquivo();
			System.out.println(cont + " candidatos cadastrados!");
			valida[2] = true;
		} else
			System.out.println("Arquivo de candidatos já cadastrado!");
	}

	public static void cadastroEleitor() {
		if (!valida[3]) {
			ArquivoLer arquivo = new ArquivoLer();
			int cont = 0;
			arquivo.abrirArquivo("eleitores.txt");
			String linha = arquivo.ler();
			while (linha != null) {
				Eleitor eleitor = new Eleitor(linha);
				eleitores.empilhar(eleitor);
				linha = arquivo.ler();
				cont++;
			}
			arquivo.fecharArquivo();
			System.out.println(cont + " eleitores cadastrados!");
			valida[3] = true;
		} else
			System.out.println("Arquivo de candidatos já cadastrado!");
	}

	public static void cadastroPartido() {
		if (!valida[4]) {
			ArquivoLer arquivo = new ArquivoLer();
			int cont = 0;
			arquivo.abrirArquivo("partidos.txt");
			String linha = arquivo.ler();
			while (linha != null) {
				Partido partido = new Partido(linha);
				partidos.empilhar(partido);
				linha = arquivo.ler();
				cont++;
			}
			arquivo.fecharArquivo();
			System.out.println(cont + " partidos cadastrados!");
			valida[4] = true;
		} else
			System.out.println("Arquivo de candidatos já cadastrado!");
	}

	public static void exportacao() {
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

	private static void associaDados() {
		Pilha pilha = eleitores;
		Registro aux = pilha.desempilhar();
		while (aux != null) {
			if (urnas.buscar(aux.getComparacao()) != null) {
				urnas.buscar(aux.getComparacao()).setRegistro(aux);
			} else
				System.err.println("AVISO: O eleitor " + aux.getNome() + " não entrou na lista"
						+ " porque a urna correspondente nao foi cadastrada.");
			aux = pilha.desempilhar();
		}
		pilha = candidatos;
		aux = pilha.desempilhar();
		while (aux != null) {
			if (municipios.buscar(aux.getComparacao()) != null) {
				municipios.buscar(aux.getComparacao()).setRegistro(aux);
			} else
				System.err.println("O candidato " + aux.getNome() + " não entrou na lista"
						+ " porque o seguinte municipio nao esta cadastrado: " + aux.getComparacao());
			aux = pilha.desempilhar();
		}
	}

}
