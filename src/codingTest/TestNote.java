package codingTest;

import java.util.Arrays;
import java.util.stream.Stream;

public class TestNote {
	private static int[] devideArr(int x, int y, int[][] arr, int n, int nx, int ny,int[] cnt) {
		if (n == 1) {
			if (arr[y][x] == 1) {
				cnt[1] += 1;
			} else {
				cnt[0] += 1;
			}
			return cnt;
		}
		
		int tmp = arr[y][x];
		int halfN = n / 2;
		for (int i = y; i < ny; i++) {
			for (int j = x; j < nx; j++) {
				if (tmp != arr[i][j]) {
					devideArr(x, y, arr, halfN, halfN, halfN, cnt); 								 // 1 사분면
					devideArr(x + halfN, y, arr, halfN, halfN * 2, halfN, cnt); 				 // 2 사분면
					devideArr(x, y + halfN, arr, halfN, halfN, halfN * 2, cnt); 				 // 3 사분면
					devideArr(x + halfN, y + halfN, arr, halfN, halfN * 2, halfN * 2, cnt); // 4 사분면
					return cnt;
				} 
			}
		}
		
		if (tmp == 1) {
			cnt[1] += 1;
		} else {
			cnt[0] += 1;
		}
		return cnt;
	}
	public static int[] solution(int[][] arr) {
		return devideArr(0, 0, arr, arr.length, arr.length, arr.length, new int[] {0,0});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr1 = {{1,1,0,0},
						{1,0,0,0},
						{1,0,0,1},
						{1,1,1,1}};
		int[][] arr2 = {{1,1,1,1,1,1,1,1},
						{0,1,1,1,1,1,1,1},
						{0,0,0,0,1,1,1,1},
						{0,1,0,0,1,1,1,1},//  5, 5 나와야함
						{0,0,0,0,0,0,1,1}, 
						{0,0,0,0,0,0,0,1},
						{0,0,0,0,1,0,0,1},
						{0,0,0,0,1,1,1,1}};
		int[][] arr3 = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
		int[][] arr4 = {{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0}};
		System.out.println(TestNote.solution(arr2)[0] + " "+ TestNote.solution(arr2)[1]);

	}

}
