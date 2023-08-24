package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Level2_72412 {
		private Map<String, List<Integer>> buildScoresMap(String[] info) {
			Map<String, List<Integer>> scoresMap = new HashMap<>();
			for (String s : info) {
				String[] tokens = s.split(" ");
				int score = Integer.parseInt(tokens[tokens.length - 1]);
				forEachKey(0, "", tokens, key ->{
					scoresMap.putIfAbsent(key, new ArrayList<>());
					scoresMap.get(key).add(score);
				});
			}
			
			for(List<Integer> list : scoresMap.values()) {
				Collections.sort(list);
			}
			return scoresMap;
		}
	
	private void forEachKey(int index, String prefix, String[] tokens, Consumer<String> action) {
		if (index == tokens.length - 1) {
			action.accept(prefix);
			return;
		}
		forEachKey(index + 1, prefix + tokens[index], tokens, action);
		forEachKey(index + 1, prefix + "-", tokens, action);
	}
	
	private int count(String query, Map<String, List<Integer>> scoresMap) {
		String[] tokens = query.split(" (and )?");
		
		String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));
		
		if (!scoresMap.containsKey(key)) return 0;
		List<Integer> scores = scoresMap.get(key);
		
		int score = Integer.parseInt(tokens[tokens.length - 1]);
		
		return scores.size() - binarySearch(score, scoresMap.get(key));
	}
	
	private int binarySearch(int score, List<Integer> scores) {
		int start = 0;				 // inclusive 
		int end = scores.size() - 1; // inclusive
		
		while(end > start) {
			int mid = (start + end) / 2;
			
			if (scores.get(mid) >= score) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		if (scores.get(start) < score) {
			return scores.size();
		}
		
		return start;
	}
	
	public int[] solution(String[] info, String[] query) {
		Map<String, List<Integer>> scoresMap = buildScoresMap(info);
		int[] answer = new int[query.length];
		for(int i = 0; i < answer.length;i++) {
			answer[i] = count(query[i], scoresMap);
		}
		return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = new String[] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150"
									,"cpp backend senior pizza 260","java backend junior chicken 80"
									,"python backend senior chicken 50"};
		String[] query = new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200"
										,"cpp and - and senior and pizza 250","- and backend and senior and - 150"
										,"- and - and - and chicken 100","- and - and - and - 150"};
		
		Level2_72412 cls = new Level2_72412();
		int[] ans = cls.solution(arr, query);
		for (int i : ans) {
			System.out.println(i);
		}
	}

}

/*

private int getResult (String[] info, String query) {
		// query 분리 
		String[] splitQuery = query.replaceAll(" and","").split(" ");
		int cnt = 0; // 조건 일치 개수
		
		for (String s : info) {
			String[] splt = s.split(" ");
			
			
			for (int i = 0; i < splt.length; i++) {
				if (splitQuery[i].equals("-")) continue; // 부분 조건이 - 일경우 continue
				
				if (i != 4) {
					if(!splt[i].equals(splitQuery[i])) break; // 부분조건 일치여부 확인
				} else {
					if (Integer.parseInt(splt[i]) >= Integer.parseInt(splitQuery[i])) cnt++;
				}
			}
			
		}
		return cnt;
	}
	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		for (int i = 0; i < query.length; i++) {
			answer[i] = getResult(info,query[i]);
		}
        return answer;
    }
 * */
