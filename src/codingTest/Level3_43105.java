package codingTest;

import java.util.Arrays;

public class Level3_43105 {
	private static final int[][] mem = new int[501][501];

	private int max(int x, int y, int[][] triangle) {
		if (y == triangle.length) return 0;
		
		if(mem[x][y] != -1) return mem[x][y];
		return mem[x][y] = triangle[y][x] + Math.max(max(x, y + 1, triangle), max(x + 1, y + 1, triangle));
	}
	
	public int solution(int[][] triangle) {
		for(int[] row : mem) {
			Arrays.fill(row, -1);
		}
	    return max(0, 0, triangle);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] triangle1 = new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		Level3_43105 cls = new Level3_43105();
		System.out.println(cls.solution(triangle1));
	}

}
