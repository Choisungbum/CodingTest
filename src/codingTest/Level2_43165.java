package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Level2_43165 {
	private static class Node {
		int value = 0;
		int depth = 0;
		Node parent = null;
		Node right;
		Node left;
		
		public Node (int value) {
			this.value = value;
		}
		
		private Node root() {
			if (parent == null) return this;
			return parent.root();
		}
		
		
		
	}
	public int solution(int[] numbers, int target) {
		boolean[] isVisited = new boolean[numbers.length + 1];
		Stack<Integer> stack = new Stack<>();
		
		stack.add(0);
		int index = 0;
//		while (!stack.isEmpty()) {
//			int state = stack.pop();
//			System.out.println("state : " + state);
//			
//			if (isVisited[state]) continue;
//			isVisited[state] = true;
//			
//			for (int i = 1; i < numbers.length; i++) {
//				if (i == numbers.length - 1) {
////					list.add()
//				}
//				stack.push(i);
//			}
			
			
//		}
		
		
        int answer = 0;
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers1 = new int[] {1, 1, 1, 1, 1};
		int target1 = 3;
		Level2_43165 cls = new Level2_43165();
		cls.solution(numbers1, target1);
	}

}
