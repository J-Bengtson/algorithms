package Tentativa_e_Erro;

public class PasseioDoCavalo {
	
	/*
	 * O pior caso desse algoritmo é o força bruta
	 * 
	 * Dado um tabuleiro com n x n posições, o cavalo se movimenta segundo as regras do xadrez
	 * 
	 * Problema a ser resolvido: A partir de uma posição inicial (X0,Y0),se existir um passeio do cavalo com n²-1 movimentos,
	 * visitando todos os pontos do tabuleiro uma única vez
	 */
	
	
	
	
	
	public static class Tabuleiro{
		
		public Tabuleiro(int N , int posX , int posY){// construtor parametrico
			matriz = new int[N][N];
			this.posX = posX ; this.posY = posY;
		}
		
		public Tabuleiro(){ // construtor inicial com default de 5x5
			int N = 5;
			matriz = new int[N][N];
			this.posX = 2 ; this.posY = 2;
		}
		
		private int matriz[][]; // tabuleiro
		private int posX , posY; // pos inicial do cavalo
		
		private int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
					// Para calculo das coordenadas dos movimentos possiveis do cavalo (8 movimentos possiveis)
		private int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
					//Para calculo das coordenadas dos movimentos possiveis do cavalo (8 movimentos possiveis)
		
		
		
		
		public void solucionaProblemaPasseioDoCavalo(){
			
			matriz[posX][posY] = 1;
			
			if(tentaMover( 2 , posX , posY )){
				System.out.println("o problema foi solucionado!");
				
				String impressao = "";
				for(int x = 0 ; x < matriz.length;  x++){
					for(int y = 0 ; y < matriz[x].length ; y++)
						impressao += matriz[x][y]+" ";
					impressao+="\n";
				}
				
				System.out.println(impressao);
					
			}else{
				System.out.println(" o problema não pode ser solucionado!");
				
			}
			
			
		}
		
		private boolean tentaMover( int j , int x , int y ){ // Tenta o i-esimo movimento em (x,y), 1 <= i <= n^2
			boolean acabou = j > (matriz.length * matriz[0].length);
			int k = 0;
			while(!acabou && k < dx.length){
				int u = x + dx[k]; //# Coordenadas dos 8 movimentos possiveis do cavalo
				int v = y + dy[k]; //Coordenadas dos 8 movimentos possiveis do cavalo
				if(aceitavel(u,v)){
					matriz[u][v] = j;
					acabou = tentaMover(j+1,u,v);// Tenta outro movimento
					if(!acabou)
						matriz[u][v] = 0;// Sem sucesso, descarta movimento
				}
				k +=1; // Passa ao proximo movimento possivel
			}
			return acabou;
		}
		
		private boolean aceitavel( int x , int y ){
			
			if(x >= 0 && x <= matriz.length-1 && y>= 0 && y<= matriz.length-1 && matriz[x][y] == 0)
				return true;
			else 
				return false;	
		}	
	}

	public static void main(String[] args) {

		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.solucionaProblemaPasseioDoCavalo();
		
	}
	

}
