package codingTest;

public class Level3_42892 {
	private class Point {
		int x;
		int y;
		int node;
		
		public Point(int x, int y, int node) {
			this.x = x;
			this.y = y;
			this.node = node;
		}
	}
	
	class Node<Point> {
		 Point point;
		 Node<Point> parent;
		 Node<Point> right;
		 Node<Point> left;
		 
		 public Node(Point point) {
			 this.point = point;
			 right = null;
			 left = null;
		 }
	 }
	
//	public Node<Point> addNode(Node<Point> node) {
//		if (node == null) return new Node<Point>(node);
//		 
//	 }
	
	 public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level3_42892 cls = new Level3_42892();
		int[][] nodeinfo1 = new int[][] {{5,3}, {11,5}, {13,3}, {3,5}, {6,1}, {1,3}, {8,6}, {7,2}, {2,2}};
		System.out.println(cls.solution(null));
	}

}
