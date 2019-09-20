import java.awt.List;
import java.util.ArrayList;

public class NQueens {

	public static void main(String[] args) {
		
		
		int n = 4;
		
		NQueens nq = new NQueens();
		
		System.out.println(nq.solveNQueens(n));

	}

	private ArrayList<ArrayList<String>> sol = new ArrayList<>();

	public ArrayList<ArrayList<String>> solveNQueens(int n) {

		ArrayList<String> tmp = new ArrayList<>();

		String in = "";
		for (int x = 0; x < n; x++)
			in += ".";

		for (int x = 0; x < n; x++) {
			tmp.add(in);
		}

		track(0, n, tmp);

		return sol;

	}

	public boolean track(int pos, int n, ArrayList<String> arr) {

		if (pos == n) {
			// System.out.println("SOL: "+arr);

			ArrayList<String> arrSol = new ArrayList<>(arr);

			sol.add(arrSol);
			return true;

		}

		// System.out.println(pos + " " + arr);

		for (int x = 0; x < n; x++) {

			//System.out.println(isSafe(arr, n, pos, x));

			if (isSafe(arr, n, pos, x)) {

				StringBuilder s = new StringBuilder(arr.get(pos));
				s.setCharAt(x, 'Q');
				arr.set(pos, s.toString());
				track(pos + 1, n, arr);
				s.setCharAt(x, '.');
				arr.set(pos, s.toString());

			}
		}

		return false;
	}

	private boolean isSafe(ArrayList<String> arr, int N, int row, int col) {

		if (col >= N || row >= N)
			return false;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr.get(i).charAt(j) == 'Q' // se for Q e estiver
						&& (row - col == i - j // na mesma diagonal 
								|| row + col == i + j // na mesma diagonal 
								|| row == i)) // na mesma linha
					return false;
			}
		}

		for (int l = 0; l < N; l++) {
			if (l != row && arr.get(l).charAt(col) == 'Q') { // verifica verticalmente (linhas da col)
				return false;
			}
		}

		return true;
	}

}
