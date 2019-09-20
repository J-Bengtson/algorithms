package LeetCode;

import java.awt.List;
import java.util.ArrayList;

public class LetterCasePermutation {
	
	//https://leetcode.com/problems/letter-case-permutation/
	
	
	static void main(String[]args) {
		
		String teste = "3z4";
		Solution solution = new Solution();
		String print = solution.letterCasePermutation( teste ).toString();
		System.out.println(print);
	}
	
	
	static class Solution {
	    private ArrayList<String> arr = new ArrayList<>();
	    private String S;
	    
	    public ArrayList<String> letterCasePermutation(String S) {
	        this.S = S;
	        backtrackingAlgorithm( 0 , "" );
	       return arr;
	    }
	    /*
	        String S = "3z4"
	        int pos =  0
	        
	        
	        
	        3
	        
	        pos = 1
	        "3"
	        
	        z = Z
	        
	        pos = 2             pos = 2 
	        "3Z"				"3z"
	        
	        pos = 3				pos = 3
	        "3Z4"				"3z4"
	        
	        
	        
	        
	 
	   */
	    public void backtrackingAlgorithm(int pos , String S){
	        if(pos >= this.S.length()){ // condicao de parada
	            arr.add(S);
	            return;
	        }
	        
	        char letra = this.S.charAt(pos);
	        if(Character.isLetter(letra)){
	            
	            char c = Character.toLowerCase(letra);
	            backtrackingAlgorithm( pos + 1 , S + c);
	                
	            char c1 = Character.toUpperCase(letra);
	            backtrackingAlgorithm( pos + 1  , S + c1);
	            
	        }else{
	            
	            backtrackingAlgorithm(pos + 1 , S + letra);
	        }
	        
	    }
	}
}
