package registros;

import registros.lista.Lista;

public class Registro {  //Classe pai dos demais registros. A heranca e o polimorfismo aplicados economiza bastante codigo =D
	
	public Long getIndice() { //Retorna a variavel que sera usada como indice na ABB ou na Lista;
		return null;
	}
	
	public String getNome() { //Retorna a variavel nome de cada classe (Com excecao da urna);
		return null;
	}
	
	public void setRegistro(Registro registro) { //Adiciona um Registro no Objeto que a chama. Utilizado para agrupar eleitores de uma urna especifica, por exemplo;
	}
	
	public void exportar() { //As classes que possuem esse metodo irao escrever um arquivo com os dados para a leitura do modulo da Urna;
	}

	public Lista getLista(){
		return null;
	}
	
	@Override
	public String toString() { //Retorna uma String particular de cada classe, bem utilizada na escrita em arquivo;
		return null;
	}

	
}
