package trabalhos;

public class NoPass {
	private Passageiro info; // a declara��o do tipo Item est� no capitulo 1
	private NoPass prox;

	public NoPass (Passageiro elem){  // a vari�vel elem cont�m os dados que ser�o armazenados
		this.info = elem;
		this.prox = null; // esta linha � opcional, pois o prox � automaticamente 
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

