package codingTest;

import java.util.HashMap;
import java.util.Map;

public class Level1_42576 {
	public String solution(String[] participant, String[] completion) {
		Map<String, Integer> compMap = new HashMap<>();
		Map<String, Integer> partMap = new HashMap<>();
		String ans = "";
		
		for (String s : completion) {
			compMap.putIfAbsent(s, 0);
			compMap.put(s, compMap.get(s) + 1);
		}
		
		for (String s : participant) {
			if (!compMap.containsKey(s)) {
				ans = s;
			} 
			partMap.putIfAbsent(s, 0);
			partMap.put(s, partMap.get(s) + 1);	
			
			if (partMap.get(s) >= 2 && partMap.get(s) > compMap.get(s)) {
				ans = s;
			}
		}
		
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] part1 = new String[] {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] comp1 = new String[] {"josipa", "filipa", "marina", "nikola"};
		
		String[] part2 = new String[] {"mislav", "stanko", "mislav", "ana"};
		String[] comp2 = new String[] {"stanko", "ana", "mislav"};
		
		
		Level1_42576 cls = new Level1_42576();
		System.out.println(cls.solution(part2, comp2));
	}

}
