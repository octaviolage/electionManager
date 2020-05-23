package registros.arvore;

import registros.Registro;

public class Nodo { //Classe de Nodo da ABB;

	Registro item;
	Nodo direita;
	Nodo esquerda;
	
    public Nodo(Registro registro) { //Construtor do Nodo;
    	item = registro;
    	direita = null;
    	esquerda = null;
    }
}
