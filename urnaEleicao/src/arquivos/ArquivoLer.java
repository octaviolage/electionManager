package arquivos;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ArquivoLer {

	BufferedReader arquivo;
	Scanner entrada = new Scanner(System.in);

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

}
