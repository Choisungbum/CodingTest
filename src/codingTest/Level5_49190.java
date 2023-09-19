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
    	List<Point> left = new ArrayList<Point>();
    	List<Point> right = new ArrayList<Point>();
    	Point point = new Point(0, 0);
//    	for (int i : arrows) {
//    		point.move(dx[i], dy[i]);
//    		max_x = Integer.max(max_x, point.x);
//    		max_y = Integer.max(max_y, point.y);
//    		min_x = Integer.min(min_x, point.x);
//    		min_y = Integer.min(min_y, point.y);
//    		System.out.println("x : " + point.x);
//    		System.out.println("y : " + point.y);
//    		System.out.println("--------------");
//    		
//    		list.add(point);
//    	}
    	for (int i = 0; i < arrows.length; i++) {
    		point.move(dx[arrows[i]], dy[arrows[i]]);
    		list.add(point);
//    		System.out.println(list.get(i).x +" /list/ "+list.get(i).y);
    		
    		if (i == 0) {
    			switch(arrows[i]) {
    			case 1, 2, 3 -> right.add(new Point(0,0));
    			case 5, 6, 7 -> left.add(new Point(0,0));  
    			}
    			continue;
    		}
    		
    		int direct = (arrows[i] - arrows[i - 1]) % 8;
			switch(direct) {
			case 1, 2, 3 -> {right.add(point);}
			case -1, -2, -3 -> {left.add(point);}  
			}
			
			
    		
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
