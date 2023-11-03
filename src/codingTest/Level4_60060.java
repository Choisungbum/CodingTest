package codingTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Level4_60060 {
	private static class Node{
		public Map<Character, Node> childNode = new HashMap<>();
		boolean lastWord;
	}
	private static class TrieNode{
		Node rootNode = new Node();
		
		public void insert(String str) {
			Node node = this.rootNode;
			
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				node = node.childNode.computeIfAbsent(c, key -> new Node());
			}
			node.lastWord = true;
		}
		
		public boolean search(String str, int cnt) {
			Node node = new Node();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				node = node.childNode.getOrDefault(c, null);
				if (c == '?' && node.childNode.get(c) != null) {
					continue;
				}
				if (node.childNode.get(c) == null) {
					return false;
				}
			}
			return node.lastWord;
		}
	}
	
	
	public int[] solution(String[] words, String[] queries) {
		String[] words1 = new String[] {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries1 = new String[] {"fro??", "????o", "fr???", "fro???", "pro?"};
		int[] answer = {};
		
		TrieNode trie = new TrieNode();
		
		for (String s : words1) {
			trie.insert(s);
		}
		
		for (String s : queries1) {
			if (trie.search(s, 0)) {
				
			}
			
		}
		
		
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
