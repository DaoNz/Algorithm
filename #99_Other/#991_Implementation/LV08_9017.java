import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LV08_9017 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.readLine());

			HashMap<Integer, Integer> memCnt 		= new HashMap<>();
			HashMap<Integer, Queue<Integer>> ranks	= new HashMap<>();

			ArrayList<Integer> arr = new ArrayList<Integer>();
			Arrays.stream(in.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.forEach(arr::add);

			
			for (int i : arr) {
				if (!memCnt.containsKey(i)) memCnt.put(i, 0);
				memCnt.put(i, (int) memCnt.get(i) + 1);
			}
			
			int rank = 1;
			for (int i : arr) {
				if (memCnt.get(i) >= 6) {
					if (!ranks.containsKey(i))
						ranks.put(i, new LinkedList<>());
					
					ranks.get(i).offer(rank);
					rank++;
				}
			}
			
			int tmp = 0;
			int row = Integer.MAX_VALUE;
			arr = new ArrayList<Integer>();
			
			for (int i : ranks.keySet()) {
				for (int j = 0; j < 4; j++) {
					tmp += ranks.get(i).poll();
				}
				if (tmp < row) {
					row = tmp;
					arr.clear();
					arr.add(i);
					
				} else if (tmp == row) {
					row = tmp;
					arr.add(i);
				}
				
				tmp = 0;
			}
			
			row = Integer.MAX_VALUE;
			for (int i : arr) {
				int fifth = ranks.get(i).poll();
				if (fifth < row) {
					row = fifth;
					tmp = i;
				}
			}
			
			System.out.println(tmp);
		}
	}
}
