import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LV10_17615 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		String balls = in.readLine();
		
		char fColor = balls.charAt(0);
		char lColor = balls.charAt(N - 1);
		boolean FR = (fColor == 'R');
		boolean LR = (lColor == 'R');
		
		int leftCount = 1;
		int rightCount = 1;
		int rCount = 0;
		int bCount = 0;
		int i;
		
		i = 1;
		while (leftCount < N && fColor == balls.charAt(i)) {
			leftCount++;
			i++;
		}
	
		// TODO -- leftCount가 N과 같은 경우 건너뛸 수 있음
		i = 1;
		while (rightCount < N && lColor == balls.charAt(N - 1 - i)) {
			rightCount++;
			i++;
		}
		
		i = 0;
		while (i < N) {
			if (balls.charAt(i) == 'R') rCount++;
			else bCount++;
			i++;
		}
		
		int res;
		if (FR && LR) {
			res = Math.min(bCount, Math.min((rCount - leftCount), (rCount - rightCount)));
		} else if (FR) {
			res = Math.min((rCount - leftCount), (bCount - rightCount));
		} else if (LR) {
			res = Math.min((bCount - leftCount), (rCount - rightCount));
		} else {
			res = Math.min(rCount, Math.min((bCount - leftCount), (bCount - rightCount)));
		}
		
		System.out.println(res);
		
	}
}
//왼R오R
// ㄴ R전체 - lC (왼쪽으로 R몰기)
// ㄴ R전체 - rC (오른쪽으로 R몰기)
// ㄴ B전체 - 	(B 아무데나뺴기)

//왼R오B
// ㄴ R전체 - lC (왼쪽으로 R몰기)
// ㄴ B전체 - rC (오른쪽으로 B몰기)

//왼B오R
// ㄴ B전체 - lC (왼쪽으로 B몰기)
// ㄴ R전체 - rC (오른쪽으로 R몰기)


//왼B오B
// ㄴ B전체 - lC (왼쪽으로 B몰기)
// ㄴ B전체 - rC (오른쪽으로 B몰기)
// ㄴ R전체 - 	(R 아무데나뺴기)