package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Level_67258 {
	public int[] solution(String[] gems) {
		// 보석을 종류 
		Set<String> kind = new HashSet<>(Arrays.asList(gems));
		if (kind.size() == 1) return new int[] {1, 1};
		// 1 에 gems 추가
		Queue<String> q_gems = new LinkedList<>(Arrays.asList(gems));
		List<String> list_gems = new ArrayList<>();
		// 2. q 에 있는
		
		int start = 0;
		int end = 0;
		while (!q_gems.isEmpty()) {
			// 
			// q_result 에 추가시 end + 1, q_result에서 poll() 시 start + 1
			
		}
		
        int[] answer = {};
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		/[]
		String[] gems1 = new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		Level_67258 cls = new Level_67258();
		System.out.println();
	}

}
