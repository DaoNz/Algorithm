import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class LV10_15565 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> que = new ArrayDeque<>();
		String[] input;
		
		input = in.readLine().split(" ");
		int N = Integer.parseInt(input[0]); // 인형 총 개수
		int K = Integer.parseInt(input[1]); // 라이언 인형 최소 포함 개수
		
		input = in.readLine().split(" ");
		int res = Integer.MAX_VALUE;
		
		for (int i = N - 1; i >= 0; i--) {
			if (input[i].equals("1")) que.offer(i + 1);
			if (que.size() >= K) res = Math.min(res, que.pollFirst() - que.peekLast() + 1);
		}
		
		if (res == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(res);
		
	}
}
