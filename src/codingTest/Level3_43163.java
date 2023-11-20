package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level3_43163 {
	private static class State {
		private int depth;
		private String word;
		
		public State (int depth, String word) {
			this.depth = depth;
			this.word = word;
		}
		
	}
	public int solution(String begin, String target, String[] words) {
		Queue<State> queue = new LinkedList<>();
		List<String> wordlist = new ArrayList<>(Arrays.asList(words));

		queue.add(new State(0, begin));
		
		for (int i = 0; i < wordlist.size(); i++) {
			if (begin.compareTo(wordlist.get(i)) == 0) {
				wordlist.remove(i);
			}
		}
		
		while(!queue.isEmpty()) {
			System.out.println("start");
			State state = queue.poll();
			if (target.compareTo(state.word) == 0) {
				System.out.println("finish : " + state.word);
				return state.depth;
			}
			
			for (int i = 0; i < begin.length(); i++) {
				StringBuilder sb = new StringBuilder(state.word);
				sb.setCharAt(i, '.');
				String comp = sb.toString();
				
				for (int j = 0; j < wordlist.size(); j++) {
					if (wordlist.get(j).matches(comp)) {
						System.out.println("add word : " + wordlist.get(j));
						System.out.println("add depth : " + (state.depth + 1));
						queue.add(new State(state.depth + 1, wordlist.get(j)));
						wordlist.remove(j);
					}
				}
			}
			
		}
		return 0;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words1 = new String[] {"hot", "dot", "dog", "lot", "log", "cog"};
		String[] words2 = new String[] {"hot", "dot", "dog", "lot", "log"};
		String begin = "hit";
		String target = "cog";
		
		Level3_43163 cls = new Level3_43163();
		cls.solution(begin, target, words1);
	}
	

}

