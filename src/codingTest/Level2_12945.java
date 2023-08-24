package codingTest;

import java.util.Arrays;

public class Level2_12945 {
//	private static int fibonacci(int n) {
//		final int[] mem = new int[n+1];
//		mem[1] = 1;
//		for (int i = 0; i <= n - 1; i++) {
//			mem[i + 1] += mem[i];
//			if (i + 2 < mem.length) mem[i + 2] += mem[i]; 
//		}
//		
//		return mem[n];
//	}
	private static final int[] mem = new int[100001];
	
	private static int fibonacci(int n) {
		if (mem[n] != -1) return mem[n];
		
		if (n == 0 || n == 1) return n;
		
		return mem[n] = (fibonacci(n - 1) + fibonacci(n - 2) % 1234567);// 
		
	}
	public int solution(int n) {
		Arrays.fill(mem, -1);
        for (int i = 0; i < n; i++) {
        	fibonacci(i);
        }
        
		return fibonacci(n) ;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level2_12945 cls = new Level2_12945();
		System.out.println(cls.solution(20));
	}

}
