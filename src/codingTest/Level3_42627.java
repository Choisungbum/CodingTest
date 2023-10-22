package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Level3_42627 {
	private static class Job{
		public final int start;
		public final int duration;
		
		public Job(int start, int duration) {
			this.start = start;
			this.duration = duration;
		}
	}
	
	public int solution(int[][] rowJobs) {
		Job[] jobs = new Job[rowJobs.length];
		for (int i = 0; i < rowJobs.length; i++) {
			jobs[i] = new Job(rowJobs[i][0], rowJobs[i][1]); 
		}
		
		Arrays.sort(jobs, Comparator.comparing(job -> job.start));
		
		Queue<Job> q = new LinkedList<>(Arrays.asList(jobs));
		PriorityQueue<Job> pq = new PriorityQueue<Job>( Comparator.comparing(job -> job.duration));
		
		int exec = 0;
		int time = 0;
		
		while(!q.isEmpty() || !pq.isEmpty()) {
			while(!q.isEmpty() && q.peek().start <= time) {
				pq.add(q.poll());
			}
			
			if (pq.isEmpty()) {
				time = q.peek().start;
				continue;
			}
			
			Job job = pq.poll();
			exec += time + job.duration - job.start;
			time += job.duration;
		}
		
		
		
        return exec / jobs.length;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] jobs = new int[][] {{0, 3}, {1, 9}, {2, 6}};
		
		Level3_42627 cls = new Level3_42627();
		System.out.println(cls.solution(jobs));
		
	}

}
