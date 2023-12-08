package codingTest;

import java.util.Stack;
import java.util.stream.Collectors;

public class Level2_42883 {

	
	 public String solution(String number, int k) {
		 Stack<Character> stack = new Stack<>();
		 for (char c : number.toCharArray()) {
			 while (k > 0 && !stack.isEmpty() && c > stack.peek()) {
				 stack.pop();
				 k--;
			 }
			 
			 stack.push(c);
		 }
		 
		 while (k-- > 0) {
			stack.pop();
		}
		 
		 
		 return stack.stream().map(String::valueOf)
				 .collect(Collectors.joining());
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level2_42883 cls = new Level2_42883();
		String number = "1924";
		int k = 2;
		
		String number1 = "1231234";
		int k1 = 3;
		
		String number2 = "4177252841";
		int k2 = 5;
		
		String number3 = "7777Z9777777777";
		int k3 = 4;
		
		System.out.println("result : " + cls.solution(number2, k2));

	}

}
