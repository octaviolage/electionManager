package registros.arvore;

import registros.Registro;

public class Arvore { //Sim, aproveitamos bastante o codigo disponibilizado hehe;

	private Nodo raiz;

	public Arvore() { //Construtor para inicializar a ABB;
		raiz = null;
	}

	public Boolean arvoreVazia() { //Verifica se a arvore esta vazia;
		return (this.raiz == null) ? true : false;
	}

	private Nodo adicionar(Nodo raizArvore, Registro registro) { //Adiciona um registro na arvore de forma recursiva
		if (raizArvore == null)
			raizArvore = new Nodo(registro);
		else {
			if (raizArvore.item.getIndice().compareToIgnoreCase(registro.getIndice()) > 0)
				raizArvore.esquerda = adicionar(raizArvore.esquerda, registro);
			else {
				if (raizArvore.item.getIndice().compareToIgnoreCase(registro.getIndice()) < 0)
					raizArvore.direita = adicionar(raizArvore.direita, registro);
			}
		}
		return raizArvore;
	}

	public void inserir(Registro alunoNovo) { //Chama o metodo privado de adicionar passando a raiz da arvore e o objeto a ser adicionado como parametros;
		this.raiz = adicionar(this.raiz, alunoNovo);
	}

	private Nodo pesquisar(Nodo raizArvore, String nome) { //Faz a busca na arvore de forma recursiva;

		if (!arvoreVazia() && raizArvore != null) {
			int controlador = raizArvore.item.getIndice().compareToIgnoreCase(nome);
			if (controlador == 0) {
				return raizArvore;
			} else if (controlador < 0) {
				return pesquisar(raizArvore.direita, nome);
			} else {
				return pesquisar(raizArvore.esquerda, nome);
			}

		} else
			return null;
	}

	public Registro buscar(String nome) { //Chama o metodo de pesquisa passando a raiz da arvore e o nome a ser buscado como parametro;
		if (pesquisar(raiz, nome) != null)
			return pesquisar(raiz, nome).item;
		return null;
	}

	private String arrayNomes(Nodo raizArvore) { //Cria uma String como cada "nome" dos itens armazenados na arvore, separando os nomes com ";";
		String aux = "";
		if (!arvoreVazia()) {
			if (raizArvore != null) {
				aux += arrayNomes(raizArvore.esquerda);
				aux += arrayNomes(raizArvore.direita);
				aux += raizArvore.item.getIndice() + ";";
			}
		}
		return aux;
	}

	public String[] getNomes() { //Retorna um vetor de Strings com os nomes dos itens da arvore para serem usados na pesquisa;
		return arrayNomes(raiz).split(";");
	}
}
