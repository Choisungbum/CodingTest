package codingTest;

import java.util.LinkedList;
import java.util.Queue;

public class Level2_42583 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int t = 0; // 전체 트럭이 다리를 통과하는데 걸리는 시간
        int curWeight = 0; // 현재 다리위에 올라간 트럭 무게
        
        Queue<Integer> tottruck_queue = new LinkedList<>(); // 대기 트럭수
        Queue<Integer> bridge_queue = new LinkedList<>();	// 현재 다리위의 트럭수
        
        for (int i : truck_weights) {
        	tottruck_queue.add(i);
        }
        
        while ((!tottruck_queue.isEmpty()) || (!bridge_queue.isEmpty())) {  // 대기트럭과 다리위 트럭이 모두 빌 때까지
        	t++;
        	if (!bridge_queue.isEmpty()) {
	        	if (bridge_length - 1 < bridge_queue.size()) {
	        		if (bridge_queue.peek() != -1) {
	        			curWeight -= bridge_queue.poll();	
	        		} else {
	        			bridge_queue.poll();
	        		}
	        	}
        	}
        	if (!tottruck_queue.isEmpty()) {
        		if (weight >= curWeight + tottruck_queue.peek()) {				// 현재 다리위 트럭 무게와 대기 트럭들의 첫 번째 트럭의 무게의 합이 weight 보다 작을 경우
        			int tmp = tottruck_queue.poll();
        			bridge_queue.add(tmp);
            		curWeight += tmp;
            	} else {
            		bridge_queue.add(-1);
            	}
        	} else {
        		t += bridge_length;
    			break;
        	}
        }
        
        return t - 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level2_42583 cls = new Level2_42583();
		int[] truck1 = new int[] {7,4,5,6};
		int[] truck2 = new int[] {10};
//		System.out.println(cls.solution(2, 10, truck1));
		System.out.println(cls.solution(100, 100, truck2));
	}

}
