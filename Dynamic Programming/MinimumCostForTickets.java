package LeetCode;

import java.util.Arrays;

public class MinimumCostForTickets {
	
	//https://leetcode.com/problems/minimum-cost-for-tickets/
	
	/*
	 * 
	 * 
	 * In a country popular for train travel, you have planned some train travelling one year in advance.  The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.

Train tickets are sold in 3 different ways:

a 1-day pass is sold for costs[0] dollars;
a 7-day pass is sold for costs[1] dollars;
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.

Return the minimum number of dollars you need to travel every day in the given list of days.

 

Example 1:

Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation: 
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total you spent $11 and covered all the days of your travel.
Example 2:

Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
Output: 17
Explanation: 
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total you spent $17 and covered all the days of your travel.
	 * 
	 * 
	 * 
	 */
	
	public static void main(String[]args) {
		int[] days = { 1,4,6,7,8,20 };
		int costs[] = { 2,7,15 };
		System.out.println("solucao : " + minCostTickets(days,costs));
	}
	 public static int minCostTickets(int[] days, int[] costs) {

	        int[] day_pass = {1 , 7 , 30};
	        //a 1-day pass is sold for costs[0] dollars;
	        //a 7-day pass is sold for costs[1] dollars;
	        //a 30-day pass is sold for costs[2] dollars.
	        
	        Arrays.sort(days);
	        Arrays.sort(costs);
	        Arrays.sort(day_pass);
	        
	        if(days.length == 0) return 0;
		 	if(days[days.length-1] == 1){
		 		return costs[0];
		 	}
		 

	        int[] sol = new int[days [days.length-1] + 1]; // estrutura de dados vetor linear
	        
	        sol[0] = 0; // inicializa com 0 no vetor linear
	        
	        
	        int count = 0;
	        for(int x = 1 ; x < sol.length ; x++){ // todos os dias sao percorridos
	            
	            
	            if(x == days[count]){ // index for dia
	                System.out.println();
	                								
	                int menor_atual = sol[x-1] + costs[0];
	                			/* solu��o para computar o menor valor para dia x,variavel menor_atual, l�gica:
	                			    	o menor_atual � inicializado com o valor do dia anterior + o menor custo da passagem
	                			    	e
	                			    	 percorre todos os outros pre�os das passagens ate que
	                			    	o menor valor do dia x � igual ao valor do dia (x - dias de passagem[] ) + custo da passagem
	                			 		*/
	                								
	                									
	                									//
	                for(int d = 0 ; d < day_pass.length ; d++){
	                    	
	                    	int j = (x - day_pass[d] <= 0) ? 0 : x - day_pass[d];
	                    	
	                    	System.out.printf( days[count] + " %d , %d\n" , sol[ j ] + costs[d] , menor_atual );
	                    	
	                        menor_atual = Math.min( sol[ j ] + costs[d] , menor_atual ); // procura o men

	                }
	                sol[x] = menor_atual;
	                count++;
	            }else{
	                sol[x] = sol[x-1];
	            }
	            

	        }
	        
	        
	        for( int x : sol) {
	        	System.out.print( x +" ");
	        }
	        
	        return sol[sol.length-1];
	        
	        
	    }
}
