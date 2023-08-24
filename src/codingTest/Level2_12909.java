package codingTest;

import java.util.Stack;

public class Level2_12909 {
	 boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			switch(c) {
				case '(' -> stack.push(c);
				case ')' -> {
					if (stack.isEmpty()) return false;
					stack.pop();
				}
			}
		}
        return stack.isEmpty();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
