package registros.arvore;

import registros.Registro;

public class Arvore {

	private Nodo raiz;

	public Arvore() {
		raiz = null;
	}

	public Boolean arvoreVazia() {
		return (this.raiz == null) ? true : false;
	}

	private Nodo adicionar(Nodo raizArvore, Registro registro) {
		if (raizArvore == null)
			raizArvore = new Nodo(registro);
		else {
			if (raizArvore.item.getComparacao().compareToIgnoreCase(registro.getComparacao()) > 0)
				raizArvore.esquerda = adicionar(raizArvore.esquerda, registro);
			else {
				if (raizArvore.item.getComparacao().compareToIgnoreCase(registro.getComparacao()) < 0)
					raizArvore.direita = adicionar(raizArvore.direita, registro);
				else
					System.out.println("Registro " + registro.getComparacao() + ", já havia sido cadastrado");
			}
		}
		return raizArvore;
	}

	public void inserir(Registro alunoNovo) {
		this.raiz = adicionar(this.raiz, alunoNovo);
	}

	private Nodo pesquisar(Nodo raizArvore, String nome) {

		if (!arvoreVazia() && raizArvore != null) {
			int controlador = raizArvore.item.getComparacao().compareToIgnoreCase(nome);
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

	public Registro buscar(String nome) {
		if (pesquisar(raiz, nome) != null)
			return pesquisar(raiz, nome).item;
		return null;
	}

	private String arrayNomes(Nodo raizArvore) {
		String aux = "";
		if (!arvoreVazia()) {
			if (raizArvore != null) {
				aux += arrayNomes(raizArvore.esquerda);
				aux += arrayNomes(raizArvore.direita);
				aux += raizArvore.item.getComparacao() + ";";
			}
		}
		return aux;
	}

	public String[] getNomes() {
		return arrayNomes(raiz).split(";");
	}
}
