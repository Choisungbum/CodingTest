package codingTest;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Level0_120886 {
//	private static Map<Character, Integer> toMap(String word) {
//		Map<Character, Integer> map = new HashMap<>();
//		for(char c : word.toCharArray()) {
//			map.putIfAbsent(c, 0);
//			map.put(c, map.get(c) + 1);
//		}
//		return map;
//	}
	public int solution(String before, String after) {
		List<Character> afterList = new ArrayList<>();
		
		for(char c : after.toCharArray()) {
			afterList.add(c);
		}
		
		for(char c : before.toCharArray()) {
			int idx = afterList.indexOf(c);
			if (idx > -1) {
				afterList.remove(idx);
			}
		}
        return afterList.size() == 0 ? 1 : 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String before1 = "olleh";
		String after1 = "hello";
		
		String before2 = "allpe";
		String after2 = "apple";

		Level0_120886 cls = new Level0_120886();
		System.out.println(cls.solution(before1, after1));
	}

}
