package codingTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Level3_42627 {
	public int solution(int[][] jobs) {
		int  result = 0;
		int[] job = new int[jobs.length];
		
		for (int i = 0; i < jobs.length;i++) {
			job[i] = i;
		}
		
//		Arrays.sort(job, (a, b) -> {jobs[a][0] - jobs[b][0]});
		
        return result / 3;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] jobs = new int[][] {{0, 3}, {1, 9}, {2, 6}};
		
		Level3_42627 cls = new Level3_42627();
		System.out.println(cls.solution(jobs));
		
	}

}
