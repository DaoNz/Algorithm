import java.io.BufferedReader
import java.io.InputStreamReader

var min_15868 = Int.MAX_VALUE;
var home_15868: MutableList<Coord_15868> = ArrayList()
var bhc_15868: MutableList<Coord_15868> = ArrayList()

fun main() {
	var input = BufferedReader(InputStreamReader(System.`in`))
	var (N, M) = input.readLine().split(" ").map() { it.toInt() }
	
	
	// 집, 치킨집 좌표 저장
	for (i in 0 until N) {
		var str = input.readLine().replace(" ", "")
		for ((index, ch) in str.withIndex()) {
			if (ch == '1') home_15868.add(Coord_15868(i, index))
			else if (ch == '2') bhc_15868.add(Coord_15868(i, index))
		}
	}
	
	val arr = IntArray(bhc_15868.size) { it }
	val res = IntArray(M)
	combi_15868(arr, res, 0, 0, bhc_15868.size, M)
	print(min_15868)
}

fun combi_15868(arr: IntArray, result: IntArray, start: Int, index: Int, n: Int, r: Int) {
	if (index == r) {
		var tmp = 0;
		for (h in home_15868) {
			var chikDist = Int.MAX_VALUE;
			for (i in result) {
				var chik = bhc_15868[i]
				chikDist = Math.min(chikDist, (Math.abs(h.x - chik.x) + Math.abs(h.y - chik.y)))
			}
			tmp += chikDist
		}
		min_15868 = Math.min(min_15868, tmp)
		return
	}
	for (i in start until n) {
		result[index] = arr[i]
		combi_15868(arr, result, i + 1, index + 1, n, r)
	}
}

class Coord_15868(val x: Int, val y: Int)