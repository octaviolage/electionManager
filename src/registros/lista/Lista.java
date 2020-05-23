package registros.lista;

import registros.Registro;

public class Lista { //Lista duplamente encadeada;

	private Celula primeiro;
	private Celula ultimo;

	public Lista() { // Construtor da lista;
		primeiro = new Celula();
		ultimo = primeiro;
	}

	private Registro pesquisa(Registro registro, Celula inicio, Celula fim) { //Metodo de pesquisa na lista. Confesso que deu um trabalhinho viu...
		Registro aux = null;                                                  //Compara o registro com as extremidades da lista e vai afunilindo recursivamente;
		if (!listaVazia() & inicio != null & fim != null) {
				if (registro.getIndice().equalsIgnoreCase(fim.item.getIndice())) 
					aux = registro;
				else if (registro.getIndice().equalsIgnoreCase(inicio.item.getIndice())) 
					aux = registro;
				else if (inicio == fim) 
					aux = null;
				else
					aux = pesquisa(registro, inicio.direita, fim.esquerda);
			
		}

		return aux;

	}

	public void inserir(Registro registro) { //Metodo para inserir um novo item na lista;
		if (localizar(registro) == null) {
			Celula aux = new Celula();
			ultimo.direita = aux;
			aux.item = registro;
			aux.esquerda = ultimo;
			ultimo = ultimo.direita;
		}
	}

	public Registro localizar(Registro registro) { //Chama a pesquisa passando o "verdadeiro" primeiro item da lista e o ultimo como parametros, além do objeto a ser buscado;
		return pesquisa(registro, primeiro.direita, ultimo);
	}

	public Boolean listaVazia() { //Verifica se a lista esta vazia
		return (primeiro == ultimo) ? true : false;
	}

	private int contaLista() { //Um contador pra auxiliar na exportacao de itens da lista;
		Celula aux = primeiro.direita;
		int cont = 0;
		while (aux != null) {
			cont++;
			aux = aux.direita;
		}
		return cont;
	}

	public Registro[] getRegistro() { //Retorna os itens da lista para que seja possivel a exportacao em arquivo na Funcionalidades;
		Registro[] registros = new Registro[contaLista()];
		Celula aux = primeiro.direita;
		for (int i = 0; i < contaLista(); i++) {
			registros[i] = aux.item;
			aux = aux.direita;
		}
		return registros;
	}
}
