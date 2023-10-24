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
		int[] result = new int[] {1, 1};
		// 보석을 종류 
		Set<String> kind = new HashSet<>(Arrays.asList(gems));
		if (kind.size() == 1) return result ;
		// 1 에 gems 추가
		Queue<String> q_gems = new LinkedList<>(Arrays.asList(gems));
		List<String> list_gems = new ArrayList<>();
		Set<String> set_gems = new HashSet<>();
		// 2. q 에 있는
		int start = 1;
		int end = 1;
		while (!q_gems.isEmpty()) {
			// list_gem 에 기존 q에 들어있는 보석 후보 삽입
			String gem = q_gems.poll();
			list_gems.add(gem);
			
			// Set.copyOf 메서드를 통해 list에 있는 값이 kind의 갯수와 같을 경우 result 후보 
			if (Set.copyOf(list_gems).size() == kind.size()) {
				if (result[1] == 1) {
					result[0] = start;
					result[1] = end;
				} else if ((result[1] - result[0]) > end - start) {
					result[0] = start;
					result[1] = end;
				}
			}
						
			end += 1;
			System.out.println("end : " + end);
			
			if (list_gems.size() > 1) {
				if (list_gems.get(0).equals(gem)) {
					list_gems.remove(0);
					start += 1;
					System.out.println("start : " + start);
				}
				
				while (list_gems.get(0).equals(list_gems.get(1))) {
					list_gems.remove(0);
					start += 1;
					System.out.println("start : " + start);
				}
			}
			
 		}
		
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		/[]
		String[] gems1 = new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		Level_67258 cls = new Level_67258();
		System.out.println(cls.solution(gems1)[0] + "  " + cls.solution(gems1)[1]);
	}

}
