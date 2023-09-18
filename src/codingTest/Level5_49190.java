package codingTest;

import java.util.ArrayList;
import java.util.List;

public class Level5_49190 {
	private class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public void move(int x, int y) {
			this.x = this.x + x;
			this.y = this.y + y;
		}
	}
    public int solution(int[] arrows) {
    	int[] dx = new int[] {0, 1, 1, 1, 0, -1, -1, -1}; // x 변화량
    	int[] dy = new int[] {1, 1, 0, -1, -1, -1, 0, 1}; // y 변화량
    	List<Point> list = new ArrayList<Point>();
    	Point point = new Point(0, 0);
    	int max_x = 0;
    	int max_y = 0;
    	int min_x = 0;
    	int min_y = 0;
    	
    	for (int i : arrows) {
    		point.move(dx[i], dy[i]);
    		max_x = Integer.max(max_x, point.x);
    		max_y = Integer.max(max_y, point.y);
    		min_x = Integer.min(min_x, point.x);
    		min_y = Integer.min(min_y, point.y);
    		System.out.println("x : " + point.x);
    		System.out.println("y : " + point.y);
    		System.out.println("--------------");
    		
    		list.add(point);
    	}
    	
    	int[][] graph = new int[max_y - min_y][max_x - min_x];
    	System.out.println("x : " + max_x);
		System.out.println("y : " + max_y);
		System.out.println("x : " + min_x);
		System.out.println("y : " + min_y);
		
		for (int i = 0; i < graph.length; i++) {
			
		}
        int answer = 0;
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrows = new int[] {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
		Level5_49190 cls = new Level5_49190();
		System.out.println(cls.solution(arrows));
	}

}
