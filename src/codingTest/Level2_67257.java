package codingTest;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Level2_67257 {
	private static final String[][] precedences = {
		"+-*".split(""),
		"+*-".split(""),
		"-+*".split(""),
		"-*+".split(""),
		"*+-".split(""),
		"*-+".split("")
	};
	
	private long calculate(long lhs, long rhs, String op) {
		return switch(op) {
		case "+" -> lhs + rhs;
		case "-" -> lhs - rhs;
		case "*" -> lhs * rhs;
		default -> 0;
			};
	};
	
	private long calculate(List<String> tokens, String[] precedence) {
		for(String op : precedence) {
			for(int i = 0; i < tokens.size(); i++) {
				if (tokens.get(i).equals(op)) {
					long lhs = Long.parseLong(tokens.get(i - 1));
					long rhs = Long.parseLong(tokens.get(i + 1));
					long result = calculate(lhs, rhs, op);
					tokens.remove(i - 1);
					tokens.remove(i - 1);
					tokens.remove(i - 1);
					tokens.add(i - 1, String.valueOf(result));
					i -= 2;
				}
				
			}
		}
	return Long.parseLong(tokens.get(0));
	}
	
	
	public long solution(String expression) {
		StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
		List<String> tokens = new ArrayList<>();
		while(tokenizer.hasMoreTokens()) {
			tokens.add(tokenizer.nextToken());
		}
		
		long max = 0;
		for (String[] precedence : precedences) {
			long value = Math.abs(calculate(new ArrayList<>(tokens), precedence));
			if (value > max) {
				max = value;
			}
		}
		
        return max;
	    }
	 
	public static void main(String[] args) {
		Level2_67257 cls = new Level2_67257();
		//cls.solution("100-200+300-500+20");
		String s = "100-200*300-500+20";
		System.out.println(cls.solution(s));
//		String[] numArr = s.split("[\\+\\-\\*]");
//		String[] strArr = s.split("[0-9]");
//		for (int i = 0; i < numArr.length; i++) {
//			System.out.print(numArr[i]);
//		}
//		for (int i = 0; i < strArr.length; i++) {
//			System.out.print(strArr[i]);
		}
//		System.out.println((int) s);
}
