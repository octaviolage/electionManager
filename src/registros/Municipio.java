package registros;

public class Municipio extends Registro{

	private String nome;
	private String estado;
	private int habitantes;
	private int vagasVereador;

	public Municipio(String linha) {
		String[] palavra = linha.split("; ");
		this.nome = palavra[0];
		this.estado = palavra[1];
		this.habitantes = Integer.parseInt(palavra[2]);
		this.vagasVereador = Integer.parseInt(palavra[3]);
	}
	
	@Override
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return nome + "; " + estado + "; " + habitantes + "; " + vagasVereador;
	}
}
