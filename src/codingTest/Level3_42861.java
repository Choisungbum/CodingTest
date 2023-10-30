package codingTest;

import java.util.Arrays;
import java.util.Comparator;

public class Level3_42861 {
	public static int[] parents;
	public static int[] cost;
	
	public static boolean union(int x, int y, int val) {
		System.out.println("union(" + x + ", " + y + ")");
		x = find(x); // x 의 부모노드
		y = find(y); // y 의 부모노드
		
		if (x == y) return false; // x, y 가 같은 그래프에 있는 경우 
		if (x > y) {
			parents[x] = y;
			System.out.println("parents[" + x + "] = " + y);
			cost[x] = val;
			System.out.println("cost[" + x + "] = " + val);
		} else if (x < y) {
			parents[y] = x;
			System.out.println("parents[" + y + "] = " + x);
			cost[y] = val;
			System.out.println("cost[" + y + "] = " + val);
		}
		
		return true;
	}
	
	public static int find(int x) {
		if (parents[x] == x) return x;
		return find(parents[x]);
	}
	
	public static void parentPrint() {
		System.out.print("[ ");
		for (int i = 0; i < parents.length; i++) {
			System.out.print(parents[i]+ " ");
		}
		System.out.println("]");
	}
	
	public int solution(int n, int[][] costs) {
		// parents 초기화
		parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
		
		// cost 초기화 
		cost = new int[n];
		Arrays.fill(cost, 0);
		
		Arrays.sort(costs, Comparator.comparingInt((val)->(val[2]))); // 2번째 원소 기준 정렬 
		for (int[] co : costs) {
			union(co[0], co[1], co[2]);
			parentPrint();
		}
		
		int totCost = 0;
		for (int i = 0; i < n; i++) {
			System.out.println("cost["+i+"]" + cost[i]);
			totCost += cost[i];
		}
				
	    return totCost;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] costs = new int[][] {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		int[][] costs1 = new int[][] {{2,3,8},{1,2,5},{0,2,2}, {0,1,1},{1,3,1}};
		int[][] costs2 = new int[][] {{1,2,5},{2,3,8},{0,2,2}, {0,1,1},{1,3,1}};
		Level3_42861 cls = new Level3_42861();
		System.out.println(cls.solution(4, costs1));
		
	}

}
