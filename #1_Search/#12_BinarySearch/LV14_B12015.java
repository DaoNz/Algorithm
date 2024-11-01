import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class LV14_B12015 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int size = Integer.parseInt(in.readLine());
        int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
            ArrayList<Integer> lis = new ArrayList<>();
            for (int num : arr) {
                if (lis.isEmpty() || lis.get(lis.size() - 1) < num) {
                    lis.add(num);
                } else {
                    int pos = lowerBound(lis, num);
                    lis.set(pos, num);
                }
            }
            System.out.println(lis.size());
    }

    private static int lowerBound(ArrayList<Integer> lis, int key) {
        int low = 0;
        int high = lis.size();
        
        while (low < high) {
            int mid = (low + high) / 2;
            if (lis.get(mid) < key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}