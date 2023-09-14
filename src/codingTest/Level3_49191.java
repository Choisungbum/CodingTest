package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level3_49191 {
	static int idx = 0;
	static void dfs(int nodeIndex, boolean[] visited, int[][] copy, int[][] result) {
		visited[nodeIndex] = true;
		
//		System.out.println(nodeIndex + " -> " ); // 방문 노드 출력 
		for(int i = 0; i < copy[nodeIndex].length; i++)
			if (!visited[copy[nodeIndex][i]]) {
				int node = copy[nodeIndex][i];
				result[idx][i] = node;
				dfs(node, visited, copy, result);
			}
	}
	
	public int solution(int n, int[][] results) {
		boolean[] visited = new boolean[results.length + 1]; // 방문처리 
		
		int[][] copy = new int[results.length + 1][];
		int[][] result = new int[results.length + 1][n - 1];
		copy[0] = new int[0];		// 빈 배열 추가 

		System.out.println(copy[0].toString());
		
		for (int i = 1; i < results.length + 1; i++) {
			copy[i] = Arrays.copyOf(results[i - 1], results[i - 1].length);
			System.out.println("copy[" + i + "]" + " " + copy[i][0]);
		}
		
		for (int[] arr :result) {
			Arrays.fill(arr, -1);
		}
		for (int i = 1; i < results.length + 1; i++) {
			dfs(i, visited, copy, result);
			Arrays.fill(visited, false);
		} // 
		
		for (int i = 1; i < results.length + 1; i++) {
		}
		
		
        int answer = 0;
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] results1 = new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		int n1 = 5;
		
		Level3_49191 cls = new Level3_49191();
		cls.solution(n1, results1);
	}

}
