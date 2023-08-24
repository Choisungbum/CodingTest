package codingTest;

import java.util.Objects;

public class Level1_72410 {
	
	public String solution(String new_id) {
		// 1. 단게 대문자를 소문자로 
		new_id = new_id.toLowerCase();
		// 2. 단계 알파벳 소문자, 숫자, -, _, . 제외한 나머지 문자제거
		new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
		// 3.연속된 마침표는 하나의 마침표로 변경
		new_id = new_id.replaceAll("[.]{2,}", ".");
		// 4.마침표가 처음과 끝에 있다면 제거
		new_id = new_id.replaceAll("^[.]|[.]$", "");
		// 5.문자열이 비었다면 "a"대입
		new_id = new_id.isEmpty() ? "a" : new_id;
		// 6. 길이가 16이상이면 첫 15개의 문자를 제외한 나머지 문자를 모두 제거 
		new_id = new_id.length() > 15 ? new_id.substring(0,15) : new_id;  
		new_id = new_id.replaceAll("[.]$", "");
		// 7. 길이가 16이상이면 첫 15개의 문자를 제외한 나머지 문자를 모두 제거 
		StringBuilder sb = new StringBuilder(new_id);
		if(3 > new_id.length()) {
			for (int i = 0; i < 3 - new_id.length(); i++) {
				sb.append(new_id.substring(new_id.length() - 1));
			}
			new_id = sb.toString();
		}
       return new_id;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level1_72410 cls = new Level1_72410();
		System.out.println("answer : " + cls.solution("=.="));
	}

}
