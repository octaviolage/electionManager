package registros;

public class Candidato{
	
	private String nome;
	private int numero;
	private String municipio;
	private String partido;
	private char cargo;
	
	public Candidato(String linha) {
		String[] palavra = linha.split("; ");
		this.nome = palavra[0];
		this.numero = Integer.parseInt(palavra[1]);
		this.municipio = palavra[2];
		this.partido = palavra[3];
		this.cargo = palavra[4].charAt(0);
	}
	
	public String getMunicipio() {
		return municipio;
	}

	public String getPartido() {
		return partido;
	}

	@Override
	public String toString(){
		return nome + "; " + numero + "; " + municipio + "; " + partido + "; " + cargo;
	}
}
