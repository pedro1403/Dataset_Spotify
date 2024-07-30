package primeiraEntregaMusica;

public class Iterador{
	
No noAtual;
	
	public Iterador(No no) {
		this.noAtual = no;
	}

	public boolean temProximo() {
		if (this.noAtual.getProximo() != null) {
			return true;
		}
		return false;
	}
	
	public void obterProximoElemento() {
		this.noAtual = this.noAtual.getProximo();
	}


}
