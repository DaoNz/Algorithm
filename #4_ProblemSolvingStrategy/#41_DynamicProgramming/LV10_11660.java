import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LV10_11660 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);        // 표의 크기
		int M = Integer.parseInt(input[1]);        // 구간합 개수
		
		int[][] table = new int[N][N];
		int[][] dp = new int[N + 1][N + 1];
		
		// N만큼 N개 입력
		for (int x = 0; x < N; x++) {
			input = in.readLine().split(" ");
			for (int y = 0; y < N; y++) {
				table[x][y] = Integer.parseInt(input[y]);
				
				dp[x + 1][y + 1] = dp[x][y + 1] + dp[x + 1][y] + table[x][y] - dp[x][y];
			}
		}
		
		for (int i = 0; i < M; i++) {
			int[] coord = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int startX = coord[0];
			int startY = coord[1];
			int endX = coord[2];
			int endY = coord[3];
			System.out.println(dp[endX][endY]
					- dp[endX - (endX - startX + 1)][endY]
					- dp[endX][endY - (endY - startY + 1)]
					+ dp[startX - 1][startY - 1]);
		}
	}
}
