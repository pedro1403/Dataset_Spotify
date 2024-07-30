package primeiraEntregaMusica;

public class ListaDeMusicas implements ColecaoDeMusicas{
	
	No musicaInicial = null;
	int totalDeElementos = 0;
	Iterador iteradorTroca = null;
	Iterador iteradorObter = null;
	Iterador iteradorAdicionar = null;
	int posicaoIteradorTroca = 0;
	int posicaoIteradorObter = 0;
	
	public ListaDeMusicas(ManipulaDataset manipula) {
		super();
		manipula.lerDoArquivoCsv("/home/pedro/Documents/testeMusica/novoDataset.csv", this);
	}
	
	public void adicionarMusica(Musica musica) {
		
		No novoNo = new No(musica);
			
		if (this.musicaInicial != null) {
			while (this.iteradorAdicionar.temProximo()) {
				this.iteradorAdicionar.obterProximoElemento();
			}
			this.iteradorAdicionar.noAtual.setProximo(novoNo);	
		}
		else {
			this.musicaInicial = novoNo;
			iteradorTroca = new Iterador(this.musicaInicial);
			iteradorAdicionar = new Iterador(this.musicaInicial);
			iteradorObter = new Iterador(this.musicaInicial);
		}
		totalDeElementos++;
	}

	@Override
	public boolean excluirMusica(String nomeMusica) {
		No musicaAtual = this.musicaInicial;
		No musicaAnterior = null;
			
		if (this.musicaInicial != null) {
			while ((musicaAtual.getProximo() != null) && (!nomeMusica.equals(musicaAtual.getMusica().getTrack()))) {
				musicaAnterior = musicaAtual;
				musicaAtual = musicaAtual.getProximo();
			}
			if (nomeMusica.equals(musicaAtual.getMusica().getTrack())) {
				if (musicaAnterior == null) {
					this.musicaInicial = musicaInicial.getProximo();
					
				}
				else {
					musicaAnterior.setProximo(musicaAtual.getProximo());
				}
				this.totalDeElementos--;
				return true;
			}
		}
		return false;
	}

	@Override
	public Musica obterMusica(int posicaoMusica) {

		if (posicaoMusica > this.posicaoIteradorObter) {
			while ((this.iteradorObter.temProximo()) && (posicaoMusica != posicaoIteradorObter)) {
				this.iteradorObter.obterProximoElemento();
				posicaoIteradorObter++;
			}

		} else if ((posicaoMusica < posicaoIteradorObter)) {
			this.iteradorObter.noAtual = this.musicaInicial;
			posicaoIteradorObter = 0;
			while ((this.iteradorObter.temProximo()) && (posicaoMusica != posicaoIteradorObter)) {
				this.iteradorObter.obterProximoElemento();
				posicaoIteradorObter++;
			}

		}
		return this.iteradorObter.noAtual.getMusica();
	}

	@Override
	public int obterTotalDeMusicas() {
		return totalDeElementos;
	}

	@Override
	public boolean trocarPosicaoEntreMusicas(int posicaoDaMusica1, int posicaoDaMusica2) {
		No auxiliar = null;
		No auxiliar2 = null;
		
		try {
			if (posicaoDaMusica1 > this.posicaoIteradorTroca) {
				while ((this.iteradorTroca.temProximo()) && (this.posicaoIteradorTroca != posicaoDaMusica1)) {
					this.iteradorTroca.obterProximoElemento();
					this.posicaoIteradorTroca++;
					auxiliar = this.iteradorTroca.noAtual;
				}			
			}
			
			else if ((posicaoDaMusica1 < this.posicaoIteradorTroca)) {
				this.iteradorTroca.noAtual = this.musicaInicial;
				this.posicaoIteradorTroca = 0;
				while ((this.iteradorTroca.temProximo()) && (this.posicaoIteradorTroca != posicaoDaMusica1)) {
					this.iteradorTroca.obterProximoElemento();
					this.posicaoIteradorTroca++;
					auxiliar = this.iteradorTroca.noAtual;
				}
			} 
			else {
				auxiliar = this.iteradorTroca.noAtual;
			}
			
			if ((auxiliar != null) && (posicaoDaMusica2 > posicaoDaMusica1)) {
				while ((this.iteradorTroca.temProximo()) && (this.posicaoIteradorTroca != posicaoDaMusica2)) {
					this.iteradorTroca.obterProximoElemento();
					this.posicaoIteradorTroca++;
					auxiliar2 = this.iteradorTroca.noAtual;
				}
			}
			else if ((auxiliar != null) && (posicaoDaMusica2 < posicaoDaMusica1)) {
					this.iteradorTroca.noAtual = this.musicaInicial;
					this.posicaoIteradorTroca = 0;
					while (this.posicaoIteradorTroca != posicaoDaMusica2) {
						this.iteradorTroca.obterProximoElemento();
						this.posicaoIteradorTroca++;
						auxiliar2 = this.iteradorTroca.noAtual;
					}
			}
			
			else {
				auxiliar2 = this.iteradorTroca.noAtual;
			}
			
				if (this.posicaoIteradorTroca == posicaoDaMusica2) {
					Musica aux = auxiliar.getMusica();
					auxiliar.setMusica(auxiliar2.getMusica());
					auxiliar2.setMusica(aux);
					return true;
				}
			
		} catch (NullPointerException e) {
			System.out.println("Erro! Apontando pra null!");
		}
		
		return false;
	}

	@Override
	public boolean alterarMusica(int posicaoMusica, Musica novaMusica) {
		No musicaAtual = this.musicaInicial;
		int posicaoAtual = 0;
		
		try {
			if (this.musicaInicial != null) {
				while ((musicaAtual.getProximo() != null) && (posicaoMusica != posicaoAtual)) {
					musicaAtual = musicaAtual.getProximo();
					posicaoAtual++;
				}
				if (posicaoAtual == posicaoMusica) {
					musicaAtual.setMusica(novaMusica);
					return true;
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Erro");
		}
		
		return false;
	}
	
	
	public String listarMusicas () {
		String lista = "";
		Iterador iteradorDaLista = new Iterador(this.musicaInicial);
		while (iteradorDaLista.temProximo()) {
			lista = lista + "\n" + iteradorDaLista.noAtual.getMusica().getTrack();
			iteradorDaLista.obterProximoElemento();
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
