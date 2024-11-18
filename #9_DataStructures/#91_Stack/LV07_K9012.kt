import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
	val input = BufferedReader(InputStreamReader(System.`in`));
	val case = input.readLine().toInt();
	
	for (i in 1..case) {
		val que = Stack<Byte>()
		var skip = false
		
		for (c in input.readLine().toCharArray()) {
			if (que.isEmpty() && c == ')') {
				println("NO")
				skip = true
				break;
			} else if (c == '(')
				que.push(1)
			else
				(que.pop())
		}
		
		if (!skip) {
			if (!que.isEmpty())
				println("NO")
			else
				println("YES")
		}
	}
}