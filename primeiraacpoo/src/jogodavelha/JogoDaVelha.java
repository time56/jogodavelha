package jogodavelha;

public class JogoDaVelha {

	public static void main(String[] args) {
		initialize();
	}
	
	public static char[][] initialize() {
		char[][] tabuleiro = new char[3][3];
		for (int l = 0; l < tabuleiro.length; l++)  {  
		       for (int c = 0; c < tabuleiro[0].length; c++)     { 
		           tabuleiro[l][c] = '-';
		       }  
		     } 
		for (int l = 0; l < tabuleiro.length; l++)  {  
		       for (int c = 0; c < tabuleiro[0].length; c++)     { 
		           System.out.print(tabuleiro[l][c] + " ");
		       }  
		       System.out.println(" ");
		     }  
		return tabuleiro;
	}
}
