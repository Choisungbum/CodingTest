package codingTest;

public class Level2_70129 {
	public static int result = 0; // 삭제한 0 개수
	private String isChanged (String s) {
		char[] ch = s.toCharArray();
		int leng = 0;
		for (int i = 0; i < s.length(); i++) {
			if(ch[i] == '1') {
				leng++;
			} else if (ch[i] == '0') {
				result++;
			}
		}
		return Integer.toString(leng, 2);
	}
	
	 public int[] solution(String s) {
		 	int[] answer = new int[2];
		 	int isChange = 1; // 반복횟수
		 	result = 0;
		 	
	 		String str = isChanged(s);
	 		while(true) {
	 			if (str.compareTo("1") == 0) {
	 				break;
	 			} 
	 			
	 			str = isChanged(str);
	 			isChange++;
	 		}
	 		answer[0] = isChange;
	 		answer[1] = result;
	        
	        return answer;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level2_70129 cls = new Level2_70129();
		for (int i = 0; i < 2; i++ ) {
			System.out.println("answer["+i+"] : " + cls.solution("1111111")[i]);
		} 
		System.out.println("result : " + result);
//		System.out.println("answer : " + cls.solution("01110")[0]);
	}

}
