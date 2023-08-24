package codingTest;

public class Level1_12926 {
	public static String solution(String s, int n) {
		//1. 문자열을 문자의 배열로 변환
		char[] arr = s.toCharArray();
		int letter = 0;
		//2. 각 문자를 아스키 코드로 변환 후 n 만큼 뒤로 이동
		for (int i = 0; i < arr.length; i++) {
			//2-1 공백이 있을경우 공백으로 남기기
			if (!Character.isAlphabetic(arr[i])) {
				continue;
			}
			//2-2 대소문자 구분후 z를 넘을경우 z + 1 이 a가 되도록 변환
			if('A' <= (int)arr[i] && (int)arr[i] <= 'Z') { // 대문자일 경우
				letter = (arr[i] + n) > 'Z' ? (arr[i] + n) - ('Z' - 'A') - 1: (arr[i] + n);
			} else if ('a' <= (int)arr[i] && (int)arr[i] <= 'z'){ // 소문자일 경우
				letter = (arr[i] + n) > 'z' ? (arr[i] + n) - ('z' - 'a') - 1: (arr[i] + n);
			}
			arr[i] = (char) letter;
			System.out.println("arr["+ i +"] : " + arr[i]);
		}
		
		String answer = String.valueOf(arr);
		System.out.println("answer : " + answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level1_12926.solution("Aa", 25);
	}

}
