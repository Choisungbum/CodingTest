package codingTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Level2_42747 {
	 public int solution(int[] citations) {
	       int answer = 0;
			Arrays.sort(citations);
			for (int i = citations.length - 1, j = 0 ; i >= 0;i--, j++) {
				if (citations[i] <= citations.length) { // 배열에서 전체 크기보다 작은 원소를 찾음
					if (citations[i] <= j) {
						answer =j;
						break;
					} 
				}
				if (i == 0) {
					answer = citations.length;
					break;
				}
			}
	        return answer;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {3,0,6,1,5};
		int[] arr1 = new int[] {1,2,3,99,100,101,105};
		int[] arr2 = new int[] {1001,1002,1003};
		int[] arr3 = new int[] {5, 6, 7};
		int[] arr4 = new int[] {4, 4, 4, 3};
		Level2_42747 cls = new Level2_42747();
		System.out.println(cls.solution(arr4));
	}
}
