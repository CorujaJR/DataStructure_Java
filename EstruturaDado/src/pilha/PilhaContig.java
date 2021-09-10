package pilha;

import dados.Item;

public class PilhaContig {
	private Item [] info;
	private int topo;

	public PilhaContig(int qte){
		this.topo = 0;
		this.info = new Item [qte];
	}
	public Item getInfo(){
		return this.info[this.topo-1];
	}
	public int getTopo(){
		return this.topo;
	}
	public boolean eVazia(){
		return (this.topo == 0);
	}
	public boolean eCheia(){
		return (this.topo == this.info.length);
	}
	public boolean empilhar (Item elem){
		if (this.eCheia()) 
			return false;
		else {
			this.info[this.topo]= elem;
			this.topo++;
			return true;
		}	
	}
	public Item desempilhar(){
		if (this.eVazia())
			return null;
		else{
			this.topo--;
			return this.info[this.topo];
		}
	}
	public String inverterPalavra(String palavra) {
		if(this.info.length < palavra.length()) {
			return null;
		}else {
			String resposta="";
			for (int i = 0; i < palavra.length(); i++) {
				this.empilhar(new Item(palavra.charAt(i)));
			}
			while(!this.eVazia()) {
				resposta += this.desempilhar().getChave();
			}
			return resposta;
		}	
	}
	public Item[] retireMaisQueDez() {
		Item[] novo = new Item[this.topo];
		if(eVazia()) {
			return null;
		}
		int count=0;
		for (int i = 0; i < this.topo; i++) {
			if(this.info[i].getChave() <= 10) {
				novo[count]=this.info[i];
				count++;
			}
		}
		return novo;
	}
	public int equalPilha(PilhaContig p2) {
		if(this.eVazia() != p2.eVazia()) {
			return 0;
		}else if(this.eVazia()){
			return 1;
		}else if(this.getTopo() != p2.getTopo()) {
			return 0;
		}
		PilhaContig aux1 = new PilhaContig(this.topo);
		PilhaContig aux2 = new PilhaContig(this.topo);
		boolean igual=true;
		while (!this.eVazia() && igual){
			if (this.getInfo().getChave()==p2.getInfo().getChave()){
				aux1.empilhar(this.desempilhar());
				aux2.empilhar(p2.desempilhar());
			}else{
				igual = false;
			}
		}						
		while (!aux1.eVazia()){
			this.empilhar(aux1.desempilhar());
			p2.empilhar(aux2.desempilhar());
		}
		if (igual){
			return 1;
		}else{
			return 0;
		}
	}

}
