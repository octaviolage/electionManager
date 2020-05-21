package aplicacao;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Arquivo {

	BufferedReader arquivo;
	FileWriter saida;
	Scanner entrada = new Scanner(System.in);

	public void criarArquivo(String nomeArquivo) {

		try {
			saida = new FileWriter(nomeArquivo);
		} catch (IOException excecao) {
			System.out.println("Erro na criacao do arquivo: " + excecao);
		}
	}

	public void abrirArquivo(String nomeArquivo) {

		try {
			arquivo = new BufferedReader(new FileReader(nomeArquivo));
		} catch (FileNotFoundException excecao) {
			System.out.println("O " + nomeArquivo +" não foi encontrado!");
			System.out.println("Digite o nome do arquivo:");
			nomeArquivo = entrada.next();
			abrirArquivo(nomeArquivo);
		}
	}

	public void fecharArquivo() {

		try {
			arquivo.close();
		} catch (IOException excecao) {
			System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);
		}
	}

	public String ler() {

		String linha;

		try {
			linha = arquivo.readLine();
		} catch (EOFException excecao) { // Exceção de final de arquivo.
			return null;
		} catch (IOException excecao) {
			System.out.println("Erro de leitura: " + excecao);
			return null;
		}
		return linha;
	}

	public void escrever(String textoEntrada) {

		try {
			saida.write(textoEntrada);
		} catch (IOException excecao) {
			System.out.println("Erro de entrada/saída " + excecao);
		}
	}

}
