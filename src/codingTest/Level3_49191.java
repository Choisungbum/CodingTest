package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Level3_49191 {
	static int idx = 0;
	static List<Integer> dfs(int nodeIndex, boolean[] visited, Map<Integer, List<Integer>> graph, List<Integer> list) {
		visited[nodeIndex] = true;
		System.out.println(nodeIndex + " -> ");
		List<Integer> node = graph.get(nodeIndex);
//		List<Integer> list = new ArrayList<Integer>();
		if (node == null) return list;
		
		for (int i : node) {
//			list.add(nodeIndex);
			if(!visited[i]) {
				list.add(i);
				dfs(i, visited, graph, list);
				visited[i] = false;
			}
		}
		System.out.println("end");
		return list;
	}
	
	public int solution(int n, int[][] results) {
		boolean[] visited = new boolean[results.length + 1]; // 방문처리 
		List<List<Integer>> answerlist = new ArrayList<>();
		Map<Integer, List<Integer>> graph = new HashMap<>();
		
		for (int i = 0; i < results.length; i++) {
			if (graph.get(results[i][0]) == null) {
				List<Integer> node = new ArrayList<>();
				node.add(results[i][1]);
				graph.put(results[i][0], node);
			} else {
				graph.get(results[i][0]).add(results[i][1]);
			}
		}
		
		for (int i : graph.keySet()) {
			System.out.println(i);
		}
		
		for (List<Integer> list : graph.values()) {
			System.out.println(list.toString());
		}
		for (int i : graph.keySet()) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(i);
			answerlist.add(dfs(i, visited, graph, list));
			Arrays.fill(visited, false);
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
