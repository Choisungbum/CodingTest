package codingTest;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Level3_42627 {
	public int solution(int[][] jobs) {
		int  result = 0;
		int rqstTime = 0;
		int oprtTime = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (jobs[a][1] - jobs[b][1]));
		for (int i = 0; i < jobs.length;i++) {
			pq.add(i);
		}
		for (int i = 0; i < jobs.length;i++) {
			int tmp = pq.poll();
			rqstTime += jobs[tmp][1];
			System.out.println("rqstTime : " + rqstTime);
			System.out.println("rqstTime - jobs[tmp][0] : " + (rqstTime - jobs[tmp][0]));
			result += rqstTime - jobs[tmp][0];
			System.out.println("result : " + result);
		}
		System.out.println("result / 3 : " + result % 3);
        return result / 3;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] jobs = new int[][] {{0, 3}, {1, 9}, {2, 6}};
		
		Level3_42627 cls = new Level3_42627();
		System.out.println(cls.solution(jobs));
		
	}

}
