import java.awt.List;
import java.util.HashMap;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {

	public static void main(String[] args) {
		//System.out.println( phone.get(digits.substring(0 , 1)));
		new LetterCombinationOfPhoneNumber().letterCombinations("234");
	}

	static Map<String, String> phone = new HashMap<String, String>() {
		{
			put("2", "abc");
			put("3", "def");
			put("4", "ghi");
			put("5", "jkl");
			put("6", "mno");
			put("7", "pqrs");
			put("8", "tuv");
			put("9", "wxyz");
		}
	};

	static String digits = "234";

	public List letterCombinations(String digits) {

		this.digits = digits;
		track("", 0);

		return null;

	}

	public void track(String string, int pos) {
		if (pos == this.digits.length()) {
			System.out.println(string);
			return;
		}

		//System.out.println("j: "+ string);
		for (int x = 0; x < phone.get(this.digits.substring(pos, pos + 1)).length(); x++) {
//			 System.out.println(string + " " + pos + " " +
//			 phone.get(this.digits.substring(pos, pos + 1)).charAt(x) );
			 
			track(string + phone.get(this.digits.substring(pos, pos + 1)).charAt(x), pos + 1);
			
			
			// 
		}

	}
}