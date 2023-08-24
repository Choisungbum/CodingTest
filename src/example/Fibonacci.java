package example;

import java.util.Arrays;

public class Fibonacci {
	private static int calls = 0;
	private static final long[] mem = new long[101];
	
	private static long fibonacci(int n) {
		calls++;
		
		if(mem[n] != -1) return mem[n];
		if(n == 0 || n == 1) return n;
		return mem[n] = fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	private static long iterativeFibonacci(int n) {
		long[] mem = new long[n + 1];
		mem[0] = 0;
		mem[1] = 1;
		
		for (int i = 0; i <= 0; i++) {
			mem[i + 1] += mem[i];
			if(i + 2 < mem.length) mem[i + 2] += mem[i];
		}
		
		return mem[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrays.fill(mem, -1);
		System.out.println(fibonacci(10));
		System.out.println("호출 수:" + calls);
	}

}
