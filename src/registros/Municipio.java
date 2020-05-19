package registros;

import java.util.ArrayList;
import java.util.List;


public class Municipio {

	private String nome;
	private String estado;
	private int habitantes;
	private int vagasVereador;
	private List<Candidato> candidatos = new ArrayList<Candidato>();
	private List<Urna> urnas = new ArrayList<Urna>();
	
	public String getNome() {
		return nome;
	}
	
	public void setCandidatos(Candidato candidato) {
		this.candidatos.add(candidato);
	}
	
	public void setUrna(Urna urna) {
		this.urnas.add(urna);
	}
	
	public List<Urna> getUrnas() {
		return this.urnas;
	}
	
	public void setEleitorUrna(Eleitor eleitor, int i) {
		this.urnas.get(i).setEleitores(eleitor);;
	}

	public Municipio(String linha) {
		String[] palavra = linha.split("; ");
		this.nome = palavra[0];
		this.estado = palavra[1];
		this.habitantes = Integer.parseInt(palavra[2]);
		this.vagasVereador = Integer.parseInt(palavra[3]);
	}
	
	@Override
	public String toString() {
		return nome + "; " + estado + "; " + habitantes + "; " + vagasVereador;
	}
}
