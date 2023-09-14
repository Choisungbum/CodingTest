package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level3_49191 {
	static int idx = 0;
	static void dfs(int nodeIndex, boolean[] visited, int[][] copy, int[][] result) {
		visited[nodeIndex] = true;
	}
	
	public int solution(int n, int[][] results) {
		boolean[] visited = new boolean[results.length + 1]; // 방문처리 
		
//		int[][] copy = new int[results.length + 1][];4
		List<List<Integer>> ans = new ArrayList<>();
		int[][] result = new int[results.length + 1][n];

		for (int i = 0; i < results.length + 1; i++) {
			ans.add(new ArrayList<>());
		}
		
		for (int i = 1; i < results.length +1; i++) {
			List<Integer> node = new ArrayList<>();
			ans.get(results[i][0]).add(results[i][1]);
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
