package codingTest;

public class Level2_81302 {
	private static int[] dx = {0, -1, 1, 0};
	private static int[] dy = {-1, 0, 0, 1};
	
	private boolean isDistanced(char[][] waiting) {
		for(int y = 0; y < waiting.length;y++) {
			for(int x = 0; x < waiting[y].length; x++) {
				if(waiting[y][x] != 'P') continue;
				if(!isDistanced(waiting, x, y)) return false;
			}
		}
		return true;
	}
	
	private boolean isNextToVolunteer(char[][] waiting, int x, int y, int exclude) {
		for(int d = 0; d < 4; d++) {
			if(d == exclude) continue;
			
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(ny < 0 || ny >= waiting.length || nx < 0 || nx >= waiting[ny].length) {
				continue;
			}
			
			if(waiting[ny][nx] == 'P') {
				return true;
			}
		}
		return false;
	}
	
	private boolean isDistanced(char[][] waiting, int x, int y) {
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(ny < 0 || ny >= waiting.length || nx < 0 || nx >= waiting[ny].length) {
				continue;
			}
			switch(waiting[ny][nx]) {
				case 'P' : return false;
				case 'O' : 
					if(isNextToVolunteer(waiting, nx, ny, 3 - d)) return false;
					break;
			}
		}
		return true;
	}
	
	public int[] solution(String[][] places) {
		
		int[] answer = new int[places.length];
		for(int i = 0; i < answer.length; i++) {
			String[] place = places[i];
			for (int j = 0; j < place.length;j++) {
				System.out.println("place["+j+"] : " + place[j]);
			}
			
			char[][] waiting = new char[place.length][];
			for(int j = 0; j < waiting.length;j++) {
				waiting[j] = place[j].toCharArray(); // toCharArray() : 문자열을 문자로 쪼개어줌 
//				for(int k =0; k < waiting[j].length; k++) {
//					System.out.println("waiting["+j+"]["+k+"] : " + waiting[j][k]);
//				}
			}
			if (isDistanced(waiting)) {
				answer[i] = 1;
			} else {
				answer[i] = 0;
			}
		}
		// 거리두기 
        return answer;
    }
	
	// position 확인하기
	// 상하좌우 파이션있는지 확인
	// 상하좌우 빈테이블일 경우 그 위 양옆 조사
	
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String[][] place = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
				{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		
		Level2_81302 cls = new Level2_81302();
		
		int[] arr = cls.solution(place);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

}
