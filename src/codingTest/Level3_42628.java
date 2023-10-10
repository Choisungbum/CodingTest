package codingTest;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Level3_42628 {
	private static class DoublePriorityQueue{
		private int size = 0;
		private final PriorityQueue<Integer> minPq = new PriorityQueue<>();
		private final PriorityQueue<Integer> maxPq = new PriorityQueue<>((a, b) -> b - a);
	
		public void add(int value) {
			minPq.add(value);
			maxPq.add(value);
			size++;
		}
		
		public void removeMax() {
			if (size == 0) return;
			maxPq.poll();
			if (--size == 0) {
				maxPq.clear();
				minPq.clear();
			}
		}
		
		public void removeMin() {
			if (size == 0) return;
			minPq.poll();
			if (--size == 0) {
				maxPq.clear();
				minPq.clear();
			}
		}
		
		public int max() {
			if (size == 0) return 0;
			return maxPq.peek();
		}
		
		public int min() {
			if (size == 0) return 0;
			return minPq.peek();
		}
		
		
	}
	
	
	public int[] solution(String[] operations) {
		DoublePriorityQueue dpq = new DoublePriorityQueue();
		
			for (String operation : operations) {
				String[] token = operation.split(" ");
				String command = token[0];
				String value = token[1];
				// 연산처리 
				switch (command) {
				case "I" -> dpq.add(Integer.parseInt(value));
				case "D" -> {
						if (value.equals("1")) {
							dpq.removeMax();
						} else {
							dpq.removeMin();
						}
					}
				}
			}
        
        return new int[] {dpq.max(), dpq.min()};
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] operations = new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		Level3_42628 cls = new Level3_42628();
		System.out.println(cls.solution(operations)[0]);
	}

}
