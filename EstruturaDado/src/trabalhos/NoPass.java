package trabalhos;

public class NoPass {
	private Passageiro info; // a declaração do tipo Item está no capitulo 1
	private NoPass prox;

	public NoPass (Passageiro elem){  // a variável elem contém os dados que serão armazenados
		this.info = elem;
		this.prox = null; // esta linha é opcional, pois o prox é automaticamente 
	//definido como null
	}
	public Passageiro getInfo (){
		return this.info;
	}
	public void setInfo(Passageiro elem){
		this.info = elem;
	}
	public NoPass getProx(){
		return this.prox;
	}
	public void setProx(NoPass novoNo){
		this.prox = novoNo;
	}
}

