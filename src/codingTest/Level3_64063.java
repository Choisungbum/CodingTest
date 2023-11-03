package codingTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Level3_64063 {
	private static class Node {
		private int depth = 1;
		private Node parent = null;
		
		private long max;
		
		public Node(long number) {
			max = number;
		}
		private Node root() {
			if (parent == null) return this;
			return parent.root();
		}
		
		public long max() {
			return root().max;
		}
		
		private boolean isConnected(Node o) {
			return root() == o.root();
		}
		
		public void merge(Node o) {
			if (isConnected(o)) return;
			
			Node root1 = root();
			Node root2 = o.root();
			
			if (root1.depth > root2.depth) {
				root2.parent = root1;
			} else if (root1.depth < root2.depth) {
				root1.parent = root2;
			} else {
				root2.parent = root1;
				root1.depth += 1;
			}
			root1.max = root2.max = Math.max(root1.max, root2.max);
		}
	}
	
	public long[] solution(long k, long[] room_number) {
		List<Long> assigned = new ArrayList<>();
		
		// 유니온 파인드 수행 
		
		Map<Long, Node> nodes = new HashMap<>();
		
	for (long number : room_number) {
		if (nodes.containsKey(number)) {
			number = nodes.get(number).max() + 1;
		}
		
		// number 방 실제 배정하기
		
		assigned.add(number);
		
		Node node = new Node(number);
		nodes.put(number, node);
		if (nodes.containsKey(number - 1)) {
			node.merge(nodes.get(number - 1));
		}
		
		if (nodes.containsKey(number + 1)) {
			node.merge(nodes.get(number + 1));
		}
		
		
	}
		
        return assigned.stream().mapToLong(Long::longValue).toArray();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
