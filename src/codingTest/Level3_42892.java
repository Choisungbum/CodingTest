package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level3_42892 {
	
	private static class Node {
		public final int value;
		public final int x;
		public final int y;
		
		Node right;
		Node left;
		 
		 public Node(int value, int x, int y) {
			 this.value = value;
			 this.x = x;
			 this.y = y;
		}
	}
	
	private Node constructTree(Node[] nodes) {
		Node root = nodes[0];
		
		//트리 구성 
		for (int i = 1; i < nodes.length;i++) {
			insert(root, nodes[i]);
		}
		
		return root;
	}
	
	private void insert(Node root, Node node) {
		// x 좌표에 따라 root 노드가 나타내는 트리에 node 삽입
		if (node.x < root.x) {
			// 왼쪽 서브 트리에 삽입
			if (root.left == null) {
				root.left = node;
			} else {
				insert(root.left, node);
			}
		} else {
			// 오른쪽 서브 트리에 삽입
			if (root.right == null) {
				root.right = node;
			} else {
				insert(root.right, node);
			}
		}
	}
	
	private void pre(Node node, List<Integer> visited) {
		if (node == null) return;
		
		visited.add(node.value);
		pre(node.left, visited);
		pre(node.right, visited);
	}
	
	private void post(Node node, List<Integer> visited) {
		if (node == null) return;
		
		post(node.left, visited);
		post(node.right, visited);
		visited.add(node.value);
	}
	
	 public int[][] solution(int[][] nodeinfo) {
		 
		Node[] nodes = new Node[nodeinfo.length];
		
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
		}
		//
		Arrays.sort(nodes, (a,b) -> b.y - a.y);
		
		Node root = constructTree(nodes);
		
		List<Integer> preorder = new ArrayList<>();
		pre(root, preorder);
		
		List<Integer> postorder = new ArrayList<>();
		post(root, postorder);
		
        return new int[][] {
        	preorder.stream().mapToInt(Integer::intValue).toArray(),
        	postorder.stream().mapToInt(Integer::intValue).toArray()
        };
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level3_42892 cls = new Level3_42892();
		int[][] nodeinfo1 = new int[][] {{5,3}, {11,5}, {13,3}, {3,5}, {6,1}, {1,3}, {8,6}, {7,2}, {2,2}};
		
		System.out.println(cls.solution(nodeinfo1));
	}

}
