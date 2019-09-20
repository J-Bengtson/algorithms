package Programacao_Dinamica;

import java.util.ArrayList;
import java.util.List;

import Força_Bruta.Item;

public class ProblemaDaMochila {
	
	public static void main(String[]args){

		//lista de itens
		 List<Item> itens = new ArrayList();
		 itens.add(new Item(4,3));
		 itens.add(new Item(5,4));
		 itens.add(new Item(8,5));
		 itens.add(new Item(10,7));
		 
		 //definir tamanho da mochila
		 int mochila = 10;
		 
		mochilaSemRep(itens,mochila);
		System.out.println();
		mochilaComRep(itens,mochila);
		
	}
	
	
	static void mochilaSemRep(List<Item> itens , int mochila){
		
		int[][] tabela = new int[itens.size()][mochila + 1];
		
		for(int j = 0 ; j < tabela[0].length ; j++){
			if(j < itens.get(0).getPeso()){
				tabela[0][j] = 0;
			}else{
				tabela[0][j] = itens.get(0).getValor();
			}
		}
		
		for(int i = 1 ; i < tabela.length ; i++){
			for(int j = 0 ; j < tabela[0].length ; j++){
				if(j < itens.get(i).getPeso()){
					tabela[i][j] = tabela[i-1][j];
				}else{
					tabela[i][j] = Math.max(
							tabela[i-1][j], tabela[i-1][j-itens.get(i).getPeso()] + itens.get(i).getValor());
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
	
	
	static void mochilaComRep(List<Item> itens , int mochila){
		int[][] tabela = new int[itens.size()][mochila+1];
		
		for(int j = 0 ; j < tabela[1].length ; j++){
			if(j < itens.get(0).getPeso()){
				tabela[0][j] = 0;
			}else{
				tabela[0][j] = Math.max(
						tabela[0][j], tabela[0][j - itens.get(0).getPeso()]
								+ itens.get(0).getValor());
			}
		}
		
		for(int i = 1 ; i < tabela.length ; i++){
			for(int j = 0 ; j < tabela[1].length ; j++){
				if(j < itens.get(i).getPeso()){
					tabela[i][j] = tabela[i-1][j];
				}else{
					tabela[i][j] = Math.max(
							tabela[i-1][j], tabela[i][j-itens.get(i).getPeso()] + itens.get(i).getValor());
				}
			}
		}
		
		imprime(tabela);
	}
	
	public class Item {
	public Item(int valor, int peso) {
		this.peso = peso;
		this.valor = valor;
	}
	public Item(){};

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	private int peso;
	private int valor;

}
	
	
	
	
}
