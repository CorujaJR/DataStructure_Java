package pilha;

import dados.Item;

public class Test {

	public static void main(String[] args) {
		PilhaContig p1= new PilhaContig(4);
		PilhaContig p2= new PilhaContig(3);
		
		for (int i = 0; i < 4; i++) {
			p1.empilhar(new Item(i));
			p2.empilhar(new Item(i));
		}
		System.out.println(p1.equalPilha(p2));
	}
}
