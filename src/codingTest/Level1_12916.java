package codingTest;

public class Level1_12916 {
	boolean solution(String s) {
		int cntP = 0; // P의 개수
		int cntY = 0; // Y의 개수
		
		// 1-1. P의 개수 구하기 
		while (true) {
			if(s.indexOf("p") != -1 ) { //|| 
				s = s.replaceFirst("p", "");
				cntP++;
			} else if (s.indexOf("P") != -1) {
				s = s.replaceFirst("P", "");
				cntP++;
			} else {
				break;
			}
		}
		
		// 1-2. Y의 개수 구하기 
		while (true) {
			if(s.indexOf("y") != -1 ) { //|| 
				s = s.replaceFirst("y", "");
				cntY++;
			} else if (s.indexOf("Y") != -1) {
				s = s.replaceFirst("Y", "");
				cntY++;
			} else {
				break;
			}
		}
		
        boolean answer = cntP == cntY ? true : false;
        return answer;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdefghijklmnopq";
		System.out.println(s.length());
		System.out.println(s.substring(0,15));
		Level1_12916 cls = new Level1_12916();
		System.out.println(cls.solution("Ppyy"));
	}

}
