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

	private Nodo adicionar(Nodo raizArvore, Registro registro)
    {
        if (raizArvore == null)
            raizArvore = new Nodo(registro);
        else
        {
            if (raizArvore.item.getNome().compareToIgnoreCase(registro.getNome()) > 0)
                raizArvore.esquerda = adicionar(raizArvore.esquerda, registro);
            else
            {
                if (raizArvore.item.getNome().compareToIgnoreCase(registro.getNome()) < 0)
                    raizArvore.direita = adicionar(raizArvore.direita, registro);
                else
                    System.out.println("Registro " + registro.getNome() + ", já havia sido cadastrado");
            }
        }
        return raizArvore;
    }

	public void inserir(Registro alunoNovo) {
		this.raiz = adicionar(this.raiz, alunoNovo);
	}

	public Registro menorNumeroMatricula() {
		Nodo aux = raiz;
		while (aux.esquerda != null) {
			aux = aux.esquerda;
		}
		return aux.item;
	}
/*
	private Nodo pesquisar(Nodo raizArvore, int matricula) {

		if (!arvoreVazia()) {
			if (raizArvore.item.getNumMatricula() == matricula) {
				return raizArvore;
			} else if (raizArvore.item.getNumMatricula() < matricula) {
				return pesquisar(raizArvore.direita, matricula);
			} else {
				return pesquisar(raizArvore.esquerda, matricula);
			}

		} else
			return null;
	}

	public Registro buscar(int matricula) {
		return pesquisar(raiz, matricula).item;
	}
	*/
	
	private void imprimirMenorMaior(Nodo raizArvore) {
    	
    	if(!arvoreVazia()) {
    		if(raizArvore != null){
    			imprimirMenorMaior(raizArvore.esquerda);
    			raizArvore.item.toString();
    			imprimirMenorMaior(raizArvore.direita);
    		}
    	}
    	else
    		System.out.println("Arvore vázia");
    }
    
    public void imprimirEmOrdem() {
    	
    	imprimirMenorMaior(raiz);
    }
}
