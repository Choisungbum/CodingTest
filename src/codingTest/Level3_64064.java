package codingTest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class Level3_64064 {
	private void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> banSet) {
		if (index == bans.length) {
			banSet.add(new HashSet<>(banned));
			return;
		}
		
		for(String id : bans[index]) {
			if (banned.contains(id)) continue;
			banned.add(id);
			count(index + 1, banned, bans, banSet);
			banned.remove(id);
		}
	}
	public int solution(String[] user_id, String[] banned_id) {
		String[][] bans = Arrays.stream(banned_id)
								.map(banned -> banned.replace("*","."))
								.map(banned -> Arrays.stream(user_id)
											         .filter(id -> id.matches(banned))
											         .toArray(String[]::new))
								.toArray(String[][]::new);
		Set<Set<String>> banSet = new HashSet<>();
		count(0, new HashSet<>(), bans, banSet);
		return banSet.size();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] user_id = new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = new String[] {"fr*d*", "abc1**"};
		String[] banned_id1 = new String[] {"*rodo", "*rodo", "******"};
		String[] banned_id2 = new String[] {"fr*d*", "*rodo", "******", "******"};
		
		Level3_64064 cls = new Level3_64064();
		System.out.print("answer : " + cls.solution(user_id, banned_id2));
//		String[][] answer = cls.getExcept_id(user_id, banned_id1);
//		
//		for(int i = 0; i < answer.length; i++) {
//			for(int j = 0; j < answer[i].length; j++) {
//				System.out.print("answer["+i+"]["+j+"] : " + answer[i][j] + " / "); 
//			}
//			System.out.print("\r\n");
//		}
		}

	}
/* 실패판소스
 private String[][] getExcept_id(String[] user_id, String[] banned_id){
  String[][] except_id = new  String[banned_id.length][user_id.length];
		Map<String, Integer> map = new HashMap<>();
		// banned_id 각 원소가 mapping 되는 user_id 의 원소를 찾아 2차원 배열에 저장
		for(int i = 0; i < banned_id.length; i++) {
			for(int j = 0; j < user_id.length; j++) {
				if (user_id[j].matches(banned_id[i].replace("*", "."))) {
					except_id[i][j] = user_id[j];
				} 
			}
		}
		
		return except_id;
	}
	
	private int factorial(int n) {
		if (n == 1) return 1;
		
		return n * factorial(n - 1);
	}
 * */
