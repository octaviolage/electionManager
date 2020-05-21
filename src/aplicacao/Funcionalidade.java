package aplicacao;

import java.util.ArrayList;
import java.util.List;

import registros.*;
import registros.arvore.Arvore;
import registros.lista.Lista;

public class Funcionalidade {

	static Arvore municipios = new Arvore();
	static Arvore urnas = new Arvore();
	static Lista partidos = new Lista();
	static Lista candidatos = new Lista();
	static Lista eleitores = new Lista();
	
	
	public static void cadastroMunicipio() {
		Arquivo arquivo = new Arquivo();
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
	}
	
	public static void cadastroUrna() {
		Arquivo arquivo = new Arquivo();
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
	}

	public static void cadastroCandidato() {
		Arquivo arquivo = new Arquivo();
		int cont = 0;
		arquivo.abrirArquivo("candidatos.txt");
		String linha = arquivo.ler();
		while (linha != null) {
			Candidato candidato = new Candidato(linha);
			candidatos.inserirFinal(candidato);
			cont++;
			linha = arquivo.ler();
		}
		arquivo.fecharArquivo();
		System.out.println(cont + " candidatos cadastrados!");
	}

	public static void cadastroEleitor() {
		Arquivo arquivo = new Arquivo();
		int cont = 0;
		arquivo.abrirArquivo("eleitores.txt");
		String linha = arquivo.ler();
		while (linha != null) {
			Eleitor eleitor = new Eleitor(linha);
			eleitores.inserirFinal(eleitor);
			linha = arquivo.ler();
			cont++;
		}
		arquivo.fecharArquivo();
		System.out.println(cont + " eleitores cadastrados!");
	}

	public static void cadastroPartido() {
		Arquivo arquivo = new Arquivo();
		int cont = 0;
		arquivo.abrirArquivo("partidos.txt");
		String linha = arquivo.ler();
		while (linha != null) {
			Partido partido = new Partido(linha);
			partidos.inserirFinal(partido);
			linha = arquivo.ler();
			cont++;
		}
		arquivo.fecharArquivo();
		System.out.println(cont + " partidos cadastrados!");
	}
	
	public static void exportar() {
		eleitores.imprimir();
	}
	
	private static void associaDados() {
		
	}

}
