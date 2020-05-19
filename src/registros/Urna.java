package registros;

import java.util.ArrayList;
import java.util.List;

public class Urna {

	private String municipio;
	private int zona;
	private int secao;
	private List<Eleitor> eleitores = new ArrayList<Eleitor>();
	
	public Urna(String linha) {
		String[] palavra = linha.split("; ");
		this.municipio = palavra[0];
		this.zona = Integer.parseInt(palavra[1]);
		this.secao = Integer.parseInt(palavra[2]);
	}
	
	public int getZona() {
		return zona;
	}

	public int getSecao() {
		return secao;
	}

	public void setEleitores(Eleitor eleitor) {
		this.eleitores.add(eleitor);
	}

	public String getMunicipio() {
		return municipio;
	}

	@Override
	public String toString() {
		return municipio + "; " + zona + "; " + secao;
	}
}
