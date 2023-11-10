package codingTest;

import java.util.HashMap;
import java.util.Map;

public class Level1_67256 {
	private static class Point{
		private int x;
		private int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public void move(Point point) {
			this.x = point.x;
			this.y = point.y;
		}
		
		public int distance(Point point) {
			return Math.abs(this.x - point.x) + Math.abs(this.y - point.y);
		}
	}
	
	public String solution(int[] numbers, String hand) {
		Map<Integer, Point> keyPad = new HashMap<>();
		int index = 1;
		
		// 키패드 구현 
		for (int i = 0; i < 4;i++) {
			for (int j = 0; j < 3;j++) {
				keyPad.put(index++, new Point(j,i));
			}
		}
		// 0 번
		keyPad.put(0, keyPad.get(11));
		
		Point left = keyPad.get(10); // 왼손 시작 점
		Point right = keyPad.get(12); // 오른손 시작 점 
		
		char strHand = hand.toUpperCase().charAt(0);
		StringBuilder sb = new StringBuilder();
		
		// 다음 오는 숫자를 누를 손가락 지정
		for (int num : numbers) {
			switch (num) {
			case 1, 4, 7 -> {
				sb.append("L");
				left.move(keyPad.get(num));
				}
			case 3, 6, 9 -> {
				sb.append("R");
				right.move(keyPad.get(num));
				}
			case 2, 5, 8, 0 -> {
					int dist = left.distance(keyPad.get(num)) - right.distance(keyPad.get(num));
					
					if (dist > 0) { // 오른손이 가까운 경우
						sb.append("R");
						right.move(keyPad.get(num));
					} else if (dist == 0) {
						if (strHand == 'L') {
							sb.append("L");
							left.move(keyPad.get(num));
						} else {
							sb.append("R");
							right.move(keyPad.get(num));
						}
					} else {
						sb.append("L");
						left.move(keyPad.get(num));
					}
				}
			}
			
		}
		
        return sb.toString();
    }
	public static void main(String[] args) {
		int[] numbers1 = new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}; // "right"
		int[] numbers2 = new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		
		// TODO Auto-generated method stub
		Level1_67256 cls = new Level1_67256();
		System.out.println(cls.solution(numbers2, "left'"));
		
	}

}
