package registros.lista;

import registros.Registro;

public class Celula {
	
		Registro item;
		Celula proximo;
		
		Celula(){
			item = new Registro();
			proximo = null;
		}
}
