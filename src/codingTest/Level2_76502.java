package codingTest;

import java.util.Stack;

public class Level2_76502 {
	private int rightbracket(char[] bracket) {
		int count = 0;
		boolean flag = false;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < bracket.length; i++) {
			stack.clear();
			flag = false;
			for (int j = 0; j < bracket.length; j++) {
				int idx = (i + j) % bracket.length;
				switch(bracket[idx]) {
					case '(','{','[' -> stack.push(bracket[idx]);
					case ')' -> {
						if(stack.isEmpty()) {
							flag = true;
							break;
						}
						if(stack.peek() == '(') stack.pop();
					}
					case '}' -> {
						if(stack.isEmpty()){
							flag = true;
							break;
						}
						if(stack.peek() == '{') stack.pop();
					}
					case ']' -> {
						if(stack.isEmpty()) {
							flag = true;
							break;
						}
						if(stack.peek() == '[') stack.pop();
					}
				}
				if(flag == true) break;
			}
			if (stack.isEmpty() && flag == false) {
				count++;
			} 
		}
		return count;
	}
    public int solution(String s) {
    	char[] bracket = s.toCharArray();
        return rightbracket(bracket);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level2_76502 cls = new Level2_76502();
		System.out.println(cls.solution("}]()[{"));
	}

}
