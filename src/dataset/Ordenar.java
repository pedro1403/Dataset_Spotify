package primeiraEntregaMusica;

public class Ordenar{
	
	public void ordenarBolha(ColecaoDeMusicas colecao) {
		int tamanho = colecao.obterTotalDeMusicas();

		for (int i = 0; i < tamanho - 1; i++) {
			System.out.println(i);
			for (int a = 0; a < (tamanho - 1) - i; a++) {
				if (colecao.obterMusica(a).getTrack().compareToIgnoreCase(colecao.obterMusica(a+1).getTrack()) > 0) {
					colecao.trocarPosicaoEntreMusicas(a, a+1);
				}
			}
		}
	}
	
	public void ordenarSelecao(ColecaoDeMusicas colecao) {
		int tamanho = colecao.obterTotalDeMusicas();
		int aux = -1;
		
		for (int a = 0; a < tamanho; a++) {
			Musica menor = colecao.obterMusica(a);
			aux = -1;
			System.out.println(a);
			
			for (int i = a + 1; i < tamanho; i++) {
				if ((colecao.obterMusica(i).getTrack().compareToIgnoreCase(menor.getTrack())) < 0) {
					menor = colecao.obterMusica(i);
					aux = i;
				}
			}
			
			if (aux != -1) {
				colecao.trocarPosicaoEntreMusicas(a, aux);
			}
			
		}
	}

}
