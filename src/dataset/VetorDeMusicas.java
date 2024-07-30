package primeiraEntregaMusica;

public class VetorDeMusicas implements ColecaoDeMusicas{
	
	int aux = 0;
	Musica[] vetorArmazenamento;
	
	public VetorDeMusicas(ManipulaDataset manipula, int tamanhoVetor) {
		super();
		this.vetorArmazenamento = new Musica[tamanhoVetor];
		manipula.lerDoArquivoCsv("/home/pedro/Documents/testeMusica/novoDataset.csv", this);
	}

	public void adicionarMusica(Musica musica) {
		try {
			this.vetorArmazenamento[aux] = musica;
			aux++;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Vetor já está cheio!");
		}
	}

	public boolean excluirMusica(String nomeMusica) {
		int contador = 0;
		while ((!nomeMusica.equals(this.vetorArmazenamento[contador].getTrack())) && (contador < aux)) {
			contador++;
		}
		
		if (this.vetorArmazenamento[contador].getTrack().equals(nomeMusica)) {
			for (int cont = contador; cont < aux; cont++) {
				this.vetorArmazenamento[contador] = this.vetorArmazenamento[contador+1];
			}
			this.vetorArmazenamento[aux-1] = null;
			aux--;
			return true;
		}
		return false;
	}

	public Musica obterMusica(int posicaoMusica) {
		return this.vetorArmazenamento[posicaoMusica];
	}

	public int obterTotalDeMusicas() {
		return aux;
	}

	public boolean trocarPosicaoEntreMusicas(int posicaoDaMusica1, int posicaoDaMusica2) {
		Musica auxiliar = this.vetorArmazenamento[posicaoDaMusica1];
		this.vetorArmazenamento[posicaoDaMusica1] = this.vetorArmazenamento[posicaoDaMusica2];
		this.vetorArmazenamento[posicaoDaMusica2] = auxiliar;
		return true;
	}

	public boolean alterarMusica(int posicaoMusica, Musica novaMusica) {
		this.vetorArmazenamento[posicaoMusica] = novaMusica;
		return true;
	}
	
	public String listarMusicas() {
		String lista = "";
		for(int i = 0; i < this.aux; i++) {
			lista = lista + "\n" + this.obterMusica(i).getTrack();
		}	
		return lista;
	}
	
	public boolean ordenaBolha(Ordenar ordenador) {
		ordenador.ordenarBolha(this);
		return true;
	}
	
	public boolean ordenaSelecao(Ordenar ordenador) {
		ordenador.ordenarSelecao(this);
		return true;
	}

}
