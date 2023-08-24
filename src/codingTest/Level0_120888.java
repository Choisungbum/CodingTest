package codingTest;

import java.util.HashSet;
import java.util.Set;

public class Level0_120888 {
	public String solution(String my_string) {
		char[] str = my_string.toCharArray();
		Set<String> delDupl = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		int setSize = 0; // 이전 set size()
		
		for (char c : str) {
			delDupl.add(String.valueOf(c));
			if (delDupl.size() == setSize) {
				continue;
			} else {
				setSize++;
				sb.append(c);
			}
		}
		
        return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level0_120888 cls = new Level0_120888();
		String my_string1 = "people";
		String my_string2 = "we are the world";
		
		System.out.println(cls.solution(my_string2));
	}

}
