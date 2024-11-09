import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LV04_1987 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] arr = Arrays.stream(in.readLine().split(" "))
					.mapToInt(Integer::parseInt).toArray();
		
		int res = 0;
		for (int i = 0; i < N; i++) {
			int x = arr[i];
			boolean isPrime = true;
			
			for (int j = 2; j < x; j++) {
				if (x % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (x != 1 && isPrime) res++;
			
		}
		System.out.println(res);
	}
}
