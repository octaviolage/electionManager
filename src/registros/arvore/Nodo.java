package registros.arvore;

import registros.Registro;

public class Nodo {

	Registro item;
	Nodo direita;
	Nodo esquerda;
	
    public Nodo(Registro registro) {
    	item = registro;
    	direita = null;
    	esquerda = null;
    }
}
