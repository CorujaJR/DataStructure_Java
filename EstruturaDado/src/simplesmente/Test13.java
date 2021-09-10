package simplesmente;
import dados.Item;

public class Test13 {

	public static void main(String[] args) {
		ListaSimples lista=new ListaSimples();
		lista.inserirUltimo(new Item (10));
		lista.inserirUltimo(new Item (20));
		lista.inserirUltimo(new Item (20));
		lista.inserirUltimo(new Item (30));
		System.out.println("a média é "+lista.calcularMedia());
	}

}
