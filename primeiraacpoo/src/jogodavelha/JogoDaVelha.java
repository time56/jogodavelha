package jogodavelha;

/***
 * Grupo
 * Felipe Victor Matias - RA: 1903306
 * Matheus Faria Duarte - RA: 1903707
 * Vinicius Holanda Lima - RA: 1903017
 * Lucas Figueiredo Ventura - RA: 1701918
 * Raquel Meire Paternazi de Souza - RA: 1903269
 */


import java.util.Scanner;

public class JogoDaVelha {
	
	static char[][] tabuleiro = new char[3][3];
	static int resultado = -1;	
	
	public static void main(String[] args) {	
		
		initialize();
		game();		
		
	}
	
	public static char[][] initialize() {
		
		for (int linha = 0; linha < tabuleiro.length; linha++)  {  
			
		       for (int coluna = 0; coluna < tabuleiro[0].length; coluna++){ 		    	
		           tabuleiro[linha][coluna] = '-';
		           System.out.print(tabuleiro[linha][coluna] + " ");
		       }  
		       
		       System.out.println(" ");
		} 
		
		return tabuleiro;
	}
	

	public static boolean step(char M[][], int lin, int col, char gamer) {		
		
	
		if(M[lin][col] == '-') {
			M[lin][col] = gamer;	
			for(lin = 0; lin<M.length; lin++) {				
				for(col = 0; col <M.length; col++) {						
					System.out.print(" " + M[lin][col]);												
				}					
				System.out.println(" ");
			}		
			return true;			
	    }else {
	    	System.out.println("Posição ocupada. Tente novamente.");
	    	return false;
	    }	
	}
	
	public static int status(char M[][]) {
		int resultado = -1;	 
		
		if ((M[0][0] == 'X' && M[0][1] == 'X' && M[0][2] == 'X') ||
				(M[1][0] == 'X' && M[1][1] == 'X' && M[1][2] == 'X') ||
				(M[2][0] == 'X' && M[2][1] == 'X' && M[2][2] == 'X') ||
				(M[0][0] == 'X' && M[1][0] == 'X' && M[2][0] == 'X') ||
				(M[0][1] == 'X' && M[1][1] == 'X' && M[2][1] == 'X') ||
				(M[0][2] == 'X' && M[1][2] == 'X' && M[2][2] == 'X') ||
				(M[0][0] == 'X' && M[1][1] == 'X' && M[2][2] == 'X') ||
				(M[0][2] == 'X' && M[1][1] == 'X' && M[2][0] == 'X')) {
				return resultado = 2;
			}
			
			if ((M[0][0] == 'O' && M[0][1] == 'O' && M[0][2] == 'O') ||
					(M[1][0] == 'O' && M[1][1] == 'O' && M[1][2] == 'O') ||
					(M[2][0] == 'O' && M[2][1] == 'O' && M[2][2] == 'O') ||
					(M[0][0] == 'O' && M[1][0] == 'O' && M[2][0] == 'O') ||
					(M[0][1] == 'O' && M[1][1] == 'O' && M[2][1] == 'O') ||
					(M[0][2] == 'O' && M[1][2] == 'O' && M[2][2] == 'O') ||
					(M[0][0] == 'O' && M[1][1] == 'O' && M[2][2] == 'O') ||
					(M[0][2] == 'O' && M[1][1] == 'O' && M[2][0] == 'O')) {
					return resultado = 1;
				}
		
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[i].length;j++) {
				if (M[i][j] == '-') {
					return resultado;
				}
			}
		}
		
		resultado = 0;
		return resultado;
	}
	
	public static void game() {
		
		Scanner entrada = new Scanner(System.in);	
		int linha, coluna, valida = 0, contador =0;
		char gamer;		
		boolean retorno = false;
		
		while(resultado == -1) {		
			
			do {
				valida = 0;
				if (contador % 2 == 0) {
					gamer = 'O'; 
				} else {
					gamer = 'X';
				}
				System.out.print("Jogador '" + gamer + "' escolha a linha: ");
				linha = entrada.nextInt();
								
				System.out.print("Jogador '" + gamer + "' escolha a coluna: ");
				coluna = entrada.nextInt();		
					
				
				if(linha > 2 || coluna > 2) {
					System.out.println("Posição inválida. Escolha novamente");
					retorno = false;
				}else {
					retorno = step(tabuleiro, linha, coluna, gamer);	
				}

				if(retorno == true) {
					valida = 1;
					contador++;
				};			
				
				resultado = status(tabuleiro);
				if (resultado == 1) {
					System.out.println("Jogador 'O' venceu.");
					break;
				} else if(resultado == 2) {
					System.out.println("Jogador 'X' venceu.");
					break;
				} else if(resultado == 0) {
					System.out.println("O jogo empatou.");
					break;
				}
			} while(valida == 0);
			
		}		
		
	}
}
