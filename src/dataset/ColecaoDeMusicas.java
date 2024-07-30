package primeiraEntregaMusica;

public interface ColecaoDeMusicas {
	
public void adicionarMusica(Musica musica);
	
	public boolean excluirMusica(String nomeMusica);
	
	public Musica obterMusica(int posicaoMusica);
	
	public int obterTotalDeMusicas();
	
	public boolean trocarPosicaoEntreMusicas(int posicaoDaMusica1, int posicaoDaMusica2);
	
	public boolean alterarMusica(int posicaoMusica, Musica novaMusica);
	
	public String listarMusicas();
	
	public boolean ordenaBolha(Ordenar ordenador);
	
	public boolean ordenaSelecao(Ordenar ordenador);
	
}
