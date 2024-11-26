import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LV12_17144 {
	static int R;
	static int C;
	static int purifierHead;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		int T = Integer.parseInt(token.nextToken());
		int[][] room = new int[R][C];
		
		boolean find = false;
		for (int i = 0; i < R; i++) {
			token = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(token.nextToken());
				if (!find && room[i][j] == -1) {
					purifierHead = i;
					find = true;
				}
			}
		}
		for(int i = 0; i < T; i++) {
			spread(room);
			clean(room);
		}
		print(room);
	}
	
	public static void spread(int[][] room) {
		Queue<Coord> que = new LinkedList<>();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] > 4) {
					que.offer(new Coord(i, j, room[i][j]));
				}
			}
		}
		
		while (!que.isEmpty()) {
			Coord coord = que.poll();
			int x = coord.x;
			int y = coord.y;
			int dust = coord.weight / 5;
			int spreadCnt = 0;
			
			if (x > 0) {
				if (room[x - 1][y] != -1) {
					room[x - 1][y] += dust;
					spreadCnt++;
				}
			}
			if (x < R - 1) {
				if (room[x + 1][y] != -1) {
					room[x + 1][y] += dust;
					spreadCnt++;
				}
			}
			if (y > 0) {
				if (room[x][y - 1] != -1) {
					room[x][y - 1] += dust;
					spreadCnt++;
				}
			}
			if (y < C - 1) {
				if (room[x][y + 1] != -1) {
					room[x][y + 1] += dust;
					spreadCnt++;
				}
			}
			room[x][y] -= dust * spreadCnt;
		}
	}
	
	public static void clean(int[][] room) {
		int top = purifierHead;
		int bot = purifierHead + 1;
		
		room[top - 1][0] = 0;
		room[bot + 1][0] = 0;
		
		//공기청정기 위 처리
		for (int i = top - 1; i > 0; i--) {
			room[i][0] = room[i - 1][0];
			room[i - 1][0] = 0;
		}
		
		//공기청정기 아래 처리
		for (int i = bot + 1; i < R - 1; i++) {
			room[i][0] = room[i + 1][0];
			room[i + 1][0] = 0;
		}
		
		// 첫행, N행 처리
		for (int i = 0; i < C - 1; i++) {
			room[0][i] = room[0][i + 1];
			room[0][i + 1] = 0;
			
			room[R - 1][i] = room[R - 1][i + 1];
			room[R - 1][i + 1] = 0;
		}
		
		// M열 처리
		for (int i = 0; i < top; i++) {
			room[i][C - 1] = room[i + 1][C - 1];
			room[i + 1][C - 1] = 0;
		}
		for (int i = R - 1; i > bot; i--) {
			room[i][C - 1] = room[i - 1][C - 1];
			room[i - 1][C - 1] = 0;
		}
		
		//공기청정기 우측 처리
		for (int i = C - 1; i > 1; i--) {
			room[top][i] = room[top][i - 1];
			room[bot][i] = room[bot][i - 1];
			room[top][i - 1] = 0;
			room[bot][i - 1] = 0;
		}
	}
	
	public static void print(int[][] room) {
		int res = 2;
		for (int[] ar : room) {
			for (int a : ar) {
				res += a;
//				System.out.print(a + "\t");
			}
//			System.out.println();
		}
		System.out.println(res);
	}
	
	public static class Coord {
		int x;
		int y;
		int weight;
		
		Coord(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
	}
}
