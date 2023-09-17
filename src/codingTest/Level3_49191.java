package codingTest;

public class Level3_49191 {
	private int countForward(int u, boolean[][] graph, boolean[] isVisited) {
		int count = 1;
		for (int v = 0; v < graph[u].length; v++) {
			// 진행할 수 있는지 검사 후 진행
			if (!graph[u][v] || isVisited[v]) continue;
			//진행
			isVisited[v] = true;
			count += countForward(v, graph, isVisited);
		}
		
		return count;
	}
	private int countBackward(int u, boolean[][] graph, boolean[] isVisited) {
		int count = 1;
		for (int v = 0; v < graph.length; v++) {
			// 진행할 수 있는지 검사 후 진행
			if (!graph[v][u] || isVisited[v]) continue;
			//진행
			isVisited[v] = true;
			count += countBackward(v, graph, isVisited);
		}
		
		return count;
	}
	
	public int solution(int n, int[][] results) {
		boolean[][] graph = new boolean[n][n];
		for (int[] edge : results) {
			int u = edge[0] - 1;
			int v = edge[1] - 1;
			graph[u][v] = true;
		}
		
		int count = 0;
		for (int u = 0; u < n; u++) {
			int wins = countForward(u, graph, new boolean[n]) - 1;
			int loses = countBackward(u, graph, new boolean[n]) - 1;
			if (wins + loses + 1== n) {
				count++;
			}
		}
		
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] results1 = new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		int n1 = 5;
		
		Level3_49191 cls = new Level3_49191();
		cls.solution(n1, results1);
	}

}
