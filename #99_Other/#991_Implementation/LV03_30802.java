import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LV03_30802 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] clothes = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] data = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int shirtSet = data[0];
		int penSet = data[1];
		
		int shirts = 0;
		for (int t : clothes) {
			if (t > 0) shirts = shirts + 1 + ((t - 1) / shirtSet);
		}
		
		System.out.println(shirts);
		System.out.println((N / penSet) + " " + (N % penSet));
	}
}
