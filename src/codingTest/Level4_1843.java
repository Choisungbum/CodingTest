package codingTest;

import java.util.Arrays;
import java.util.Comparator;

public class Level4_1843 {
	private final int[][][] mem = new int[202][202][2];
	private interface IntComparator extends Comparator<Integer> {
	}
	private static final IntComparator[] COMP = {
			(a, b) -> Integer.compare(a, b),
			(a, b) -> Integer.compare(b, a)
	};
	
	private static final int[] INIT = {
		Integer.MAX_VALUE,
		Integer.MIN_VALUE
	};
	private int compute(int start, int end, int type, String[] arr) {
		if(mem[start][end][type] != Integer.MIN_VALUE) {
			return mem[start][end][type];
		}
		
		if (end - start == 1) return Integer.parseInt(arr[start]);
		
		int result = INIT[type];
		
		for (int i = start + 1; i < end; i+= 2) {
			int l = compute(start, i, type,  arr);
			int v;
			if (arr[i].equals("+")) {
				int r = compute(i + 1, end, type, arr);
				v = l + r;
			} else {
				int r = compute(i + 1, end, 1 - type, arr);
				 v = l - r;
			}
			
			if (COMP[type].compare(v, result) > 0) result = v;
		}
		return mem[start][end][type] = result;
	}
	
//	private final int[][] maxMem = new int[202][202];
//	private int max(int start, int end, String[] arr) {
//		if(maxMem[start][end] != Integer.MIN_VALUE) {
//			return maxMem[start][end];
//		}
//		
//		if (end - start == 1) return Integer.parseInt(arr[start]);
//		int max = Integer.MIN_VALUE;
//		for (int i = start + 1; i < end; i+= 2) {
//			int l = max(start, i, arr);
//			int v;
//			if (arr[i].equals("+")) {
//				int r = max(i + 1, end, arr);
//				v = l + r;
//			} else {
//				int r = min(i + 1, end, arr);
//				 v = l - r;
//			} if (v > max) max = v;
//		}
//		return maxMem[start][end] = max;
//	}
//	private final int[][] minMem = new int[202][202];
//	private int min(int start, int end, String[] arr) {
//		if(minMem[start][end] != Integer.MIN_VALUE) {
//			return minMem[start][end];
//		}
//		
//		if (end - start == 1) return Integer.parseInt(arr[start]);
//		int min = Integer.MAX_VALUE;
//		for (int i = start + 1; i < end; i+= 2) {
//			int l = min(start, i, arr);
//			int v;
//			if (arr[i].equals("+")) {
//				int r = min(i + 1, end, arr);
//				v = l + r;
//			} else {
//				int r = max(i + 1, end, arr);
//				 v = l - r;
//			} if (v < min) min = v;
//		}
//		return minMem[start][end] = min;
//	}
	public int solution(String arr[]) {
		for (int[][] m : mem) {
			for(int[] row : m) {
				Arrays.fill(row, Integer.MIN_VALUE);
			}
		}
//		for (int[] row : maxMem) {
//			Arrays.fill(row, Integer.MIN_VALUE);
//		}
//		
//		for (int[] row : minMem) {
//			Arrays.fill(row, Integer.MIN_VALUE);
//		}
//       return max(0, arr.length, arr);
		return compute(0, arr.length, 0, arr);
    }
	public static void main(String[] args) {
		

	}

}
