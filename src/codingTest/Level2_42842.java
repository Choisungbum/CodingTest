package codingTest;

public class Level2_42842 {
	   
    public int[] solution(int brown, int yellow) {
    	int[] answer = new int[2];
    	int x = 1;
    	int y = 1;
    	
    	for (x = 1; x <= yellow; x++) {
    		if (yellow % x == 0) {
    			y = yellow / x;
    		}
    		if (brown == 2 * x + 2 * y + 4) {
    			answer[0] = x < y ? y + 2 : x + 2 ;
    			answer[1] = x < y ? x + 2 : y + 2;
    			break;
    		}
    	}
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level2_42842 cls = new Level2_42842();
		System.out.println("answer : " + cls.solution(8, 1)[0] + " , " + cls.solution(8, 1)[1]);

	}

}
