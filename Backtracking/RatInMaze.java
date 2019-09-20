
public class RatInMaze {
	public static void main(String[] args) {

		int[][] tab = { 
				{1 , 1 , 1 , 1 , 1},
				{0 , 1 , 0 , 0 , 1},
				{1 , 1 , 1 , 0 , 1},
				{1 , 1 , 1 , 0 , 1},
				{0 , 1 , 1 , 0 , 1}, 
				{1 , 0 , 0 , 1 , 1}, 
				{1 , 0 , 1 , 1 , 1},				
				};

		new RatInMaze().solve(tab);

	}

	public void solve(int[][] t) {

		
		System.out.println( solve(t, 0, 0) ? "Caminho descoberto" : "Caminho não encontrado" );

	}

	private boolean solve(int[][] t, int x, int y) {
		if (x == t.length - 1 && y == t[x].length-1 ) {
			printa(t);
			t[x][y] = 2;
			return true;
		}

		else if (x < 0 || x >= t.length || y < 0 || y >= t[x].length || t[x][y] == 0 || t[x][y] == 2) {
			return false;
		}
		else if (y == t[x].length) {
			y = 0;
			x = x + 1;
		}


		t[x][y] = 2;

		printa(t);

		if (solve(t, x + 1, y) || solve(t, x - 1, y) || solve(t, x, y + 1) || solve(t, x, y - 1)) {
			return true;
		}  

		t[x][y] = 1;

		return false;
	}
	
	private void printa(int[][] t) {
		System.out.println("__________________");
		for(int x = 0 ; x < t.length ; x++) {
			for(int y = 0 ; y < t[x].length ; y++) {
				
				System.out.print(t[x][y] + " ");
				
			}
			System.out.println();
		}
		
	}

}
