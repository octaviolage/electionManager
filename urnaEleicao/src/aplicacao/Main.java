package aplicacao;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws InterruptedException {
		Configuracao.mainMenu();
		mainMenu();
	}

	public static void mainMenu() throws InterruptedException {

		Funcionalidades executa = new Funcionalidades();

		Scanner ler = new Scanner(System.in);
		int repete = 0;
		Long digitou;
		
		while (repete == 0) {
			System.out.println("===== Painel do usuario =====");
			System.out.println();
			System.out.println("      Dados do eleitor ");
			System.out.printf("Informe seu titulo de eleitor:");
			digitou = ler.nextLong();
			

			if(!executa.verificaEleitor(digitou)){
				System.out.println("Seu titulo nao encontra-se nesta sessao. \n Deseja justificar?\n(Sim/Nao): ");
				String resposta = ler.next();
				if(resposta=="Sim")
					executa.eleitorJustifica(digitou);			
				else if(resposta=="Nao")
				mainMenu();

			}

		}
		/*
		votaVereador();
		votaPrefeito();
		*/
	}


/*
	public static void votaVereador(){

		Scanner ler = new Scanner(System.in);
		int repete = 0, aux = 0, voto = 0;

		System.out.println("===== Votação Vereador =====");
		System.out.println();
		while(repete == 0){
				//Busca nome, numero e municipio do vereador
			if(     ){
			System.out.println("Nome: Numero: ");
			
			}
			System.out.println();

			while(aux == 0){
				System.out.printf("Em qual vereador deseja votar: ");
				voto = ler.nextInt();
					//Verificacao
				System.out.printf("Tem certeza que deseja votar em " + "?")
				System.out.println("0- Nao \n1- Sim");
				aux = ler.nextInt();
			}
		}
		//Insere no eleitor a votacao

		
	}

	public static void votaPrefeito(){

		Scanner ler = new Scanner(System.in);
		int repete = 0, aux = 0, voto = 0;

		System.out.println("===== Votação Prefeito =====");
		System.out.println();
		while(repete == 0){
				//Busca nome, numero e municipio do Prefeito
			if(     ){
			System.out.println("Nome: Numero: ");
			
			}
			System.out.println();

			while(aux == 0){
				System.out.printf("Em qual prefeito deseja votar: ");
				voto = ler.nextInt();
					//Verificacao
				System.out.printf("Tem certeza que deseja votar em " + "?")
				System.out.println("0- Nao \n1- Sim");
				aux = ler.nextInt();
			}
		}
		//Insere no eleitor a votacao
*/

	}
