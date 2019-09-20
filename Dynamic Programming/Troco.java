package Programacao_Dinamica;

import java.util.ArrayList;
import java.util.List;

public class Troco {
	
	public static void main(String[]args){
		List<Integer> moedas = new ArrayList<Integer>();
		moedas.add(1);
		moedas.add(2);
		moedas.add(6);
		moedas.add(8);
		
		int troco = 10;
		
		problemaTrocoComRep(moedas , troco);
		System.out.println();
		problemaTrocoSemRep(moedas , troco);
	}
	static void problemaTrocoSemRep(List<Integer> moedas , int troco){
		int[][] tabela = new int[moedas.size()][troco+1];
		
		for(int j = 0 ; j < tabela[0].length ; j++){
			if(j < moedas.get(0)){
				tabela[0][j] = 0;
			}else{
				tabela[0][j] = moedas.get(0);
			}
		}
		
		for(int i = 1 ; i < tabela.length ; i++){
			for(int j = 0 ; j < tabela[1].length ; j++){
				if(j < moedas.get(i)){
					tabela[i][j] = tabela[i-1][j];
				}else{
					tabela[i][j] = Math.min(
							tabela[i-1][j], tabela[i-1][j-moedas.get(i)] + 1);
				}
			}
		}
		
		imprime(tabela);
	}
	
	static void problemaTrocoComRep(List<Integer> moedas , int troco){
		int[][] tabela = new int[moedas.size()][troco+1];
		
		for(int j = 0 ; j < tabela[1].length ; j++){
			if(j < moedas.get(0)){
				tabela[0][j] = 0;
			}else{
				tabela[0][j] = Math.max(
						tabela[0][j], tabela[0][j - moedas.get(0)]
								+ moedas.get(0));
			}
		}
		
		for(int i = 1 ; i < tabela.length ; i++){
			for(int j = 0 ; j < tabela[1].length ; j++){
				if(j < moedas.get(i)){
					tabela[i][j] = tabela[i-1][j];
				}else{
					tabela[i][j] = Math.min(
							tabela[i-1][j], tabela[i][j-moedas.get(i)] + 1);
				}
			}
		}
		
		imprime(tabela);
		
		
	}
	
	static void imprime(int[][] tabela){
		for(int i = 0 ; i < tabela.length ; i++){
			for(int j = 0 ; j < tabela[0].length ; j++){
				
				System.out.print(tabela[i][j]+"\t");
				
			}
			System.out.println();
		}
	}
}
