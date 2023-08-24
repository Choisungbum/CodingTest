package codingTest;

import java.util.Arrays;

public class Level2_12915 {
	public String[] solution(String[] strings, int n) {
		 Arrays.sort(strings, (v1, v2) -> { if(v1.charAt(n) != v2.charAt(n)) {
												return v1.charAt(n) - v2.charAt(n);
											} else {
												return v1.compareTo(v2);
											}
		});
		 
        return strings;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level2_12915 cls = new Level2_12915();
		String[] str = new String[] {"sun", "bed", "car"};
		String[] str1 = new String[] {"abcd", "abce", "cdx"};
		for(String s : cls.solution(str1, 1)) {
			System.out.println(s);
		}
		
	}

}
