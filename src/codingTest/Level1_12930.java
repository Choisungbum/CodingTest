package codingTest;

public class Level1_12930 {
		// 1. 문자열을 단어로 분리
	    public String split(String s) {
	    	char[] chrs = s.toCharArray();
	    	int j = -1;
	    	for (int i = 0; i < chrs.length; i++) {
	    		// 공백인지 확인
	    		if (chrs[i] == ' ') { // = Character.isSpaceChar(c);
	    			// 공백 후의 문자가 공백이 아닐경우 단어의 첫번째 문자로 인식
	    			 j = -1;
	    		} else {
	    			j++;
	    			if (j % 2 == 0) {
	    				chrs[i] = Character.toUpperCase(chrs[i]);
	    			} else {
	    				chrs[i] = Character.toLowerCase(chrs[i]);
	    			}
	    		}
	    		System.out.println("chrs["+i+"] : " + chrs[i]);
	    	}
	    	return String.valueOf(chrs);
	    }
	   
	    public String solution(String s) {
	    	
	        String answer = split(s);
	        return answer;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level1_12930 test = new Level1_12930();
		System.out.println(test.solution("  tRy hello  WORLD    "));
	}

}

/*
 // 1. 문자열을 단어로 분리
	    public String[] split(String s) {
	    	String[] word = s.split(" ");
	    	for(int i = 0; i < word.length; i++) {
	    		// 2. 단어를 문자로 분해 후 재조립
	    		char[] chr = word[i].toCharArray();
	    		
	    		for (int j = 0; j < chr.length; j++) {
	    			if (j % 2 == 0) {
	    				chr[j] = Character.toUpperCase(chr[j]);
	    			} else {
	    				chr[j] = Character.toLowerCase(chr[j]);
	    			}
	    		}
	    		// 분리된 문자 재조립
	    		word[i] = String.valueOf(chr);
	    		System.out.println("word["+i+"] : " + word[i]);
	    	}
	    	return word;
	    }
	    // 마지막 문자가 공백인지 확인 
	    public boolean lastchar(String s) {
	    	// 마지막 문자가 공백인지 확인
	    	if (s.charAt(s.length() - 1) == ' ') {
	    		return true;
	    	}
	    	return false;
	    }
	    public String solution(String s) {
	    	StringBuilder ans = new StringBuilder();
	    	for (String str : split(s)) {
	    		ans.append(str + " ");
	    	}
	    	if(lastchar(s) == true) {
	    		ans.append(" ");
	    	}
	    	
	        String answer = ans.substring(0, ans.length() - 1).toString();
	        return answer;
	    }
 *
 */
