package codingTest;

import java.util.LinkedList;
import java.util.Queue;

public class Level3_1844 {
	private static final int[] dy = new int[] {1, 0, -1, 0}; // 남 동 북 서 
	private static final int[] dx = new int[] {0, 1, 0, -1};
	
	public void printBoolean (int[][] maps, boolean[][] isVisited) {
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j  < maps[0].length; j++) {
				System.out.print(isVisited[i][j] +  " ");
			}
			System.out.println("");
		}
		
		System.out.println("====================");
	}
	
	public int countVisited (boolean[][] isVisited) {
		int count = 0;
		for (boolean[] b : isVisited) {
			for (boolean bb : b) {
				if (bb) {
					count++;
				}
			}
		}
		return count;
	}
	
	private static class State{
		private int y;
		private int x;
		private int depth;
		
		public State (int y, int x, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
	
	public int solution(int[][] maps) {
		Queue<State> queue = new LinkedList<>();
		boolean[][] isVisited = new boolean[maps.length][maps[0].length];
		
		// 주어진 map의 왼쪽 위쪽이 막혀있으면 return 
		if (maps[maps.length - 1 - 1][maps[0].length - 1] == 0 
				&& maps[maps.length - 1][maps[0].length - 1 - 1] == 0 ) {
			return -1;
		}
		
		queue.add(new State(0, 0, 1)); // 초기 값 생성, 시작점 포함 
		isVisited[0][0] = true;
		
		while(!queue.isEmpty()) {
			State state = queue.poll();
			
			// 종료 조건 
			if (state.y == (maps.length - 1) && state.x == (maps[0].length - 1)) {
//				return countVisited(isVisited);
				return state.depth;
			}
			
			for (int index = 0; index < 4; index++) {
				 if (state.y + dy[index] < 0 || state.y + dy[index] > maps.length - 1) { // 주어진 y 범위를 벗어날 경우
					continue;
				} else if (state.x + dx[index] < 0 || state.x + dx[index] > maps[0].length - 1) { // 주어진 x 범위를 벗어날 경우
					continue;
				} else if (isVisited[state.y + dy[index]][state.x + dx[index]]) {
					continue;
				} else {
					if (maps[state.y + dy[index]][state.x + dx[index]] == 1) {
						queue.add(new State(state.y + dy[index], state.x + dx[index], state.depth + 1)); // 전이상태 생성 
						isVisited[state.y + dy[index]][state.x + dx[index]] = true; // 방문 처리 
//						System.out.println("y : " + (state.y + dy[index]) + " x : " + (state.x + dx[index]));
					}
				}
			}
		}
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] maps1 = new int[][] {{1,0,1,1,1}
									,{1,0,1,0,1}
									,{1,0,1,1,1}
									,{1,1,1,0,1}
									,{0,0,0,0,1}};
		int[][] maps2 = new int[][] {{1,0,1,1,1}
									,{1,0,1,0,1}
									,{1,0,1,1,1}
									,{1,1,1,0,0}
									,{0,0,0,0,1}};
									
		Level3_1844 cls = new Level3_1844();
		System.out.println(cls.solution(maps1));
	}

}
