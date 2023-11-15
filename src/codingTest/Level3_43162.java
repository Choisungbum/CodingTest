package codingTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Level3_43162 {
	private void visitAll(int computer, int[][] computers, boolean[] isVisited) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(computer);
		
		while(!stack.isEmpty()) {
			int c = stack.pop();
			
			if (isVisited[c]) continue;
			isVisited[c] = true;
			
			for (int next = 0; next <  computers[c].length; next++) {
				if(computers[c][next] == 0) continue;
				stack.push(next);
			}
			
		}
		
	}
	
 	public int solution(int n, int[][] computers) {
 		boolean[] isVisited = new boolean[n];
 		int answer = 0;
 		
 		for (int i = 0; i < n; i++) {
 			if (isVisited[i]) continue;
 			visitAll(i, computers, isVisited);
 			answer++;
 		}
 		return answer++;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 3;
		int n2 = 4;
		int[][] computers1 = new int[][] {{1, 1, 0}
										, {1, 1, 0}
										, {0, 0, 1}};
		int[][] computers2 = new int[][] {{1, 1, 0}
										, {1, 1, 1}
										, {0, 1, 1}};
		int[][] computers3 = new int[][] {{1, 0, 1, 0}
										, {0, 1, 0, 1}
										, {1, 0, 1, 0}
										, {0, 1, 0, 1}};
		Level3_43162 cls = new Level3_43162();
		System.out.println(cls.solution(n2, computers3));
	}

}
