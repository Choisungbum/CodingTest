package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Level4_60060 {
	private static class Node{
		private final Map<Integer, Integer> terminals = new HashMap<>(); // ? 개수별로 완성되는 단어의 개수
		private final Map<Character, Node> children = new HashMap<>(); // 자식 노드 
		
		private void add(String word, int offset) {
			int length = word.length() - offset;
			terminals.put(length, terminals.getOrDefault(length, 0) + 1);
			
			if (length > 0) {
				char c = word.charAt(offset);
				Node child = children.getOrDefault(c, new Node());
				child.add(word, offset + 1);
				children.put(c, child);
			}
		}
		
		public int count(String query, int offset) {
			if(query.charAt(offset) == '?') {
				return terminals.getOrDefault(query.length() - offset, 0);
			}
			
			char c = query.charAt(offset);
			if (!children.containsKey(c)) return 0;
			
			return children.get(c).count(query, offset + 1);
			
		}
	}
	
	private int count(String query, Node trie, Node reverseTrie) {
		if (query.startsWith("?")) {
			return reverseTrie.count(new StringBuilder(query).reverse().toString(), 0);
		}
		return trie.count(query, 0);
	}
	
	public int[] solution(String[] words, String[] queries) {
		int[] answer = new int[words.length];
		Node trie = new Node();
		Node reversedTrie = new Node();
		
		for(String word : words) {
			trie.add(word, 0);
			reversedTrie.add(new StringBuilder(word).reverse().toString(), 0);
		}
		
        return Arrays.stream(queries)
        		.mapToInt(query -> count(query, trie, reversedTrie))
        		.toArray();
    }
	public static void main(String[] args) {
		String[] words1 = new String[] {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries1 = new String[] {"fro??", "????o", "fr???", "fro???", "pro?"};
		String query = "fro??";
		
		// TODO Auto-generated method stub
		Level4_60060 cls = new Level4_60060();
		for (int i = 0 ;i < words1.length; i++) {
			System.out.println(cls.solution(words1, queries1)[i]);
			}
		
	}

}
