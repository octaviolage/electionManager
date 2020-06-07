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

		long aux = titulo;
		Lista lista = new Lista();
		boolean teste;
		teste = urna.getLista().existeItemLista(titulo);
		return teste;
	}

	public void eleitorJustifica(Long titulo){
		System.out.println("Sessao justificada!");
		Eleitor eleitor = new Eleitor("Justificado;" + titulo);	
		urna.setRegistro(eleitor);
	}
/*
			//AINDA NAO FUNCIONAL

	public boolean verificaVereador(Long numero){
		long aux = numero;
		
		if(numero == Candidato.Vereador.getnumero){
			System.out.println("\n\n\nDeseja votar em:" + Candidato.getNome + "?");
			System.out.println("Tem certeza do voto? \n Sim \n Não");
				String resposta = ler.next();
				if(resposta=="Sim")
					return true;
				else if(resposta=="Nao")
					verificaVereador(aux);	
		}else
			return false;
	}
			
	//AINDA NAO FUNCIONAL

	public boolean verificaPrefeito(Long numero){
		long aux = numero;

		if(numero == Candidato.Prefeito.getnumero){
			System.out.println("\n\n\nDeseja votar em:" + Candidato.getNome + "?");
			System.out.println("Tem certeza do voto? \n Sim \n Não");
				String resposta = ler.next();
				if(resposta=="Sim")
					return true;
				else if(resposta=="Nao")
					verificaVereador(aux);	
		}else 
			return false;
		
	}
*/
}
