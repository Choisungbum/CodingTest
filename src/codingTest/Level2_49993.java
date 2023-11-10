package codingTest;

import java.util.Arrays;

public class Level2_49993 {
	
	public int solution(String skill, String[] skill_trees) {
		return (int)Arrays.stream(skill_trees)
					.map(s -> s.replaceAll("[^" + skill + "]", ""))
					.filter(skill::startsWith)
					.count();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String skill = "CBD";
		String[] skill_trees = new String[] {"BACDE", "CBADF", "AECB", "BDA"};
		
		Level2_49993 cls = new Level2_49993();
		System.out.println(cls.solution(skill, skill_trees));
	}

}


/*
private boolean matchString (String skill, String str) {
		int matchChar = 0; // skillset 에 있는 skill 수 
		
		for (char c : str.toCharArray()) { 
			if (skill.indexOf(c) > -1) matchChar++;
		}
		
		StringBuilder matchStr = new StringBuilder(); // skillset에 있는 스킬트리 수를 고려한 정규식 생성 
		
		for (int i = 0; i < matchChar; i++) {
			matchStr.append(skill.charAt(i));
			matchStr.append("[A-Z]*");
		}
		
		String skillSet = "[A-Z]*" + matchStr.toString();
		
		return str.matches(skillSet);
	}
	
	public int solution(String skill, String[] skill_trees) {
		
		int answer = 0;
		for (String s : skill_trees) {
			if (matchString(skill, s)) answer++;
		}
        
        return answer;
    }
 * */
 