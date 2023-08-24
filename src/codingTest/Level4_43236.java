package codingTest;

import java.util.Arrays;

public class Level4_43236 {
	private boolean isValid(int d, int[] rocks, int n) {
		int removed = 0;	// 제거한 바위의 개수
		int last = 0;		// 마지막 바위 위치
		for (int rock : rocks) {
			if (rock - last < d) {
				removed++;
				continue;
			}
			last = rock;
		}
		return removed <= n;
	}
	public int solution(int distance, int[] rocks, int n) {
		rocks = Arrays.copyOf(rocks, rocks.length + 1);
		rocks[rocks.length - 1] = distance;
		Arrays.sort(rocks);
        int start = 1;
        int end = distance + 1;
        while(end - start > 1){
            int d = (start + end) / 2;
            //d 조건 검사 후 범위 좁히기
            if(isValid(d, rocks, n) ) {
            	start = d;
            } else {
            	end = d;
            }
        }
		
        return start;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
