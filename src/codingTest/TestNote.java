package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestNote {
	private final String[] wordSet = {"A", "E", "I", "O", "U"};
	private List<String> wordSet (String word, int offset, List<String> listSet) {
		listSet.add(word);
		if (word.length() == 5) return listSet;
		
		for (String s : wordSet) {
				wordSet(word + s, offset + 1, listSet);
		}
		return listSet;
	}
	public int solution(String word) {
		List<String> strList = wordSet("",0, new ArrayList<>());
		System.out.println(strList.size());
		
        return Arrays.asList(strList).indexOf(word);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestNote cls = new TestNote();
//		System.out.println(cls.solution("I"));
//		for(String s : "AE".split("")) {
//			System.out.println("s : " + s);
//		}
		System.out.println(cls.solution("I"));
		String[] str1 = new String[] {"AA", "E","AE"};
		Arrays.sort(str1);
		for  (String s : str1) {
			System.out.println(s);
		}
	}

}
