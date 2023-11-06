package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Level4_60060 {
	private static class TrieNode{
		public Map<Integer, Integer> lenChildNode;
		public Map<Character, TrieNode> childNode;
		boolean lastWord;
		
		public TrieNode() {
			childNode = new HashMap<>();
			lenChildNode = new HashMap<>();
			lastWord = false;
		}
	}
	private static class Trie{
		private TrieNode root;
		private int cnt;
		
		public Trie() {
			root = new TrieNode();
		}
		
		public void insert(String word) {
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				if (node.lenChildNode.containsKey(word.length())) {
					int len = node.lenChildNode.get(word.length());
					node.lenChildNode.replace(word.length(), len + 1);
				} else {
					node.lenChildNode.put(word.length(), 1);
				}
				node.childNode.putIfAbsent(c, new TrieNode());
				System.out.println(word.length() + " " + node.lenChildNode.get(word.length()));
				node = node.childNode.get(c);
			}
			node.lastWord = true;
		}
		
		public int search (String query, int cnt) {
			TrieNode node = root;
			int index = 0;
			for (int i = 0 ;i < query.length(); i++) {
				char c = query.charAt(i);
				System.out.println(c);
				
				
				if (!node.childNode.containsKey(c)) {
					return cnt;
				}
				
				node = node.childNode.get(c);
				
				if (i + 1 <= query.length() && query.charAt(i + 1) == '?') { // 다음 문자가 ? 일 경우 
					index = i + 1;
					break;
				}
			}
			return cnt;
		}
		
		public boolean stattsWIth(String prefix) {
			TrieNode node = root;
			for (char c : prefix.toCharArray()) {
				if (!node.childNode.containsKey(c)) {
					return false;
				}
				node = node.childNode.get(c);
			}
			return true;
		}
		
	}
	
	
	public int[] solution(String[] words, String[] queries) {
		int[] answer = new int[words.length];
		Trie trie = new Trie();
		
		for (String s : words) {
			trie.insert(s);
			System.out.println(s);
		}
		
		for (int i = 0; i < queries.length;i++) {
			answer[i] = (trie.search(queries[i], 0));
		}
		
		
        
        return answer;
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
