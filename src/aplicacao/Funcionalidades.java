package aplicacao;

import arquivos.ArquivoLer;
import registros.*;
import registros.arvore.Arvore;
import registros.lista.Lista;

public class Funcionalidades {

	private Arvore municipios = new Arvore();  //Municipios e urnas sao arvores pois terao consulta pra cada candidato e eleitor cadastrados;
	private Arvore urnas = new Arvore();
	private Lista partidos = new Lista();      //Para as demais foi utilizada uma lista duplamente encadeada, para facilitar a buscar por duplicatas;
	private Lista candidatos = new Lista();
	private Lista eleitores = new Lista();

	public void cadastroMunicipio() {          //Os metodos de cadastro leem linha por linha dos arquivos criando objetos e validando entradas;
			ArquivoLer arquivo = new ArquivoLer();
			int cont = 0;
			arquivo.abrirArquivo("municipios.txt");
			String linha = arquivo.ler();
			while (linha != null) {
				Municipio municipio = new Municipio(linha);
				if (municipios.buscar(municipio.getIndice()) == null) {
					municipios.inserir(municipio);
					cont++;
				}
				else
					System.err.println("Municipio " + municipio.getIndice() + ", ja havia sido cadastrado!");
				linha = arquivo.ler();
			}
			arquivo.fecharArquivo();
			System.out.println(cont + " municipios cadastrados!");
	}

	public void cadastroUrna() {
			ArquivoLer arquivo = new ArquivoLer();
			int cont = 0;
			arquivo.abrirArquivo("urnas.txt");
			String linha = arquivo.ler();
			while (linha != null) {
				Urna urna = new Urna(linha);
				if (urnas.buscar(urna.getIndice()) == null) {
					urnas.inserir(urna);
					cont++;
				}
				else
					System.err.println("Urna " + urna.getIndice() + ", ja havia sido cadastrado!");
				linha = arquivo.ler();
			}
			arquivo.fecharArquivo();
			System.out.println(cont + " urnas cadastradas!");
	}

	public void cadastroCandidato() {
			ArquivoLer arquivo = new ArquivoLer();
			int cont = 0;
			arquivo.abrirArquivo("candidatos.txt");
			String linha = arquivo.ler();
			while (linha != null) {
				Candidato candidato = new Candidato(linha);
				if (candidatos.localizar(candidato) == null) {
					candidatos.inserir(candidato);
					cont++;
				}
			else
				System.err.println("Candidato: " + candidato.getNome() + " ja cadastrado!");
			linha = arquivo.ler();
			}
			
			arquivo.fecharArquivo();
			System.out.println(cont + " candidatos cadastrados!");
	}

	public void cadastroEleitor() {
			ArquivoLer arquivo = new ArquivoLer();
			int cont = 0;
			arquivo.abrirArquivo("eleitores.txt");
			String linha = arquivo.ler();
			while (linha != null) {
				Eleitor eleitor = new Eleitor(linha);
				if (eleitores.localizar(eleitor) == null) {
					eleitores.inserir(eleitor);
					cont++;
				}
			else
				System.err.println("Eleitor: " + eleitor.getNome() + " ja cadastrado!");
			linha = arquivo.ler();
			}
			
			arquivo.fecharArquivo();
			System.out.println(cont + " eleitores cadastrados!");
	}

	public void cadastroPartido() {
			ArquivoLer arquivo = new ArquivoLer();
			int cont = 0;
			arquivo.abrirArquivo("partidos.txt");
			String linha = arquivo.ler();
			while (linha != null) {
				Partido partido = new Partido(linha);
				if (partidos.localizar(partido) == null) {
					partidos.inserir(partido);
					cont++;
				}
			else
				System.err.println("Partido: " + partido.getIndice() + " ja cadastrado!");
			linha = arquivo.ler();
			}
			
			arquivo.fecharArquivo();
			System.out.println(cont + " partidos cadastrados!");
	}
	
	public void exportacao() {               //Chama a funcao de associacao e exporta arquivo de cada municipio/urna cadastrada;
		associaDados();
		String[] aux = municipios.getNomes();
		for (int i = 0; i < (aux.length); i++) {
			municipios.buscar(aux[i]).exportar();
		}
		aux = urnas.getNomes();
		for (int i = 0; i < (aux.length); i++) {
			urnas.buscar(aux[i]).exportar();
		}
		System.out.println("Arquivos gerados!");
	}
	
	private void associaDados() {           //Correlaciona candidatos com cidades e eleitores com urnas;
		Registro[] aux = eleitores.getRegistro();
		for(int i = 0; i < aux.length; i++) {
			if (urnas.buscar(aux[i].getAssocia()) != null) {
				urnas.buscar(aux[i].getAssocia()).setRegistro(aux[i]);
			} else
				System.err.println("AVISO: O eleitor " + aux[i].getNome() + " nao entrou na lista"
						+ " porque a urna correspondente nao foi cadastrada.");
		}
		aux = candidatos.getRegistro();
		for(int i = 0; i < aux.length; i++) {
			if (municipios.buscar(aux[i].getAssocia()) != null) {
				municipios.buscar(aux[i].getAssocia()).setRegistro(aux[i]);
			} else
				System.err.println("AVISO: O candidato " + aux[i].getNome() + " nao entrou na lista"
						+ " porque a urna correspondente nao foi cadastrada.");
		}
	}
	
}
