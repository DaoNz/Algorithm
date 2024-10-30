import java.util.Arrays;
import java.util.Scanner;

public class LV13_7579 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int Mem = sc.nextInt();
		
		sc.nextLine();
		int[] mems 	= Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] costs = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int costSum = Arrays.stream(costs).sum();
		int[][] dp = new int[N + 1][costSum + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= costSum; j++) {
				int remain = j - costs[i - 1];
				if (remain >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][remain] + mems[i - 1]);
				}
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
			}
		}
		for (int i = 0; i <= costSum; i++) {
			if (dp[mems.length][i] >= Mem) {
				System.out.println(i);
				break;
			}
		}
	}
}
