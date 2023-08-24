package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Level3_43238 {
	private boolean isValid(long t, int n, int[] times) {
		long c = 0;
		for(int time : times) {
			c += t / time;
		}
		return c >= n;
	}
	public long solution(int n, int[] times) {
		long start = 0;
		long end = 1000000000000000000L;
		
		while(end > start) {
			long t = (start + end) / 2;
			
			if(isValid(t, n, times)) {
				end = t;
			} else {
				start = t + 1;
			}
		}
		
		return start;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[] times = new int[] {7, 10};
		Level3_43238 cls = new Level3_43238();
		System.out.println(cls.solution(n, times));
	}

}
