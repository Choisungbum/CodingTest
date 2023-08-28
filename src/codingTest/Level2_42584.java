package codingTest;

import java.util.Stack;

public class Level2_42584 {
	public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < prices.length; i++) {
        	while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
        		int index = stack.pop();
        		answer[index] = i - index;
        	}
        	stack.push(i);
        }
        
        while(!stack.isEmpty()) {
        	int index = stack.pop();
        	answer[index] = prices.length - index - 1;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
	