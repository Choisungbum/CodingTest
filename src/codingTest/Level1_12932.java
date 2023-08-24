package codingTest;

public class Level1_12932 {
	 public static int[] solution(long n) {
		 StringBuilder longTostr = new StringBuilder(Long.toString(n));
	     String reverse = longTostr.reverse().toString();
	     int[] answer = new int[reverse.length()];
	     int i = 0;
	     for (char c : reverse.toCharArray()) {
	    	 answer[i] = Character.getNumericValue(c);
	    	 System.out.println("answer["+i+"] :" +answer[i]);
	    	 i++;
	     }
	     return answer;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("" + Level1_12932.solution(10000));
	}

}
