package codingTest;

import java.util.ArrayList;
import java.util.List;

public class Level2_60057 {
	private List<String> split(String source, int length) {
		List<String> tokens = new ArrayList<>();
		for(int startIndex = 0; startIndex < source.length(); startIndex += length) {
			int endIndex = startIndex + length;
			if(endIndex > source.length()) endIndex = source.length();
			tokens.add(source.substring(startIndex, endIndex));
		}
		return tokens;
	}
	
	private int compress(String source, int length) {
		StringBuilder builder = new StringBuilder();
		
		String last = "";
		int count = 0;
		for(String token : split(source, length)) {
			if (token.equals(last)) {
				count++;
			} else {
				if (count > 1) builder.append(count);
				builder.append(last);
				last = token;
				count = 1;
			}
		}
		if (count > 1) builder.append(count);
		builder.append(last);
		System.out.println(builder);
		return builder.length();
	}
	public int solution(String s) {
		int  min = Integer.MAX_VALUE;
		for (int length = 1; length <= s.length(); length++) {
			int compressed = compress(s, length);
			if (min > compressed) { min = compressed;}
		}
        int answer = min;
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level2_60057 cls = new Level2_60057();
		System.out.println(cls.solution("aabbccc"));
	}

}
