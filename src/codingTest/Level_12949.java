package codingTest;

public class Level_12949 {
	
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = {};
		int[][] arr = new int[arr1.length][arr2[0].length];
		// 1. arr1의 전체 원소 순차적으로 진행
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = 0;
				for (int k = 0; k < arr1[i].length; k++) {
					arr[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
        return arr;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
		int[][] arr2 = {{3, 3}, {3, 3}};
		int[][] arr3 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
		int[][] arr4 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
		int[][] arr5 = {{5, 4}, {-2, 4}, {3, 1}};
		int[][] arr6 = {{1, 2, 3}, {4, 5, 6}};
		int[][] arr7 = {{1, 4}, {2, 5}, {3, 6}};
		int[][] result = {};
		result = Level_12949.solution(arr6, arr7);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

}
