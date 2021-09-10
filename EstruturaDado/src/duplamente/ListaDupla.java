package duplamente;
import dados.Item;

public class ListaDupla {
	private NoDupla prim;
	private NoDupla ult;
	private int quantNos;

	public ListaDupla(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}
	public int getQuantNos(){
		return this.quantNos;
	}
	public NoDupla getPrim(){
		return this.prim;
	}
	public NoDupla getUlt(){
		return this.ult;
	}
	public void setQuantNos(int valorNovo){
		 this.quantNos = valorNovo;
	}
	public void setPrim(NoDupla novoNo){
		this.prim = novoNo;
	}
	public void setUlt(NoDupla novoNo){
		this.ult = novoNo;
	}
	public boolean eVazia (){
		return (this.prim == null);
	}
	public void inserirPrimeiro(Item elem){
		NoDupla novoNo = new NoDupla (elem);
		if (this.eVazia())
			this.ult = novoNo;
		else { 
			novoNo.setProx(this.prim);
			this.prim.setAnt(novoNo);
		}
		this.prim = novoNo;
		this.quantNos++;
	}
	public void inserirUltimo (Item elem){
		NoDupla novoNo = new NoDupla (elem);
		if (this.eVazia())
			this.prim = novoNo;
		else { 
			novoNo.setAnt(this.ult);
			this.ult.setProx(novoNo);
		}	
		this.ult = novoNo;
		this.quantNos++;
	}
	public NoDupla pesquisarNo (int chave){
		NoDupla atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave))
			atual = atual.getProx();
		return atual;
	}
	public boolean removerNo (int chave){
		NoDupla atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave()!= chave)){
			atual = atual.getProx();
		}
		if (atual == null)
			return false;
		else 
			if (atual == this.prim){
				this.prim = prim.getProx();
				if (this.prim == null)
					this.ult=null;
				else 
					this.prim.setAnt(null);
			}
			else 
				if (atual == this.ult){
					this.ult = this.ult.getAnt();
					this.ult.setProx(null);
				}
				else {
					atual.getProx().setAnt(atual.getAnt());
					atual.getAnt().setProx(atual.getProx());
				}
		this.quantNos--;
		return true;
	}
	public String toString(){
		String msg="";
		NoDupla atual = this.prim;
		while (atual != null){
			msg += atual.getInfo().getChave()+"\n";
			atual = atual.getProx();
		}
		return msg;
	}
	public void inserirAntesPrimeiro(Item novo){
		if (!this.eVazia()){
			NoDupla novoNo = new NoDupla(novo);
			novoNo.setProx(this.prim);
			this.prim.setAnt(novoNo);
			this.prim = novoNo;
			this.quantNos++;
		}
	}
	public void inserirDepoisUltimo(Item novo){
		if (!this.eVazia()){
			NoDupla novoNo = new NoDupla(novo);
			novoNo.setAnt(this.ult);
			this.ult.setProx(novoNo);
			this.ult = novoNo;
			this.quantNos++;
		}
	}
	//inserir na k-ésima posição	  
	 public boolean inserirKesimo(int k, Item novo){
	 	if(this.eVazia()||k>this.quantNos){
	 		return false;
	 	}else{
	 		NoDupla novoNo = new NoDupla(novo);
	 		if(k == 1){
	 			novoNo.setProx(this.prim);
	 			this.prim.setAnt(novoNo);
	 			this.prim=novoNo;
	 		}else{
	 			NoDupla atual = this.prim;
		 		for(int i=1; i<k; i++){
		 			atual = atual.getProx();
		 		}
	 			novoNo.setAnt(atual.getAnt());
	 			novoNo.setProx(atual);
	 			atual.getAnt().setProx(novoNo);
	 			atual.setAnt(novoNo);
	 		}
	 		this.quantNos++;
	 		return true;
	 	}
	 }
	//remover na k-ésima posição
	 	 public boolean removerKesimo(int k){
	 	if(this.eVazia()||k>this.quantNos){
	 		return false;
	 	}else{
	 		if(k == 1){
	 			if(this.prim == this.ult){
	 				this.prim=null;
	 				this.ult=null;
	 			}else{
	 				this.prim = this.prim.getProx();
	 				this.prim.setAnt(null);
	 			}
	 		}else if(k == quantNos){
	 			this.ult = this.ult.getAnt();
	 			this.ult.setProx(null);
	 		}else{
	 			NoDupla atual = this.prim;
	 			for(int i=1; i<k; i++){
	 				atual = atual.getProx();
	 			}
	 			atual.getProx().setAnt(atual.getAnt());
	 			atual.getAnt().setProx(atual.getProx());
	 		}
	 		this.quantNos--;
	 		return true;
	 	}
	 } 
	 	public int procurarMaior(){
	 		 if (this.eVazia()){
	 		 	return -1;
	 		 }else{
	 		 	int maior=0;
	 		  	NoDupla atual = this.prim;
	 		  	while(atual!=null){
	 		  		if(atual.getInfo().getChave()>maior){
	 		  			maior=atual.getInfo().getChave();
	 		  		}
	 		  	}
	 		  	return maior;
	 		 }
	 	}
		public void transferirEnlatados(ListaDupla L2){
			if (!this.eVazia()){
				while (this.prim != null &&
						this.prim.getInfo().getChave()>1000){
						L2.inserirUltimo(this.prim.getInfo());
						this.prim = this.prim.getProx();
						this.prim.setAnt(null);
						this.quantNos--;
				}
				if (this.prim==null){
					this.ult = null;
				}else{
					NoDupla atual = this.prim.getProx();
					while (atual!=null){
						if (atual.getInfo().getChave()>1000){
							L2.inserirUltimo(atual.getInfo());
							if (atual==this.ult){
								this.ult = this.ult.getAnt();
								this.ult.setProx(null);
							}else{
								atual.getAnt().setProx(atual.getProx());
								atual.getProx().setAnt(atual.getAnt());
							}
							this.quantNos--;
						}						
						atual = atual.getProx();
					}
				}
			}
		}
}

