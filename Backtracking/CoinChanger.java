import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CoinChanger {
	public static void main(String[]args) {
		
			new CoinChanger().executa(32);
		
	
	}
	
	
	
	private int[] m = { 1 , 2 , 5 , 10 , 25 , 50 , 100 };
	public void executa(int troco) {
				
		
		Arrays.sort(m);
		
		coins = new ArrayList<>();
		count = 0;
		
		tracking(0 , troco , new ArrayList<Integer>());
		
		System.out.println(coins);
		System.out.println("contador : " + count);
	}
	
	ArrayList<Integer> coins;
	int count;
	
	public boolean tracking(int n, int valor, ArrayList<Integer> tmp) {
		if(valor < 0) {
			return false;
		}
		if( valor == 0) {
			//System.out.println(tmp);
			
			if(coins.size() == 0 || tmp.size() < coins.size()) {
				coins = new ArrayList<Integer>(tmp);
			}
			
			return true;
			
		}

		
		//System.out.println(tmp);
		count++;
		for(int x : m) {
			tmp.add(x);
			if(tracking(n+1 , valor - x , tmp)) {
				//return true;
			}
			tmp.remove(tmp.size()-1);
			
		}
		
		return false;
	}
	
}
