package codingTest;

public class Level2_68936 {
	private int[] quadZip(int[][] arr) {
		int zero = 0;
		int one = 0;
		int size = arr.length / 2;
		boolean zip = false;
		int[] answer = { 0, 0 };
		int[] ans = { 0, 0 };
		int[][] subArr = new int[size][size];
		/*
		 * 1 2
		 * 
		 * 3 4
		 * 
		 */
		if (size == 1) { // 재구함수 종료함수
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					if (arr[i][j] == 0) {
//						zero++;
						answer[0] = answer[0] + 1;
					} else {
//						one++;
						answer[1] = answer[1] + 1;
					}
				}
			}
			return answer;
		}
		// 1면조회
		int face1 = arr[0][0];
		zip = false;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				subArr[i][j] = arr[i][j];
				// 해당 면의 값중 하나라도 다를 경우
				if (face1 != arr[i][j]) {
					zip = true;

				}
			}
			if (i == size - 1) {
				if (zip == true) {
					ans = quadZip(subArr);
					zero = zero + ans[0];
					one = one + ans[1];
				} else {
					if (face1 == 0) {
						zero = zero + 1;
					} else {
						one = one + 1;
					}
				}
			}
		}
		// 2면조회
		int face2 = arr[0][size];
		zip = false;
		for (int i = 0; i < size; i++) {
			for (int j = size; j < size * 2; j++) {
				subArr[i][j - size] = arr[i][j];
				// 해당 면의 값중 하나라도 다를 경우
				if (face2 != arr[i][j]) {
					zip = true;
				}
			}
			if (i == size - 1) {
				if (zip == true) {
					ans = quadZip(subArr);
					zero = zero + ans[0];
					one = one + ans[1];
				} else {
					if (face2 == 0) {
						zero = zero + 1;
					} else {
						one = one + 1;
					}
				}
			}
		}
		// 3면조회
		int face3 = arr[size][0];
		zip = false;
		for (int i = size; i < size * 2; i++) {
			for (int j = 0; j < size; j++) {
				subArr[i - size][j] = arr[i][j];
				// 해당 면의 값중 하나라도 다를 경우
				if (face3 != arr[i][j]) {
					zip = true;
				}

			}
			if (i == size * 2 - 1) {
				if (zip == true) {
					ans = quadZip(subArr);
					zero = zero + ans[0];
					one = one + ans[1];
				} else {
					if (face3 == 0) {
						zero = zero + 1;
					} else {
						one = one + 1;
					}
				}
			}
		}

		// 4면조회
		int face4 = arr[size][size];
		zip = false;
		for (int i = size; i < size * 2; i++) {
			for (int j = size; j < size * 2; j++) {
				subArr[i - size][j - size] = arr[i][j];
				// 해당 면의 값중 하나라도 다를 경우
				if (face4 != arr[i][j]) {
					zip = true;
				}
			}
			if (i == size * 2 - 1) {
				if (zip == true) {
					ans = quadZip(subArr);
					zero = zero + ans[0];
					one = one + ans[1];
				} else {
					if (face4 == 0) {
						zero = zero + 1;
					} else {
						one = one + 1;
					}
				}
			}
		}
		if (zero + one == 4) { // 주어진 2차원배열이 0이나 1로 전부 채워져있을 경우 
			if (zero == 4) zero = 1;
			else if (one == 4) one = 1;
		}
		answer[0] = zero;
		answer[1] = one;
		return answer;
	}

	public int[] solution(int[][] arr) {

		int[] answer = quadZip(arr);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr1 = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
		int[][] arr2 = {{1,1,1,1,1,1,1,1},
						{0,1,1,1,1,1,1,1},
						{0,0,0,0,1,1,1,1},
						{0,1,0,0,1,1,1,1},
						{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
		int[][] arr3 = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
		int[][] arr4 = {{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0}};
		
		//		int[][] arr1 = {{1,1},{1,0}};  [[1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1]]
		Level2_68936 cls = new Level2_68936();
		cls.solution(arr2);
		System.out.println("answer0 : " + cls.solution(arr4)[0]);
		System.out.println("answer1 : " + cls.solution(arr4)[1]);
	}
}
/*
 * // 1면조회
		int face1 = arr[0][0];
		zip = false;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				subArr[i][j] = arr[i][j];
				// 해당 면의 값중 하나라도 다를 경우
				if (face1 != arr[i][j]) {
					zip = true;

				}
			}
			if (i == size - 1) {
				if (zip == true) {
					ans = quadZip(subArr);
					zero = zero + ans[0];
					one = one + ans[1];
				} else {
					if (face1 == 0) {
						zero = zero + 1;
					} else {
						one = one + 1;
					}
				}
			}
		}
		// 2면조회
		int face2 = arr[0][size];
		zip = false;
		for (int i = 0; i < size; i++) {
			for (int j = size; j < size * 2; j++) {
				subArr[i][j - size] = arr[i][j];
				// 해당 면의 값중 하나라도 다를 경우
				if (face2 != arr[i][j]) {
					zip = true;
				}
			}
			if (i == size - 1) {
				if (zip == true) {
					ans = quadZip(subArr);
					zero = zero + ans[0];
					one = one + ans[1];
				} else {
					if (face2 == 0) {
						zero = zero + 1;
					} else {
						one = one + 1;
					}
				}
			}
		}
		// 3면조회
		int face3 = arr[size][0];
		zip = false;
		for (int i = size; i < size * 2; i++) {
			for (int j = 0; j < size; j++) {
				subArr[i - size][j] = arr[i][j];
				// 해당 면의 값중 하나라도 다를 경우
				if (face3 != arr[i][j]) {
					zip = true;
				}

			}
			if (i == size * 2 - 1) {
				if (zip == true) {
					ans = quadZip(subArr);
					zero = zero + ans[0];
					one = one + ans[1];
				} else {
					if (face3 == 0) {
						zero = zero + 1;
					} else {
						one = one + 1;
					}
				}
			}
		}

		// 4면조회
		int face4 = arr[size][size];
		zip = false;
		for (int i = size; i < size * 2; i++) {
			for (int j = size; j < size * 2; j++) {
				subArr[i - size][j - size] = arr[i][j];
				// 해당 면의 값중 하나라도 다를 경우
				if (face4 != arr[i][j]) {
					zip = true;
				}
			}
			if (i == size * 2 - 1) {
				if (zip == true) {
					ans = quadZip(subArr);
					zero = zero + ans[0];
					one = one + ans[1];
				} else {
					if (face4 == 0) {
						zero = zero + 1;
					} else {
						one = one + 1;
					}
				}
			}
		}
 * */
