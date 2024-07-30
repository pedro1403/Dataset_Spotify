package primeiraEntregaMusica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManipulaDataset {

	public void lerDoArquivoCsv(String csv, ColecaoDeMusicas colecao) {
		
		try {
			BufferedReader readBuffer = new BufferedReader(new FileReader(csv));
			String readLine;

			while ((readLine = readBuffer.readLine()) != null) {
				String[] linhaAtual = new String[7];
				linhaAtual = readLine.split(",");

				Musica music = new Musica(linhaAtual[0], linhaAtual[1], linhaAtual[2], linhaAtual[3],
						linhaAtual[4], linhaAtual[5], linhaAtual[6]);
				colecao.adicionarMusica(music);
			}

			readBuffer.close();
			System.out.println("Leitura Feita!");
		} catch (FileNotFoundException e) {
			System.out.println("Caminho não encontrado!");
		} catch (IOException e) {
			System.out.println("Erro na leitura!");
		}
	}

	public void escreverNoArquivoCsv(String arquivoCSV, ColecaoDeMusicas listaDeMusicas) {

		try {
			FileWriter writeArchive = new FileWriter(arquivoCSV);

			for (int aux = 0; aux < listaDeMusicas.obterTotalDeMusicas(); aux++) {
				if (listaDeMusicas.obterMusica(aux) != null) {
					writeArchive.write(listaDeMusicas.obterMusica(aux).getArtist() + "," + listaDeMusicas.obterMusica(aux).getTrack() + "," + listaDeMusicas.obterMusica(aux).getDanceability() + "," 
				            + listaDeMusicas.obterMusica(aux).getEnergy() + "," + listaDeMusicas.obterMusica(aux).getDuration_min() + "," + listaDeMusicas.obterMusica(aux).getViews() + "," 
							+ listaDeMusicas.obterMusica(aux).getLikes() + "\n");
				}
				else {
					writeArchive.write("Sem música\n");
				}
			}

			writeArchive.flush();
			writeArchive.close();
			System.out.println("Escrita feita!");
		} catch (FileNotFoundException e) {
			System.out.println("Caminho de destino não encontrado!");
		} catch (IOException e) {
			System.out.println("Erro na escrita!");
		} catch (NullPointerException e) {
			System.out.println("Erro na escrita, música está como null!");
		}

	}



}
