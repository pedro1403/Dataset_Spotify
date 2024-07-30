package primeiraEntregaMusica;

import java.util.Scanner;

public class ProgramaDeMusica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		ManipulaDataset manipula = new ManipulaDataset();
		Ordenar ordenador = new Ordenar();
		ColecaoDeMusicas vetor = null;
		ColecaoDeMusicas lista = null;
		
		while (true) {
			
			System.out.println("Escolha o tipo de dado: ");
			System.out.println("1- Vetor");
			System.out.println("2- Lista Encadeada");
			System.out.println("3- Sair\n");
			
			int escolha = teclado.nextInt();
			
			switch (escolha) {

			case 1: 
				if (vetor == null) {
					vetor = new VetorDeMusicas(manipula, 30000);
				}
				fazerOperacoes(vetor, manipula, ordenador);
				break;

			case 2:
				if (lista == null) {
					lista = new ListaDeMusicas(manipula);
				}
				fazerOperacoes(lista, manipula, ordenador);
				break;

			case 3: 
				System.out.println("Saindo!");
				System.exit(0);

			default:
				System.out.println("Opção inválida!");
				break;
			}
			
		}
			
	}
	
	public static void fazerOperacoes (ColecaoDeMusicas colecao, ManipulaDataset manipula, Ordenar ordenador) {
		Scanner teclado = new Scanner(System.in);
		String nome = "";
		
		while(true) {
			
			System.out.println("Escolha o que quer fazer: ");
			System.out.println("1- Adicionar música");
			System.out.println("2- Excluir música");
			System.out.println("3- Obter música");
			System.out.println("4- Obter total de músicas");
			System.out.println("5- Trocar posição entre músicas");
			System.out.println("6- Alterar música");
			System.out.println("7- Listar músicas");
			System.out.println("8- Ordenar por bolha");
			System.out.println("9- Ordenar por seleção");
			System.out.println("10- Escrever no arquivo");
			System.out.println("11- Retornar a escolha de dados");
			
			teclado.nextLine();
			int escolha = teclado.nextInt();
			
			switch (escolha) {
			
			case 1:
				System.out.println("Digite o nome da música: \n");
				nome = teclado.next();
				Musica musica = new Musica("O testador", nome, "2", "2", "2", "2", "2");
				colecao.adicionarMusica(musica);
				System.out.println("Música " +nome + " adicionada!");
				break;
				
			case 2: 
				System.out.println("Digite o nome da música para exclusão: \n");
				nome = teclado.next();
				colecao.excluirMusica(nome);
				System.out.println("Música excluida!");
				break;
				
			case 3: 
				System.out.println("Digite a posição da música que deseja obter: \n");
				int posicao = teclado.nextInt();
				System.out.println(colecao.obterMusica(posicao).getTrack()+"\n");
				break;
				
			case 4: 
				System.out.println("Total de músicas: " +colecao.obterTotalDeMusicas());
				break;
				
			case 5:
				System.out.println("Digite a posição da primeira música: \n");
				int primeira = teclado.nextInt();
				System.out.println("Digite a posição da segunda música: \n");
				int segunda = teclado.nextInt();
				colecao.trocarPosicaoEntreMusicas(primeira, segunda);
				break;
				
			case 6: 
				System.out.println("Digite a posição da música a ser alterada: \n");
				int altera = teclado.nextInt();
				System.out.println("Digite o nome da música: \n");
				nome = teclado.nextLine();
				Musica musica2 = new Musica("O testador", nome, "2", "2", "2", "2", "2");
				colecao.alterarMusica(altera, musica2);
				break;
				
			case 7: 
				System.out.println(colecao.listarMusicas());
				break;
				
			case 8:
				colecao.ordenaBolha(ordenador);
				break;
				
			case 9: 
				colecao.ordenaSelecao(ordenador);
				break;
				
			case 10:
				manipula.escreverNoArquivoCsv("/home/pedro/Documents/testeMusica/testeDataset.csv", colecao);
				break;
				
			case 11:
				return;
				
				
			default: 
				System.out.println("Opção inválida!");
				
			}
		}
		
		
	
	}

}
