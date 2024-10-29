import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LV15_2263 {
	
	static List<Integer> inArr = new ArrayList<>();
	static List<Integer> postArr = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int vertexCnt = Integer.parseInt(in.readLine());
		String[] inorderRes = in.readLine().split(" ");
		String[] postorderRes = in.readLine().split(" ");
		
		for (int i = 0; i < vertexCnt; i++) {
			inArr.add(Integer.parseInt(inorderRes[i]));
			postArr.add(Integer.parseInt(postorderRes[i]));
		}
		
		order(0, vertexCnt - 1, 0, vertexCnt - 1);
	}
	
	public static void order(int inLeft, int inRight, int postFirst, int postLast) {
		if (inLeft > inRight || postFirst > postLast) return;
		int root 	= postArr.get(postLast);
		int inCen 	= inArr.indexOf(root);
		
		System.out.print(root + " ");
		
		order(inLeft, inCen - 1, postFirst, postFirst + inCen - inLeft - 1);
		order(inCen + 1, inRight, postFirst + inCen - inLeft, postLast - 1);
	}
}