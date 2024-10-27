import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class LV08_15650 {

	static int[] arr;
	static int len;
	
	public static void main(String[] args) throws IOException{
		String[] in = new BufferedReader(new InputStreamReader(System.in))
				.readLine().split(" ");
		
		arr = new int[Integer.parseInt(in[0])];
		len = Integer.parseInt(in[1]);
		
		Arrays.setAll(arr, i -> i+1);
		
		for (int i = 0; i < arr.length; i++)
			printArr(new ArrayList<Integer>(), i);
	}
	
	public static void printArr(ArrayList<Integer> arrN, int index) {
		arrN.add(arr[index]);
		if (arrN.size() == len) {
			for (int i = 0; i < arrN.size(); i++)
				System.out.print(arrN.get(i) + " ");
			System.out.println();
		} else {
			if (index < arr.length - 1)
				for (int i = index + 1; i < arr.length; i++)
					printArr(new ArrayList<Integer>(arrN), i);
		}
	}
}