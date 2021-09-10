package trabalhos;

public class ListaPass {
	private NoPass prim;
	private NoPass ult;
	private int quantNos;
	//construtor da classe
	public ListaPass(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}
	public int getQuantNos(){
		return this.quantNos;
	}
	public NoPass getPrim(){
		return this.prim;
	}
	public NoPass getUlt(){
		return this.ult;
	}
	public void setQuantNos(int novoValor){
		this.quantNos = novoValor;
	}
	public void setPrim(NoPass novoNo){
		this.prim = novoNo;
	}
	public void setUlt(NoPass novoNo){
		this.ult = novoNo;
	}
	public boolean eVazia (){
		return (this.prim == null);
	}
	public void inserirPrimeiro(Passageiro elem){
		NoPass novoNo = new NoPass (elem);
		if (this.eVazia()){
			this.ult = novoNo;
}
		novoNo.setProx(this.prim);
		this.prim = novoNo;
		this.quantNos++;
	}
	public void inserirUltimo (Passageiro elem){
		NoPass novoNo = new NoPass (elem);
		if (this.eVazia()){
			this.prim = novoNo;
		} else {
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}
	public NoPass pesquisarNo (int chave){
		NoPass atual = this.prim;
		while ((atual != null) && (atual.getInfo().getCodigo() != chave)){
			atual = atual.getProx();
		}	
		return atual;
	}
	public boolean removerNo (int chave) {
		NoPass atual = this.prim;
		NoPass ant = null;
		if (eVazia()){
			return false;
		} else {
			while ((atual != null)&&(atual.getInfo().getCodigo()!= chave)){
				ant = atual;
				atual = atual.getProx();
			}
			if (atual == null){
				return false;
			}
			else{
				if (atual == this.prim){
					if (this.prim == this.ult){
						this.ult = null;
					}
					this.prim = this.prim.getProx();
				} else {
					if (atual == this.ult){
						this.ult = ant;
					}
					ant.setProx(atual.getProx());
				}
				this.quantNos--;
				return true;
			}
		}
	}
	//outra forma de escrever o método para remover determinado Nó
	public boolean removerNó(int x){
		if (this.eVazia()){
			return false;
		}else{
			if (this.prim.getInfo().getCodigo()==x){
				if (this.prim.getProx()==null){//se for único nó da lista
					this.ult = null;
				}
				//remover o primeiro nó da lista
				this.prim = this.prim.getProx();
				this.quantNos--;
				return true;
			}else{
				NoPass atual = this.prim;
				while ((atual.getProx()!=null)&&
						(atual.getProx().getInfo().getCodigo()!=x)){
					atual = atual.getProx();
				}
				if (atual.getProx()==null){//não achou o valor na lista
					return false;
				}else{
					if (atual.getProx()==this.ult){//se for o último nó
						atual.setProx(null);
						this.ult = atual;
					}else{	//remove o nó no meio da lista
						atual.setProx(atual.getProx().getProx());
					}
					this.quantNos--;
					return true;
				}
			}
		}
	}
	//mostra todo o conteúdo da lista
	public String toString(){
		String msg = "";
		NoPass atual = this.prim;
		while (atual != null){
			msg += "\nNome:"+atual.getInfo().getNome()+"\nCodígo:"+atual.getInfo().getCodigo()+"\nTelefone:"+atual.getInfo().getContato()+"\n\n\n";
			atual = atual.getProx();
		}
		return msg;
	}
	
	public ListaPass recomecarLista(){
		ListaPass novo=new ListaPass();
		this.prim=null;
		this.ult=null;
		return novo;
	}
}