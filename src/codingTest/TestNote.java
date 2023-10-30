package codingTest;

public class TestNote {
	private static final int[] dx = {0, 1, 0, -1}; // 위 오른쪽 아래 왼쪽
	private static final int[] dy = {-1, 0, 1, 0};
	
	private static boolean getCharPlace(String[] place) {
		char[][] realPlace = new char[5][5];
		
		for (int i = 0; i < place.length; i++) {
			int j = 0;
			for (char p : place[i].toCharArray()) {
				realPlace[i][j] = p;
				j++;
			}
		}
		return isPerson(realPlace);
	}
	private static boolean isDistanced(char[][] realPlace, int x, int y, int exp) {
		// 사람 근처에 테이블이 있을 경우 
		int chk_x = 0;
		int chk_y = 0;
		
		for (int l = 0; l < 4; l++) { // 위 오른쪽 아래 왼쪽
			if ((exp + 2) % 4 == l) continue;
			
			chk_x = x + dx[l];
			chk_y = y + dy[l];
			
			if (chk_x < 0 || chk_x > 4 || chk_y < 0 || chk_y > 4) continue; // 사무실 범위 밖으로 넘어갈시 continue
			
			if (realPlace[chk_y][chk_x] == 'P') {
				return true;
			} 
		}
		return false;
	}
	
	private static boolean isPerson(char[][] realPlace) {
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < realPlace.length; i++) {
			for (int j = 0; j < realPlace[i].length; j++) {
				if (realPlace[i][j] == 'P') {
					for (int k = 0; k < 4; k++) { // 위 오른쪽 아래 왼쪽
						x = j + dx[k];
						y = i + dy[k];
						
						if (x < 0 || x > 4 || y < 0 || y > 4) continue; // 사무실 범위 밖으로 넘어갈시 continue
						
						switch(realPlace[y][x]) {
						case 'P' : return true;
						case 'O' : {
								if (isDistanced(realPlace, x, y, k)) {
									return true;
								}
							}
						}
					}
				} 
			}
		}
		return false;
	}
	
	
	public int[] solution(String[][] places) {
		int[] result = new int[5];
		for (int i = 0; i < places.length; i++) {
			if (getCharPlace(places[i])) {
				result[i] = 0;
			} else {
				result[i] = 1;
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String[][] place = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
				{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		
		TestNote cls = new TestNote();
		
		int[] arr = cls.solution(place);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
