package pilha;

import dados.ItemChar;

public class PilhaChar {
	private ItemChar [] info;
	private int topo;

	public PilhaChar(int qte){
		this.topo = 0;
		this.info = new ItemChar [qte];
	}
	public ItemChar getInfo(){
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
	public boolean empilhar (ItemChar elem){
		if (this.eCheia()) 
			return false;
		else {
			this.info[this.topo]= elem;
			this.topo++;
			return true;
		}	
	}
	public ItemChar desempilhar(){
		if (this.eVazia())
			return null;
		else{
			this.topo--;
			return this.info[this.topo];
		}
	}	
	//inverter as letras de uma palavra
	public String inverterPalavra(String palavra){
		if (this.info.length < palavra.length()){
			return null;
		}else{
			String resposta="";
			for (int i=0; i< palavra.length();i++){
				this.empilhar(new ItemChar(palavra.charAt(i)));
			}
			while (!this.eVazia()){
				resposta += this.desempilhar().getChave();
			}
			return resposta;
		}
	}
}
