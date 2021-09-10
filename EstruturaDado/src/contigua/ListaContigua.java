package contigua;
import dados.Item;

public class ListaContigua {
	private int fim;
	private Item [] info; // o tipo Item está declarado no capítulo 1

	public ListaContigua(int qte){
		this.fim = 0;
		this.info = new Item [qte];
	}
	public Item getInfo(int i){
		return this.info[i];
	}
	public void setInfo(int i, Item elem){
		this.info[i]=elem;
	}
	public int getFim(){
		return this.fim;
	}
	public void setFim(int _fim){
		this.fim = _fim;
	}
	public boolean eVazia (){
		return (this.fim == 0);
	}
	public boolean eCheia (){
		return (this.fim == this.info.length);
	}
	public boolean inserirUltimo (Item elem){
		if (this.eCheia()){
			return false;
		} else {
			this.info[this.fim]= elem;
			this.fim++;
			return true;
		}
	}
	public int pesquisarNo (int chave){
		int i = 0;
		while ((i < this.fim) && (this.info[i].getChave()!= chave)){
			i++;
		}
		return i;
	}
	public boolean removerNo (int chave){
		int i = 0;
		while ((i < this.fim) && (this.info[i].getChave()!= chave)){
			i++;
		}
		if (i == this.fim){
			return false;
		}else{
			for (int j = i; j < this.fim-1 ;j++){
				this.info[j] = this.info[j+1];
			}
			this.fim--;	
			return true;
		}
	}	
	public String toString(){
		String msg="";
		for  (int i=0; i < this.fim; i++){
			msg += this.info[i].getChave()+"\n";
		}
		return msg;
	}
	
	//faça metodo para remover todos os valores pares
	public void removerPares(){
		if(!this.eVazia()){
			int i=0;
			while (!this.eVazia() && i<this.fim){
				if(this.info[i].getChave()%2==0){
					for(int j=i; j<this.fim-1; j++){
						this.info[j]=this.info[j+1];
					}
					this.fim--;
				}else{
					i++;
				}
			}
		}
	}
}