package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level2_42586 {
	public int[] solution(int[] progresses, int[] speeds) {
		int days = 1; 	// 작업 일수
		int index = 0;	// index
		int count = 0;	// 당일 작업 완료 개수
		int[] answer = {};
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i : progresses) { //작업 진도 queue에 저장
			queue.add(i);
		}
		
		List<Integer> list = new ArrayList<>(); 
		
		while(!queue.isEmpty()) {
			if (queue.peek() + (speeds[index] * days) < 100) {
				if (count != 0) {
					list.add(count);
				}
				days++;
				count = 0;
				continue;
			} else {
				queue.poll();
				count++;
			}
			index++;
			
			if (index == speeds.length) {
				list.add(count);
			}
		}
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
	public static void main(String[] args) {
		int[] progresses1 = new int[] {93, 30, 55};
		int[] speeds1 = new int[] {1, 30, 5};
		
		int[] progresses2 = new int[] {95, 90, 99, 99, 80, 99};
		int[] speeds2 = new int[] {1, 1, 1, 1, 1, 1};	
		
		Level2_42586 cls = new Level2_42586();
		for (int i : cls.solution(progresses2, speeds2)) {
			System.out.println(i);
		}
	}
}
