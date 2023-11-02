package codingTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Level3_64063 {
	private static int[] parents;
	private static int[] rn;
	
	private int find(int x) {
		if (parents[x] == x) return x;
		return find(parents[x]);
	}
	
	private boolean union(int x, int y) {
		int ele = find(x);
		int add = find(y);
		
		if (ele == add) {
			
		}
		
		
		
		return true;
	}
	
	public long[] solution(long k, long[] room_number) {
		Set<Integer> set = new HashSet<>();
		
		
		
        long[] answer = {};
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
