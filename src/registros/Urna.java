package registros;

public class Urna extends Registro{

	private String municipio;
	private int zona;
	private int secao;
	
	public Urna(String linha) {
		String[] palavra = linha.split("; ");
		this.municipio = palavra[0];
		this.zona = Integer.parseInt(palavra[1]);
		this.secao = Integer.parseInt(palavra[2]);
	}
	
	@Override
	public String getNome() {
		return Integer.toString(zona)  + Integer.toString(secao);
	}

	public String getMunicipio() {
		return municipio;
	}

	@Override
	public String toString() {
		return municipio + "; " + zona + "; " + secao;
	}
}
