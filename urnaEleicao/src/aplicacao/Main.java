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
		boolean candidato;
		
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

		}/*
		while(repete == 1){


			System.out.println("****************Votação Vereador****************");
			System.out.println("\n\n\n Informe o numero do vereador escolhido: ");
			candidato = executa.verificaVereador(digitou = ler.nextLong());
			if(!candidato){
				System.out.println("Votando em: Nulo");
				System.out.println("Tem certeza do voto? \n Sim \n Não");
				String resposta = ler.next();
				if(resposta=="Sim"){
					System.out.println("***Voto nulo confirmado.***");
					repete = 2;
				}else if(resposta=="Nao")
					repete = 1;
			}else
				System.out.println("Voto Realizado!");
		}

		while(repete == 2){


			System.out.println("****************Votação Prefeito****************");
			System.out.println("\n\n\n Informe o numero do prefeito escolhido: ");
			candidato = executa.verificaPrefeito(digitou = ler.nextLong());
			if(!candidato){
				System.out.println("Votando em: Nulo");
				System.out.println("Tem certeza do voto? \n Sim \n Não");
				String resposta = ler.next();
				if(resposta=="Sim"){
					System.out.println("***Voto nulo confirmado.***");
					repete = 0;
				}else if(resposta=="Nao")
					repete = 2;				
			}else
				System.out.println("Voto Realizado!");
		
			repete = 0;

		}*/
		mainMenu();

	}


	}
