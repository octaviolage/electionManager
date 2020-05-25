package registros.lista;

import registros.Registro;

public class Celula { //Celula da lista;
	
		Registro item;
		Celula esquerda;
		Celula direita;
		
		Celula(){ // Construtor da celula;
			item = new Registro();
			direita = null;
			esquerda = null;
		}
}
