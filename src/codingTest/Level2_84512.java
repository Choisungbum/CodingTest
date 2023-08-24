package codingTest;

import java.util.ArrayList;
import java.util.List;

public class Level2_84512 {
	String[] word = {"A","E","I","O","U"};
	
	private static final char[] CHARS = "AEIOU".toCharArray();

	private List<String> generate(String word) {
		List<String> words = new ArrayList<>();
		words.add(word);
		
		if (word.length() == 5) return words;
		
		for(char c : CHARS) {
			words.addAll(generate(word+c));
		}
		
		 return words;
	}

	
	// 단어 만들기
	private int dictionary(String str) {
		List<String> dic = new ArrayList<>();
		int i = 0;
		int answer = 0;
		StringBuilder sb;
		
		// 첫 문자입력
		dic.add("A");
		while(true) {
			System.out.println("dic.get("+i+") : " + dic.get(i));
			if (str.equals(dic.get(i))) {
				answer = i + 1;
				break;
			}
			
			if ("UUUUU".equals(dic.get(i))) {
				break;
			}
			
			if(dic.get(i).length() != 5) {				// 해당 문자열이 5보다 작을경우
				sb = new StringBuilder(dic.get(i));
				dic.add(sb.append(word[0]).toString());
			} else if (dic.get(i).length() == 5) {			// 해당 문자열이 5일경우 word 배열에 있는 문자 순환
				dic.add(changeWord(dic.get(i)));
			}
			
			i++;
		}
		return answer;
	}
	
	private String changeWord (String str) {
		int len = str.length();
		String result = "";
		if ("U".equals(str.substring(len - 1, len))) {
			result = changeWord(str.substring(0, len - 1));
		} else {
			for(int j = 0; j < word.length; j++) {
				if (str.substring(len - 1, len).equals(word[j])) {
					result = str.substring(0, len - 1) + word[j+1];
				} 
			}
		} 
		return result;
	} 
	
	 public int solution(String word) {
	 	System.out.println("dic size = " + dictionary(word));
        int answer = dictionary(word);
        return answer;
    }
	 
	 public int solution2(String word) {
	        int answer = 0, per = 3905;
	        for(String s : word.split("")) answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
	        return answer;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level2_84512 cls = new Level2_84512();
		System.out.println(cls.solution("I"));
		for(String s : "AE".split("")) {
			System.out.println("s : " + s);
		}

	}

}
