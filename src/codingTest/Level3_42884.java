package codingTest;

import java.util.Stack;

public class Level3_42884 {
	public int solution(int[][] routes) {
		boolean[][] isVisited = new boolean[routes.length][routes.length];
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < routes.length; i++) {
			stack.push(i);
			
			while(!stack.isEmpty()) {
				int state = stack.pop();
				
				for(int j = 0; j < routes.length; j++) {
					if (isVisited[state][j]) continue;
					
					if (state == j) {
						isVisited[state][j] = true;
						continue;
					}
					
					if ((routes[state][0] <= routes[j][0] && routes[state][1] >= routes[j][0]) 
							|| (routes[state][0] <= routes[j][1] && routes[state][1] >= routes[j][1])) {
						isVisited[state][j] = true;
						System.out.println("isVisited[" + state + "][" + j + "] : " + isVisited[state][j]);
						stack.push(j);
					}
				}
			}
		}
		System.out.println(isVisited.toString());
		
        int answer = 0;
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] routes = {{-20,-15}
		 				 , {-14,-5}
		 				 , {-18,-13}
		 				 , {-5,-3}};
		 [[true, false, true, false], 
		  [false, true, true, true], 
		  [true, true, true, false], 
		  [false, true, false, true]]
		 Level3_42884 cls = new Level3_42884();
		 cls.solution(routes);
	}

}
