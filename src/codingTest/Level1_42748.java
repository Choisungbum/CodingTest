package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level1_42748 {
	 public int[] solution(int[] array, int[][] commands) {
		 int[] answer = new int[commands.length];
		 List<Integer> list = new ArrayList<>();
		 int tmp = 0;
	  	 for(int i = 0; i < commands.length; i++) {
	 		// 1. 배열자르기 
	 		int[] copyArr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
	 		
	 		// 2. 배열 정렬하기
	 		Arrays.sort(copyArr);
	 		
	 		// 3. 정렬된 배열에서 주어진 index 값 구하기
//	 		list.add(Arrays.asList(Arrays.stream(copyArr).boxed().toArray(Integer[]::new)).get(commands[i][2] - 1));
	 		answer[i] = copyArr[commands[i][2] - 1];
	  	 }
//        return list.stream().mapToInt(i -> i).toArray();
	  	 return answer;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level1_42748 cls = new Level1_42748();
		int[] arr = {1, 5, 2, 6, 3, 7, 4};
		int[][]cmd = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] ans = cls.solution(arr, cmd);
		for(int i : ans) {
			System.out.println(i);
		}
		
	}

}
