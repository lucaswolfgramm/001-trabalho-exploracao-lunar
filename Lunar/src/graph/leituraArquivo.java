package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class leituraArquivo {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int tamanhoMatriz = 0, cont = 0;
		String[][] matriz = null;
		String letra = "";

		System.out.printf("Informe o nome de arquivo texto:\n");
		//String nome = ler.nextLine();
		String nome = "c:/teste.txt";
		Graph<Integer> graph = new Graph<>();
		
		System.out.printf("\nConteúdo do arquivo texto:\n");
		try {
			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine(); // lê a primeira linha
			// a variável "linha" recebe o valor "null" quando o processo
			// de repetição atingir o final do arquivo texto
			while (linha != null) {
				
				

				linha = linha.replaceAll(" ", "");

				if (linha.length() == 1) {
					tamanhoMatriz = Integer.parseInt(linha); // armazena o tamanho da matriz
					System.out.println("\nMatriz tamanho = " + tamanhoMatriz);
					System.out.println();
					matriz = new String[tamanhoMatriz][tamanhoMatriz];
				}

				

				if (linha.length() != 1 && linha.length() != 2 && linha.length() != 0) { 
				//entra somente se nao é o tamanho da matriz e linha em branco
					for (int j2 = 0; j2 < matriz.length; j2++) {
						matriz[cont][j2] = String.valueOf(linha.charAt(j2));
						
						System.out.print(matriz[cont][j2]);
					}
					System.out.println();

					cont++;

					if (cont == tamanhoMatriz) {
						cont = 0;
						System.out.println("\nComeça as procuras da matriz acima:");
					}
				}
				
				

				if (linha.length() == 2) {
					String inicio = String.valueOf(linha.charAt(0));
					String fim = String.valueOf(linha.charAt(1));
					System.out.println("Caminho do = " + inicio + " até = " + fim);
				}
				
				
				if (linha.length() == 0) {
					
					ArrayList<Vertex> listaVertices = new ArrayList<Vertex>();
					
					
					for (int line = 0; line < matriz.length; line++) {
						for (int column = 0; column < matriz.length; column++) {
							if(matriz[line][column] != null && !matriz[line][column].equals("*") && !matriz[line][column].equals(".")) {
								
								Vertex<Integer> novo = graph.addVertex(Integer.parseInt(matriz[line][column]));
								listaVertices.add(novo);
								
								/*for (int i = 0; i < matriz[line].length; i++) {
									if(matriz[line][i] == ".") {
										//String one matriz[line][column].valueOf(0); 
										Vertex<Integer> one = graph.addVertex(0); // GUARDA O ELEMENTO ENCOTRADO
										Vertex<Integer> two = matriz[line][i];
										one.addEdge(two, 20); //FAZ A LIGAÇÃO DE UMA ELEMENTO COM OUTRO
									}
								}*/
								
								
							}
						}
					}
					System.out.println("Terminei de criar os vertices");
					
					for (int line = 0; line < matriz.length; line++) {
						for (int column = 0; column < matriz.length; column++) {
							if(matriz[line][column] != null && !matriz[line][column].equals("*") && matriz[line][column].equals(".")) {
								
								
								Vertex<Integer> verticenaposicao = listaVertices.get(line);
								
								
							}
						}
					}
					
					
					
					
				}
				
				
				

				linha = lerArq.readLine(); // lê da segunda até a última linha
			}

			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
		
		
		
		
		

		System.out.println();
	}
}