package codingTest;

public class Level1_68935 {
	public int solution(int n) {
		String s = Integer.toString(n, 3);
		System.out.println("s : " + s);
		StringBuilder sb = new StringBuilder(s);
        int answer = Integer.parseInt(sb.reverse().toString(), 3);
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level1_68935 cls = new Level1_68935();
		
		System.out.println("cls.solution(45) :" + cls.solution(45));
	}

}
