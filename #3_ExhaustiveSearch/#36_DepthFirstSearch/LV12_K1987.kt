import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var arr: Array<CharArray>;
private lateinit var visit: Array<BooleanArray>;
private var set: HashSet<Char> = HashSet();
private var res = Int.MIN_VALUE;
private var dfsCnt = 0;

fun main() {
	val input = BufferedReader(InputStreamReader(System.`in`));
	val (R, C) = input.readLine().split(" ").map { it.toInt() }
	arr = Array(R) { CharArray(C) }
	visit = Array(R) { BooleanArray(C) { false } }
	
	for (i in 0 until R) {
		arr[i] = input.readLine().toCharArray();
	}
	
	dfs("", 0, 0, R, C);
	println(res)
	print(dfsCnt)
}

fun dfs(str: String, nowX: Int, nowY: Int, R: Int, C: Int) {
	dfsCnt++;
	var newChar = arr[nowX][nowY]
	
	if (!set.contains(newChar)) {
		set.add(newChar)
		var newStr = str + newChar.toString();
		res = Math.max(res, newStr.length)
		
		
		visit[nowX][nowY] = true;
		
		if (nowX > 0) {
			if (!visit[nowX - 1][nowY]) {
				dfs(newStr, nowX - 1, nowY, R, C);
			}
		}
		if (nowY > 0) {
			if (!visit[nowX][nowY - 1]) {
				dfs(newStr, nowX, nowY - 1, R, C);
			}
		}
		if (nowX < R - 1) {
			if (!visit[nowX + 1][nowY]) {
				dfs(newStr, nowX + 1, nowY, R, C);
			}
		}
		if (nowY < C - 1) {
			if (!visit[nowX][nowY + 1]) {
				dfs(newStr, nowX, nowY + 1, R, C);
			}
		}
		
		newStr = newStr.substring(0, newStr.length - 1);
		set.remove(newChar)
	}
	visit[nowX][nowY] = false;
}