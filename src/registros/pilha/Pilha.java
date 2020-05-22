package registros.pilha;

import registros.Registro;

public class Pilha {

	private Celula topo;
	private Celula fundo;

	public void empilhar(Registro registro)
    {
    	Celula aux = new Celula();
    	aux.proximo = topo;
    	aux.item = registro;
        topo = aux;
    }

    public Registro desempilhar()
    {
    	Registro aux = null;

        if (!pilhaVazia())
        {
            aux = topo.item;

            topo = topo.proximo;

        }
        return (aux);
    }

    public Boolean pilhaVazia()
    {
        if (fundo == topo)
            return (true);
        else
            return (false);
    }
}
