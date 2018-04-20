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
		//String letra = "";

		System.out.printf("Informe o nome de arquivo texto:\n");
		// String nome = ler.nextLine();
		String nome = "d:/teste.txt";

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
					tamanhoMatriz = Integer.parseInt(linha); // armazena o matriz
					System.out.println("\nMatriz tamanho = " + tamanhoMatriz);
					System.out.println();
					matriz = new String[tamanhoMatriz][tamanhoMatriz];
				}

				if (linha.length() != 1 && linha.length() != 2 && linha.length() != 0) {
					// entra somente se nao é o tamanho da matriz e linha em branco
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

				// if == 2 estava aqui

				if (linha.length() == 0) {
					
					int numVertice1 = 0;
					
					for (int line1 = 0; line1 < matriz.length; line1++) {
						for (int column2 = 0; column2 < matriz.length; column2++) {
							if (matriz[line1][column2] != null && !matriz[line1][column2].equals("*") && !matriz[line1][column2].equals(".")) {
								numVertice1++;
							}
						}
					}
					
					String[][] vertices;
					vertices =  new String[numVertice1][numVertice1];
					int numVertice = 0;
					
					for (int line = 0; line < matriz.length; line++) {
						for (int column = 0; column < matriz.length; column++) {

							if (matriz[line][column] != null && !matriz[line][column].equals("*") && !matriz[line][column].equals(".")) {
								//System.out.println("Vertice:" + matriz[line][column]);
								vertices[numVertice][0] = matriz[line][column];

								int numPonto = 1;

								for (int columnLine = 0; columnLine < matriz[line].length; columnLine++) {
									if (matriz[line][columnLine].equals(".")) {
										//System.out.print(matriz[line][numPonto]);
										vertices[numVertice][numPonto++] = matriz[line][columnLine];
									}
								}
								numVertice++;
							}
						}
					}
					
					for (int i = 0; i < vertices.length; i++) {
						for (int j = 0; j < vertices.length; j++) {
							System.out.print(vertices[i][j]);
						}
						System.out.println("");
					}
					System.out.println("Terminei de criar os vertices e as ligações");

					System.out.println(linha);
					
					if (linha.length() == 2) {
						String inicio = String.valueOf(linha.charAt(0));
						String fim = String.valueOf(linha.charAt(1));
						System.out.println("Caminho do = " + inicio + " até = " + fim);

						for (int line = 0; line < vertices.length; line++) {
							for (int column = 0; column < vertices.length; column++) {

								if (vertices[line][column] == inicio) {
									for (int columnLine = 1; columnLine < vertices.length; columnLine++) {

										if (vertices[line][columnLine] == fim) {
											System.out.print("  True");
										}
									}

								}
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