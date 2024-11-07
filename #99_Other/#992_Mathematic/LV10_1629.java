import java.util.Scanner;

public class LV10_1629 {
	
	static long C;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextLong();
		long B = sc.nextLong();
		C = sc.nextLong();
		
		System.out.println(modular(A, B));
	}
	
	public static long modular(long A, long B) {
		
		if (B == 1) return A % C;
		
		long base = modular(A, B/2);
		
		if (B % 2 == 1)
			return (base * base % C) * A % C;
		else
			return base * base % C;
	}
}
