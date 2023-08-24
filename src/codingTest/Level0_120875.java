package codingTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Level0_120875 {
	private class Point{
		private final double x;
		private final double y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public double getLine (Point p1, Point p2) {
		return (p2.y - p1.y) / (p2.x - p1.x);
	}
	public int solution(int[][] dots) {
		int cnt = 0;
		int answer = 0;
		Set<Double> lineNum = new HashSet<>();
		List<Point> point = new ArrayList<>();
		
		for (int i = 0; i < dots.length; i++) {
			point.add(new Point(dots[i][0], dots[i][1]));
		}
		
		for(int j = 0; j < point.size(); j++) {
			for(int k =  j + 1; k < point.size(); k++) {
				if(lineNum.contains(getLine(point.get(j), point.get(k)))) {
					return 1;
				}
				lineNum.add(getLine(point.get(j), point.get(k)));
			}
		}
		
        return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] dots1 = new int[][] {{1, 4}, {9, 2}, {3, 8}, {11, 6}};
		int[][] dots2 = new int[][] {{3, 5}, {4, 1}, {2, 4}, {5, 10}};
		Level0_120875 cls = new Level0_120875();
		System.out.println(cls.solution(dots2));
	}

}
