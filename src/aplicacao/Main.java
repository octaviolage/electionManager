package aplicacao;

import java.util.Scanner;

public class Main {  //Classe com os menus para interacao do usuario

	public static void main(String[] args) throws InterruptedException {
		
			mainMenu();
	}

	public static void mainMenu() throws InterruptedException { //Aqui o menu principal
		
		Scanner ler = new Scanner(System.in);
		int opcao = 0;
		while (opcao >= 0) {
			limpaTela();
			System.out.println("=====Modulo TRE Eleicoes municipais 2020!=====");
			System.out.println();
			System.out.println("Escolha uma opcao abaixo:");
			System.out.println("1- Carregar arquivos para eleicao");
			System.out.println("2- Apurar votacao");
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
				System.err.println(">>>Opcao invalida!<<<");
				System.out.println("Voltando ao menu principal...");
				Thread.sleep(3000);
				mainMenu();
			}
		}
		
	}
	
public static void cadastrosMenu() throws InterruptedException { //Aqui o menu de cadastro de eleicao
		
		Funcionalidades executa = new Funcionalidades();
		Scanner ler = new Scanner(System.in);
		int opcao = 0;
		while (opcao >= 0) {
			limpaTela();
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
				limpaTela();
				executa.cadastroMunicipio();
				System.out.println("Voltando ao menu anterior...");
				Thread.sleep(3000);
				break;
				
			case 2:
				limpaTela();
				executa.cadastroPartido();
				System.out.println("Voltando ao menu anterior...");
				Thread.sleep(3000);
				break;
				
			case 3:
				limpaTela();
				executa.cadastroUrna();
				System.out.println("Voltando ao menu anterior...");
				Thread.sleep(3000);
				break;
				
			case 4:
				limpaTela();
				executa.cadastroCandidato();
				System.out.println("Voltando ao menu anterior...");
				Thread.sleep(3000);
				break;
				
			case 5:
				limpaTela();
				executa.cadastroEleitor();
				System.out.println("Voltando ao menu anterior...");
				Thread.sleep(3000);
				break;
				
			case 6:
				limpaTela();
				System.out.println("Buscando por arquivo de municipios");
				executa.cadastroMunicipio();
				System.out.println("Buscando por arquivo de partidos");
				executa.cadastroPartido();
				System.out.println("Buscando por arquivo de urnas");
				executa.cadastroUrna();
				System.out.println("Buscando por arquivo de candidatos");
				executa.cadastroCandidato();
				System.out.println("Buscando por arquivo de eleitores");
				executa.cadastroEleitor();
				System.out.println("Voltando ao menu anterior...");
				Thread.sleep(3000);
				break;
				
			case 7:
				limpaTela();
				executa.exportacao();
				System.out.println("Voltando ao menu principal...");
				Thread.sleep(3000);
				break;
				
			case 8:
				mainMenu();
				break;
				
			case 0:
				System.exit(1);
				
			default:
				System.err.println(">>>Opcao invalida!<<<");
				System.out.println("Voltando ao menu principal...");
				Thread.sleep(3000);
				cadastrosMenu();
			}
		}
		
	}

	public static final void limpaTela() { //Gambiarra pra "limpar" a tela. Aparentemente o Java nao dispoe da funcao. Uma alternativa seria adicionar 
		for(int i = 0; i < 50; i++)        //um comando do terminal, mas isso varia de SO para SO. No linux mint, por exemplo, nao funcionou =/
			System.out.println();
	}

}
