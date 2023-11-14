package codingTest;

import java.util.Arrays;
import java.util.Stack;

public class Level3_43162 {
	 public int solution(int n, int[][] computers) {
		 boolean[] isVisited = new boolean[computers.length];
		 
		 Stack<Integer> stack = new Stack<>();
//		 for (int i = 0; i < ) {
//			 
//		 }
		 stack.push(0);
		 
		 while(!stack.isEmpty()) {
			 int index = stack.pop();
			 System.out.println("index : " + index);
			 if (isVisited[index]) continue;
			 isVisited[index] = true;
			 
			 for (int j = 0; j < computers[0].length; j++) {
				if (index == j) continue;
				
				if (computers[index][j] == 1) {
					System.out.println("next index : " + j);
					stack.push(j);
				}
			 }
			 
		 }
		 isVisited.toString();
		 int t = 0;
		 int f = 0;
		 for (boolean bool : isVisited) {
			 if (bool == true) {
				 t = 1;
			 } else {
				 f++;
			 } 
		 }
		 
		 System.out.println(Arrays.toString(isVisited));
	        return t + f;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 3;
		int n2 = 4;
		int[][] computers1 = new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int[][] computers2 = new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		int[][] computers3 = new int[][] {{1, 1, 1, 0}, {1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}};
		Level3_43162 cls = new Level3_43162();
		System.out.println(cls.solution(n2, computers3));
	}

}
