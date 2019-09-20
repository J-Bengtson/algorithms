package LeetCode;

import java.awt.List;
import java.util.ArrayList;

public class RestoreIPAddresses {
	
	// https://leetcode.com/problems/restore-ip-addresses/
	
	/*
	 * 
	 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		String s = "25525511135";

		ArrayList<String> arr = restoreIpAddresses(s);
		
		System.out.println(arr);
		
		
		s = "101102103";
		arr = restoreIpAddresses(s);
		
		System.out.println(arr);
		
	}

    public static ArrayList<String> lista = new ArrayList<>();
	public static String digitos;

	public static ArrayList<String> restoreIpAddresses(String s) {

		if( s.length() > 12){
            return new ArrayList<>();
        }
        
		lista.clear();
		digitos = s;

		geraIP("", 0, 0);

		return lista; // solucao

	}

	public static boolean validarIP(String string) {
//    	System.out.println(string);
		String split[] = string.split("\\.");
		if (split.length < 4)
			return false; /// min 4

		for (int x = 0; x < split.length; x++) {
			String s = split[x];
			if (s.length() < 1 || s.length() > 3 || !isValid(s)) {
				return false;
			}
		}

		return true;
	}

	public static void geraIP(String string, int pontos, int pos) {

		if (pos == digitos.length()) {

			if (validarIP(string)) {
				// System.out.println(string);
				lista.add(string);
			}

			return;
		}

		geraIP(string + digitos.charAt(pos), pontos, pos + 1);

		if (pontos < 3) {
			geraIP(string + digitos.charAt(pos) + ".", pontos + 1, pos + 1);
		}

	}
	
    public static boolean isValid(String str) {
        if(str.charAt(0) == '0') //more than one 0s in an octet is not valid
            return str.equals("0");
        
        int num = Integer.parseInt(str);
        return 0 < num && num <= 255;
    }

}
