package registros;

import java.util.ArrayList;
import java.util.List;

public class Partido {
	
	private String nome;
	private String sigla;
	private List<Candidato> candidatos = new ArrayList<Candidato>();
	
	public Partido(String linha) {
		String[] palavra = linha.split("; ");
		this.nome = palavra[0];
		this.sigla = palavra[1];
	}
	
	public String getSigla() {
		return this.sigla;
	}
	
	public void setCandidatos(Candidato candidato) {
		this.candidatos.add(candidato);
	}

	@Override
	public String toString() {
		return nome + "; " + sigla;
	}
}
