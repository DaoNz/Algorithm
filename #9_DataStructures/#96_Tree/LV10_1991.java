import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LV10_1991 {
	
	static HashMap<String, CusTree> map = new HashMap<>();
	static Queue<String> que = new LinkedList<String>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int lines = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < lines; i++) {
			String[] input = in.readLine().split(" ");
			map.put(input[0], new CusTree(input[0], input[1], input[2]));
		}
		
		que.add("A");
		preorder(que.poll());
		
		System.out.println();
		
		que.add("A");
		inorder(que.poll());
		
		System.out.println();
		
		que.add("A");
		postorder(que.poll());
	}
	
	//전위 순회
	public static void preorder(String first) {
		CusTree visit = map.get(first);
		System.out.print(visit.root);
		
		if (!visit.leftNode.equals(".")) {
			que.add(visit.leftNode);
			preorder(que.poll());
		}
		
		if (!visit.rightNode.equals(".")) {
			que.add(visit.rightNode);
			preorder(que.poll());
		}
	}
	
	//중위 순회
	public static void inorder(String first) {
		CusTree visit = map.get(first);
		
		if (!visit.leftNode.equals(".")) {
			que.add(visit.leftNode);
			inorder(que.poll());
		}
		System.out.print(visit.root);
		
		if (!visit.rightNode.equals(".")) {
			que.add(visit.rightNode);
			inorder(que.poll());
		}
	}
	
	//후위 순회
	public static void postorder(String first) {
		CusTree visit = map.get(first);
		
		if (!visit.leftNode.equals(".")) {
			que.add(visit.leftNode);
			postorder(que.poll());
		}
		
		if (!visit.rightNode.equals(".")) {
			que.add(visit.rightNode);
			postorder(que.poll());
		}
		
		System.out.print(visit.root);
	}
	
	//Tree
	public static class CusTree {
		private String root;
		private String leftNode;
		private String rightNode;
		
		public CusTree(String root, String leftNode, String rightNode) {
			this.root = root;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}
	}
}
