package simplesmente;
import dados.Item;

public class ListaSimples {
	private No prim;
	private No ult;
	private int quantNos;
	//construtor da classe
	public ListaSimples(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}
	public int getQuantNos(){
		return this.quantNos;
	}
	public No getPrim(){
		return this.prim;
	}
	public No getUlt(){
		return this.ult;
	}
	public void setQuantNos(int novoValor){
		this.quantNos = novoValor;
	}
	public void setPrim(No novoNo){
		this.prim = novoNo;
	}
	public void setUlt(No novoNo){
		this.ult = novoNo;
	}
	public boolean eVazia (){
		return (this.prim == null);
	}
	public void inserirPrimeiro(Item elem){
		No novoNo = new No (elem);
		if (this.eVazia()){
			this.ult = novoNo;
}
		novoNo.setProx(this.prim);
		this.prim = novoNo;
		this.quantNos++;
	}
	public void inserirUltimo (Item elem){
		No novoNo = new No (elem);
		if (this.eVazia()){
			this.prim = novoNo;
		} else {
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}
	public No pesquisarNo (int chave){
		No atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave)){
			atual = atual.getProx();
		}	
		return atual;
	}
	public boolean removerNo (int chave) {
		No atual = this.prim;
		No ant = null;
		if (eVazia()){
			return false;
		} else {
			while ((atual != null)&&(atual.getInfo().getChave()!= chave)){
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
			if (this.prim.getInfo().getChave()==x){
				if (this.prim.getProx()==null){//se for único nó da lista
					this.ult = null;
				}
				//remover o primeiro nó da lista
				this.prim = this.prim.getProx();
				this.quantNos--;
				return true;
			}else{
				No atual = this.prim;
				while ((atual.getProx()!=null)&&
						(atual.getProx().getInfo().getChave()!=x)){
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
		No atual = this.prim;
		while (atual != null){
			msg += atual.getInfo().getChave()+"\n";
			atual = atual.getProx();
		}
		return msg;
	}
	//lista01 número 13
	public double calcularMedia(){
		if(this.eVazia()){
			return 0;
		}else{
			No atual=this.prim;
			double soma=0;
			while(atual!=null){
				soma+=atual.getInfo().getChave();
				atual=atual.getProx();
			}
			return soma/this.quantNos;
		}
	}
	//lista01 número 14
	public int buscarPosicao(int x){
		if(this.eVazia()){
			return -1;
		}else{
			No atual=this.prim;
			int i=1;
			while(atual!=null && atual.getInfo().getChave()<x){
				atual=atual.getProx();
				i++;
			}
		if(atual==null || atual.getInfo().getChave()>x){
			return -1;
		}else{
		return i;
			}
		}
	}
	//lista01 número 15
	public ListaSimples separaLista(int n){
		ListaSimples nova=new ListaSimples();
		if(this.eVazia()){
			return null;
		}else{
			No atual=this.prim;
			int i=1;
			while(atual!=null && atual.getInfo().getChave()!=n){
				atual=atual.getProx();
				i++;
			}
			if(atual==null){
				return null;
			}else{
				nova.setPrim(atual.getProx());
				nova.setUlt(this.ult);
				this.ult=atual;
				this.ult.setProx(null);
				nova.setQuantNos(this.quantNos-i);
				this.quantNos=i;
			}
		}
		return nova;
	}
	//lista01 número 16
	public ListaSimples concatemarListas(ListaSimples l2){
		ListaSimples nova=new ListaSimples();
		if(this.eVazia()||l2.eVazia()){
			return null;
		}else{
			this.ult.setProx(l2.prim);
			nova.setUlt(l2.getUlt());
			nova.setQuantNos(this.quantNos+l2.quantNos);
			this.prim=null;
			this.ult=null;
			this.quantNos=0;
			l2.prim=null;
			l2.ult=null;
			l2.quantNos=0;
		}
		return nova;
	}
	
	public boolean VerificarEstaContido(ListaSimples l2){
		if(!this.eVazia()||l2.eVazia()){
			return false;
		}
		else{
			No atual=this.prim;
			No atual2;
			while(atual!=null){
				atual2 = l2.prim;
				while(atual2!=null && atual.getInfo().getChave()!=atual2.getInfo().getChave()){
					atual2.getProx();
				}
				if(atual2==null){
					return false;
				}
				atual=atual.getProx();
			}
			return true;
		}
	}
}

