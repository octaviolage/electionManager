package registros;

import arquivos.ArquivoEscrever;
import registros.lista.Lista;

public class Municipio extends Registro{

	private String nome;
	private String estado;
	private int habitantes;
	private int vagasVereador;
	private Lista candidatos = new Lista();

	public Municipio(String linha) {
		String[] palavra = linha.split(";");
		this.nome = palavra[0];
		this.estado = palavra[1];
		this.habitantes = Integer.parseInt(palavra[2]);
		this.vagasVereador = Integer.parseInt(palavra[3]);
	}

}
