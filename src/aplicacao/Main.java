package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import registros.*;

public class Main {

	static List<Municipio> municipios = new ArrayList<Municipio>();
	static List<Partido> partidos = new ArrayList<Partido>();

	public static void main(String[] args) throws InterruptedException {

		Scanner ler = new Scanner(System.in);
		int opcao = 0;
		while (opcao >= 0) {
			System.out.println("=====Modulo TRE Eleicoes municipais 2020!=====");
			System.out.println();
			System.out.println("Escolha uma opção abaixo:");
			System.out.println("1- Carregar arquivos para uma nova eleicao");
			System.out.println("2- Apurar votação");
			System.out.println("0- Sair da aplicacao");
			System.out.printf("Sua escolha:");
			opcao = ler.nextInt();
			switch (opcao) {
			case 1:
				cadastroMunicipio();
				cadastroPartido();
				cadastroCandidato();
				cadastroUrna();
				cadastroEleitor();
				break;
			case 0:
				System.exit(1);
			default:
				System.out.println(">>>Opcao inválida!<<<");
				System.out.println("Recarregando...");
				opcao = 0;
				Thread.sleep(3000);
			}

		}

	}

	public static void cadastroMunicipio() {
		Arquivo arquivo = new Arquivo();

		arquivo.abrirArquivo("municipios.txt");
		String buffer = arquivo.ler();
		while (buffer != null) {
			Municipio municipio = new Municipio(buffer);
			municipios.add(municipio);
			buffer = arquivo.ler();
		}
		arquivo.fecharArquivo();
		System.out.println("Municipios cadastrado com sucesso!");
	}

	public static void cadastroCandidato() {
		Arquivo arquivo = new Arquivo();

		arquivo.abrirArquivo("candidatos.txt");
		String buffer = arquivo.ler();
		while (buffer != null) {
			Candidato candidato = new Candidato(buffer);
			for (int i = 0; i < partidos.size(); i++) {
				if (candidato.getPartido() == partidos.get(i).getSigla())
					;
				partidos.get(i).setCandidatos(candidato);
			}
			for (int i = 0; i < municipios.size(); i++) {
				if (candidato.getMunicipio() == municipios.get(i).getNome())
					;
				municipios.get(i).setCandidatos(candidato);
			}
			buffer = arquivo.ler();
		}
		arquivo.fecharArquivo();
		System.out.println("Candidatos cadastrados com sucesso!");
	}

	public static void cadastroEleitor() {
		Arquivo arquivo = new Arquivo();

		arquivo.abrirArquivo("eleitores.txt");
		String buffer = arquivo.ler();
		while (buffer != null) {
			Eleitor eleitor = new Eleitor(buffer);
			for (int i = 0; i < municipios.size(); i++) {
				if (eleitor.getMunicipio() == municipios.get(i).getNome()) {
					for (int j = 0; j < municipios.size(); j++) {
						if (eleitor.getZona() == municipios.get(i).getUrnas().get(j).getZona() 
								& eleitor.getSecao() == municipios.get(i).getUrnas().get(j).getSecao()) {
							municipios.get(i).setEleitorUrna(eleitor, j);
						}
					}
				}
			}
			buffer = arquivo.ler();
		}
		arquivo.fecharArquivo();
		System.out.println("Eleitores cadastrados com sucesso!");
	}

	public static void cadastroPartido() {
		Arquivo arquivo = new Arquivo();

		arquivo.abrirArquivo("partidos.txt");
		String buffer = arquivo.ler();
		while (buffer != null) {
			Partido partido = new Partido(buffer);
			partidos.add(partido);
			buffer = arquivo.ler();
		}
		arquivo.fecharArquivo();
		System.out.println("Partidos cadastrados com sucesso!");
	}

	public static void cadastroUrna() {
		Arquivo arquivo = new Arquivo();

		arquivo.abrirArquivo("urnas.txt");
		String buffer = arquivo.ler();
		while (buffer != null) {
			Urna urna = new Urna(buffer);
			for (int i = 0; i < municipios.size(); i++) {
				if (urna.getMunicipio() == municipios.get(i).getNome()) {
					municipios.get(i).setUrna(urna);
				}
			}
			buffer = arquivo.ler();
		}
		arquivo.fecharArquivo();
		System.out.println("Urnas cadastrados com sucesso!");
	}

}
