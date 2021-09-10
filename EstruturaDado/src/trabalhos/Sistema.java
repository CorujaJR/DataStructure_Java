package trabalhos;
import java.util.Scanner;

public class Sistema {
	static Scanner scan=new Scanner(System.in);

	public static void main(String[] args) {
		ListaPass Recife=new ListaPass();
		ListaPass Fortaleza=new ListaPass();
		ListaPass JoaoPessoa=new ListaPass();
		char option;
		do{
			System.out.println("Companhia Aérea de Fernando de Noronha\n\nDestinos:\nRecife\nFortaleza\nJoaoPessoa\n\n\n1 - Apresentar lista de vôo\n2 - Incluir passageiro\n3 - Pesquisar passageiro\n4 - Excluir passageiro\n5 - Transferir passageiro\n6 - Atualizar Destinos\n7 - Sair do programa");
			option=scan.next().charAt(0);
			switch(option){
				case '1':
					System.out.println("Digite o destino do vôo:");
					String voo=scan.next();
					switch(voo){
						case "Recife":
							System.out.println(Recife.toString());
							break;
						case "Fortaleza":
							System.out.println(Fortaleza.toString());	
							break;
						case "JoaoPessoa":
							System.out.println(JoaoPessoa.toString());				
							break;
						default:
							System.out.println("\nDestino não disponível!\n\n\n");
					}
					break;
				case '2':
					System.out.println("Digite o código da passagem");
					int codigo=scan.nextInt();
					System.out.println("Digite o nome do passageiro");
					String nome=scan.next();
					System.out.println("Digite o telefone de contato");
					int contato=scan.nextInt();
					System.out.println("Digite o destino");
					String destino=scan.next();
					Passageiro p=new Passageiro(nome,codigo,contato,destino);
					switch(p.getDestino()){
						case "Recife":
							Recife.inserirUltimo(p);
							System.out.println("\nPassageiro Incluso!\n\nNome: "+Recife.getUlt().getInfo().getNome()+"\nCodigo: "+Recife.getUlt().getInfo().getCodigo()+"\nContato: "+Recife.getUlt().getInfo().getContato()+"\nDestino: "+Recife.getUlt().getInfo().getDestino()+"\n\n\n");
							break;
						case "Fortaleza":
							Fortaleza.inserirUltimo(p);
							System.out.println("\nPassageiro Incluso!\n\nNome: "+Fortaleza.getUlt().getInfo().getNome()+"\nCodigo: "+Fortaleza.getUlt().getInfo().getCodigo()+"\nContato: "+Fortaleza.getUlt().getInfo().getContato()+"\nDestino: "+Fortaleza.getUlt().getInfo().getDestino()+"\n\n\n");
							break;
						case "JoaoPessoa":
							JoaoPessoa.inserirUltimo(p);
							System.out.println("\nPassageiro Incluso!\n\nNome: "+JoaoPessoa.getUlt().getInfo().getNome()+"\nCodigo: "+JoaoPessoa.getUlt().getInfo().getCodigo()+"\nContato: "+JoaoPessoa.getUlt().getInfo().getContato()+"\nDestino: "+JoaoPessoa.getUlt().getInfo().getDestino()+"\n\n\n");
							break;
						default:
							System.out.println("\nDestino não disponível!\n\n\n");
					}
					break;
				case '3':
					System.out.print("Digite o codigo do passageiro: ");
					int codpes=scan.nextInt();
					if(Recife.pesquisarNo(codpes)!=null){
						System.out.println("\n\nNome: "+Recife.pesquisarNo(codpes).getInfo().getNome()+"\nCodigo: "+Recife.pesquisarNo(codpes).getInfo().getCodigo()+"\nContato: "+Recife.pesquisarNo(codpes).getInfo().getContato()+"\nDestino: "+Recife.pesquisarNo(codpes).getInfo().getDestino()+"\n\n\n");
					}else if(Fortaleza.pesquisarNo(codpes)!=null){
						System.out.println("\n\nNome: "+Fortaleza.pesquisarNo(codpes).getInfo().getNome()+"\nCodigo: "+Fortaleza.pesquisarNo(codpes).getInfo().getCodigo()+"\nContato: "+Fortaleza.pesquisarNo(codpes).getInfo().getContato()+"\nDestino: "+Fortaleza.pesquisarNo(codpes).getInfo().getDestino()+"\n\n\n");
					}else if(JoaoPessoa.pesquisarNo(codpes)!=null){
						System.out.println("\n\nNome: "+JoaoPessoa.pesquisarNo(codpes).getInfo().getNome()+"\nCodigo: "+JoaoPessoa.pesquisarNo(codpes).getInfo().getCodigo()+"\nContato: "+JoaoPessoa.pesquisarNo(codpes).getInfo().getContato()+"\nDestino: "+JoaoPessoa.pesquisarNo(codpes).getInfo().getDestino()+"\n\n\n");
					}else{
						System.out.println("\n\nPassageiro não incluso!\n\n\n");
					}
					break;
				case '4':
					System.out.print("Digite o codigo do passageiro que quer excluir: ");
					codpes=scan.nextInt();
					System.out.print("\nDigite o destino do passageiro: ");
					String despes=scan.next();
					switch(despes){
						case "Recife":
							if(Recife.removerNó(codpes)){
								System.out.println("\nPassageiro removido!\n\n\n");
							}else{
								System.out.println("\nPassageiro não encontrado!\n\n\n");
							}
							break;
						case "Fortaleza":
							if(Fortaleza.removerNó(codpes)){
								System.out.println("\nPassageiro removido!\n\n\n");
							}else{
								System.out.println("\nPassageiro não encontrado!\n\n\n");
							}
							break;
						case "JoaoPessoa":
							if(JoaoPessoa.removerNó(codpes)){
								System.out.println("\nPassageiro removido!\n\n\n");
							}else{
								System.out.println("\nPassageiro não encontrado!\n\n\n");
							}
							break;
						default:
							System.out.println("\nDestino não disponível!\n\n\n");
					}
					break;
				case '5':
					System.out.print("Digite o codigo do passageiro que quer transferir: ");
					codpes=scan.nextInt();
					System.out.print("\nDigite o destino do passageiro: ");
					despes=scan.next();
					switch(despes){
						case "Recife":
							if(Recife.pesquisarNo(codpes)!=null){
								p=Recife.pesquisarNo(codpes).getInfo();
								Recife.removerNó(codpes);
								System.out.println("\nDigite o destino que queira transferir:");
								despes=scan.next();
								switch(despes){
								case "Fortaleza":
									p.setDestino(despes);
									Fortaleza.inserirUltimo(p);
									System.out.println("\nPassageiro transferido!\n\n\n");
									break;
								case "JoaoPessoa":
									p.setDestino(despes);
									JoaoPessoa.inserirUltimo(p);
									System.out.println("\nPassageiro transferido!\n\n\n");
									break;
								default:
									System.out.println("\nDestino não disponível!\n\n\n");
								}	
							}else{
								System.out.println("\nPassageiro não encontrado!\n\n\n");
							}
							break;
						case "Fortaleza":
							if(Fortaleza.pesquisarNo(codpes)!=null){
								p=Fortaleza.pesquisarNo(codpes).getInfo();
								Fortaleza.removerNó(codpes);
								System.out.println("\nDigite o destino que queira transferir:");
								despes=scan.next();
								switch(despes){
								case "Recife":
									p.setDestino(despes);
									Recife.inserirUltimo(p);
									System.out.println("\nPassageiro transferido!\n\n\n");
									break;
								case "JoaoPessoa":
									p.setDestino(despes);
									JoaoPessoa.inserirUltimo(p);
									System.out.println("\nPassageiro transferido!\n\n\n");
									break;
								default:
									System.out.println("\nDestino não disponível!\n\n\n");
								}	
							}else{
								System.out.println("\nPassageiro não encontrado!\n\n\n");
							}
							break;
						case "JoaoPessoa":
							if(JoaoPessoa.pesquisarNo(codpes)!=null){
								p=JoaoPessoa.pesquisarNo(codpes).getInfo();
								JoaoPessoa.removerNó(codpes);
								System.out.println("\nDigite o destino que queira transferir:");
								despes=scan.next();
								switch(despes){
								case "Fortaleza":
									p.setDestino(despes);
									Fortaleza.inserirUltimo(p);
									System.out.println("\nPassageiro transferido!\n\n\n");
									break;
								case "Recife":
									p.setDestino(despes);
									Recife.inserirUltimo(p);
									System.out.println("\nPassageiro transferido!\n\n\n");
									break;
								default:
									System.out.println("\nDestino não disponível!\n\n\n");
								}	
							}else{
								System.out.println("\nPassageiro não encontrado!\n\n\n");
							}
							break;
						default:
							System.out.println("\nDestino não disponível!\n\n\n");
					}
					break;
				case '6':
					Recife=Recife.recomecarLista();
					Fortaleza=Fortaleza.recomecarLista();
					JoaoPessoa=JoaoPessoa.recomecarLista();
					break;					
				case '7':
					System.out.println("\n\nEncerrado!");
					break;
				default:
					System.out.println("\n\nOpção Inválida");
			}
		}while(option!='7');
	}
}
