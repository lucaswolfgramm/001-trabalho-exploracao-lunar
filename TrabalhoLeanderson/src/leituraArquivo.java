import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
 
public class leituraArquivo {
 
  public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
    int tamanhoMatriz = 0, cont = 0;
    String [][] matriz;
    String letra = "";
    
    System.out.printf("Informe o nome de arquivo texto:\n");
    String nome = ler.nextLine();
 
    System.out.printf("\nConteúdo do arquivo texto:\n");
    try {
      FileReader arq = new FileReader(nome);
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine(); // lê a primeira linha
// a variável "linha" recebe o valor "null" quando o processo
// de repetição atingir o final do arquivo texto
      while (linha != null) {
        //System.out.printf("%s\n", linha);
    	
    	linha = linha.replaceAll(" ","");  
    	  
        if(linha.length() == 1) {
        	tamanhoMatriz = Integer.parseInt(linha); //armazena o tamanho da matriz
        	System.out.println("\nMatriz tamanho = " + tamanhoMatriz);
        	System.out.println();
        }
        
        matriz = new String[tamanhoMatriz][tamanhoMatriz];
        
        if(linha.length() != 1 && linha.length() != 2 && linha.length() != 0) { //entra somente se nao é o tamanho da matriz e linha em branco
        	for (int j2 = 0; j2 < matriz.length; j2++) {
				//System.out.println("lin = " + cont + " col = " + j2 + " valor = " + String.valueOf(linha.charAt(j2)));
				matriz[cont][j2] = String.valueOf(linha.charAt(j2));
				//System.out.print("lin = " + cont + "col = " + j2 + "valor = " + String.valueOf(linha.charAt(j2)));
				System.out.print(matriz[cont][j2]);
			}
			System.out.println();

			cont++;
			
    		if(cont == tamanhoMatriz) {
    			cont = 0;
    			System.out.println("\nComeça as procuras da matriz acima:");
    		}
        }
        
        if(linha.length() == 2) {
        	//for (int i = 0; i < linha.length(); i++) {
				System.out.println("Caminho do = " + String.valueOf(linha.charAt(0)) + " até = " + String.valueOf(linha.charAt(1)));				
			//}
        }
        
        linha = lerArq.readLine(); // lê da segunda até a última linha
      }
 
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
 
    System.out.println();
  }
}