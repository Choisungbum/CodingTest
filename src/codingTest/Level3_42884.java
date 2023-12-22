package codingTest;

import java.util.Arrays;
import java.util.Comparator;

public class Level3_42884 {
	public int solution(int[][] routes) {
		
		Arrays.sort(routes, Comparator.comparing(route -> route[1]));
		int last = Integer.MIN_VALUE;
		int count = 0;
		
		for (int[] route : routes) {
			if (last >= route[0] && last <= route[1]) continue;
			last = route[1];
			count++;
		}
		
		
		return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] routes1 = {{-20,-15}
		 				 , {-14,-5}
		 				 , {-18,-13}
		 				 , {-5,-3}};
		 
		 int[][] routes2 = {{-20,-13}
						 , {-18,-15}
						 , {-12,-5}
						 , {-5,-3}};
		 int[][] routes3 = {{0,5}
						 , {2,8}
						 , {4,10}
						 , {9,13}};
//		 [[true, false, true, false], 
//		  [false, true, true, true], 
//		  [true, true, true, false], 
//		  [false, true, false, true]]
		 // SEt에 해당 연결관계 넣고 Set사이즈랑 총 하나하나 크기 빼고 Set에 다 안들어 갈 경우 그 수 많큼 추가 필요 e
		 Level3_42884 cls = new Level3_42884();
		 System.out.println("result : " + cls.solution(routes1));
	}

}
