package codingTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TestNote {
	private static class State{
		
	}
	public int solution(int n, int[][] computers) {
		boolean[][] isVisited = new boolean[n][n];
		Set<String> result = new HashSet<>();
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < computers.length; i++) {
			stack.clear();
			stack.push(i);
			
			while (!stack.isEmpty()) {
				int index = stack.pop();
				
				for (int j = 0; j < n; j++) {
					if (computers[index][j] == 1) {
						if (isVisited[index][j]) {
							isVisited[index][j] = true;
							continue;
						}
						isVisited[index][j] = true;
						
						if (index == j) continue;

						stack.push(j);
					}
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			result.add( Arrays.toString(isVisited[i]));
			System.out.println(Arrays.toString(isVisited[i]));
		}
		 
		
		return result.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestNote cls = new TestNote();
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
		System.out.println(cls.solution(n2, computers3));
		
	}

}
