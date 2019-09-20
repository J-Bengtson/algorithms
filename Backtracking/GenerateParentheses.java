package LeetCode;

import java.awt.List;
import java.util.ArrayList;
import java.util.Stack;

public class GenerateParentheses {
	//https://leetcode.com/problems/generate-parentheses/
	
	/*
	 * 
	 * 
	 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

		For example, given n = 3, a solution set is:

	[
	  "((()))",
	  "(()())",
	  "(())()",
	  "()(())",
	  "()()()"
	]
	 * 
	 * 
	 */
	
	public static void main(String[]args) {
		int n = 3;
		
		generateParenthesis(n);
		
		System.out.println(lista);
	}
	
	
	
	 private static ArrayList<String> lista = new ArrayList<>();
	 
	 public static ArrayList<String> generateParenthesis(int n) {
		        
		        geraParenteses( "" , (n * 2));
		        
		        return lista;
		    }
		    
		    public static void geraParenteses(String string , int n){
		        
		        if(n == 0){
			        System.out.println(string);
		            if( aceitavel(string) ) lista.add(string);
		            return;
		        }
		        	
		        
		        geraParenteses(string + "(" , n - 1);
		        
		        geraParenteses(string + ")" , n - 1);
		        
		        return;
		        
		        
		    }
		    
		    
		    public static boolean aceitavel(String string){
		        
		        Stack<Character> stack = new Stack<>();
		        
		        for(int x = 0 ; x < string.length() ; x++){
		            Character c = Character.valueOf(string.charAt(x));
		            if(!stack.empty()  && stack.peek().equals(Character.valueOf('(')) && c.equals(Character.valueOf(')'))){
		                stack.pop();
		            }else{
		                stack.push(c);
		            }

		        }
		  
		    
		    
		        return stack.empty();
		        
		    }
}
