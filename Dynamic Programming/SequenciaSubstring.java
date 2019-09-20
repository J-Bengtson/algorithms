package Programacao_Dinamica;

public class SequenciaSubstring {
	
	
	
	
	public static void main(String[]args){
		
		String X = "XACGTGTCA";
		String Y = "YACTGTGCA";
		
		int[][] tabela = new int[X.length()][Y.length()];
		
		
		subSeq(tabela, X , Y);
		
	}

	static void imprime(int[][] tabela, String X , String Y) {
		System.out.print("  ");
		for (int j = 0; j < tabela[0].length; j++) {
			System.out.print(Y.charAt(j)+" ");
		}
		System.out.println();
		
		
		for (int i = 0; i < tabela.length; i++) {
			System.out.print(X.charAt(i) +" ");
			for (int j = 0; j < tabela[0].length; j++) {
				System.out.print(tabela[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	static void subSeq(int[][] tabela , String X , String Y){
		
		
		for (int i = 1 ; i < tabela.length; i++ ) {
			for (int j = 1 ; j < tabela[i].length ; j++) {
				
				if(X.charAt(i) == Y.charAt(j)){
					
					tabela[i][j] = tabela[i-1][j-1] + 1;
					
				}else{
					
					tabela[i][j] = Math.max( tabela[i-1][j] , tabela[i][j-1]);
				}
				
			}
		}
		
		imprime(tabela,X,Y);
		
		System.out.println("\nSOLUCAO :");
		imprimeSolucao( tabela.length - 1 , tabela[0].length - 1 , tabela , X , Y);
	}
	
	
	static void imprimeSolucao(int i , int j ,int[][] tabela , String X , String Y ){
		
		if( i <= 0 || j <= 0)
			return;
		
		if(X.charAt(i) == Y.charAt(j)){
			System.out.println(X.charAt(i));
			imprimeSolucao(i - 1 , j - 1 , tabela , X , Y);
		}else if( tabela[i][j-1] < tabela[i - 1][j] )
				imprimeSolucao( i - 1 , j , tabela , X , Y);
		else{
				imprimeSolucao( i , j - 1 , tabela , X , Y);
		}
	}
}
		


	
	
	

