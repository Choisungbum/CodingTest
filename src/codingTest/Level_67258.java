package codingTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Level_67258 {
	public int[] solution(String[] gems) {
		int start = 0;
		int end = gems.length - 1;
		
		Set<String> gemsSet = new HashSet<>(List.of(gems));
		
		int s = 0;
		int e = s;
		Map<String, Integer> includes = new HashMap<>();
		includes.put(gems[s], 1);
		
		while(s < gems.length) {
			if (includes.keySet().size() == gemsSet.size()) {
				if (e - s < end - start) {
					start = s;
					end = e;
				}
				
				includes.put(gems[s], includes.get(gems[s]) - 1);
				if (includes.get(gems[s]) == 0) {
					includes.remove(gems[s]);
				}
				s++;
			} else if (e < gems.length - 1) {
				e++;
				includes.put(gems[e], includes.getOrDefault(gems[e], 0) + 1);
			} else {
				break;
			}
			
		}
        return new int[] {start + 1, end + 1};
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		/[]
		String[] gems1 = new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		Level_67258 cls = new Level_67258();
		System.out.println(cls.solution(gems1)[0] + "  " + cls.solution(gems1)[1]);
	}

}
