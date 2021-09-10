package trabalhos;

public class Passageiro {
	private String nome;
	private int codigo;
	private int contato;
	private String destino;
	
	public Passageiro() {
		
	}
	
	public Passageiro(String nome, int codigo, int contato, String destino) {
		this.nome = nome;
		this.codigo = codigo;
		this.contato = contato;
		this.destino = destino;
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getContato() {
		return contato;
	}
	public void setContato(int contato) {
		this.contato = contato;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
}
