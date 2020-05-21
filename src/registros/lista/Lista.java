package registros.lista;

import registros.Registro;

public class Lista {

	private Celula primeiro;
	private Celula ultimo;

	public Lista()
	{
		primeiro = new Celula();
		ultimo = primeiro;
	}

	public void inserirFinal(Registro registro)
	{
		Celula aux = new Celula();
		ultimo.proximo = aux;
		aux.item = registro;
		ultimo = ultimo.proximo;
	}

    public Boolean listaVazia()
    {
       return (primeiro == ultimo)?  true:  false;
    }
    
    public void imprimir()
    {
        Celula aux;

        aux = primeiro.proximo;

        if (aux == null)
        {
            System.out.println("A lista de contas-correntes está vazia.");
        }
        else
        {
            while (aux != null)
            {
                System.out.println(aux.item.toString());
                
                aux = aux.proximo;
            }
        }
    }    

    
}
