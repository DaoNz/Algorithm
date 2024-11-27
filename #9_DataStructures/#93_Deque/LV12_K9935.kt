import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
	val input = BufferedReader(InputStreamReader(System.`in`))
	val sb = StringBuilder()
	val deq = ArrayDeque<Char>()
	
	val charArr = input.readLine().toCharArray()
	val explode = input.readLine().trim()
	val len = explode.length
	
	for (ch in charArr) {
		deq.add(ch)
		
		if (deq.size >= len && deq.last() == explode[explode.length - 1]) {
			var tmp = "";
			for (i in 1..len) {
				tmp = tmp popLink deq
			}
			if (tmp != explode)
				for (ch in tmp) {
					deq.add(ch)
				}
		}
	}
	
	if (deq.isEmpty()) {
		print("FRULA")
	} else {
		for (ch in deq) sb.append(ch)
	}
	
	print(sb)
}

private infix fun String.popLink(deq: ArrayDeque<Char>): String {
	val str = deq.removeLast();
	return str.toString() + this
}
