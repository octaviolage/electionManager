package aplicacao;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
			mainMenu();
	}

	public static void mainMenu() throws InterruptedException {
		
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
				cadastrosMenu();
				break;
				
			case 2:

				break;
				
			case 0:
				System.exit(1);
				
			default:
				System.out.println(">>>Opcao inválida!<<<");
				System.out.println("Voltando ao menu principal...");
				Thread.sleep(3000);
				mainMenu();
			}
		}
		
	}
	
public static void cadastrosMenu() throws InterruptedException {
		
		Scanner ler = new Scanner(System.in);
		int opcao = 0;
		while (opcao >= 0) {
			System.out.println("=====Cadastro de novas eleicoes=====");
			System.out.println();
			System.out.println("Escolha o que deseja cadastrar:");
			System.out.println("1- Municipios");
			System.out.println("2- Partidos");
			System.out.println("3- Urnas");
			System.out.println("4- Candidatos");
			System.out.println("5- Eleitores");
			System.out.println("6- Sequencia completa");
			System.out.println("7- Exportar aquivos p/ urnas");
			System.out.println("8- Voltar ao menu principal");
			System.out.println("0- Sair da aplicacao");
			System.out.printf("Sua escolha:");
			opcao = ler.nextInt();
			switch (opcao) {
			case 1:
				Funcionalidade.cadastroMunicipio();
				System.out.println("Voltando ao menu anterior...");
				Thread.sleep(3000);
				break;
				
			case 2:
				Funcionalidade.cadastroPartido();
				System.out.println("Voltando ao menu anterior...");
				Thread.sleep(3000);
				break;
				
			case 3:
				Funcionalidade.cadastroUrna();
				System.out.println("Voltando ao menu anterior...");
				Thread.sleep(3000);
				break;
				
			case 4:
				Funcionalidade.cadastroCandidato();
				System.out.println("Voltando ao menu anterior...");
				Thread.sleep(3000);
				break;
				
			case 5:
				Funcionalidade.cadastroEleitor();
				System.out.println("Voltando ao menu anterior...");
				Thread.sleep(3000);
				break;
				
			case 6:
				System.out.println("Buscando por arquivo de municipios");
				Funcionalidade.cadastroMunicipio();
				System.out.println("Buscando por arquivo de partidos");
				Funcionalidade.cadastroPartido();
				System.out.println("Buscando por arquivo de urnas");
				Funcionalidade.cadastroUrna();
				System.out.println("Buscando por arquivo de candidatos");
				Funcionalidade.cadastroCandidato();
				System.out.println("Buscando por arquivo de eleitores");
				Funcionalidade.cadastroEleitor();
				break;
				
			case 7:
				Funcionalidade.exportar();
				break;
				
			case 8:
				mainMenu();
				break;
				
			case 0:
				System.exit(1);
				
			default:
				System.out.println(">>>Opcao inválida!<<<");
				System.out.println("Voltando ao menu principal...");
				Thread.sleep(3000);
				cadastrosMenu();
			}
		}
		
	}

}
