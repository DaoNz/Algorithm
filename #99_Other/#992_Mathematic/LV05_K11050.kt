fun main() {
	val (n, m) = readln().split(' ').map { it.toInt() }
	println(n.fac() / (m.fac() * (n - m).fac()))
}

private fun Int.fac() : Int {
	var res = 1;
	for (i in 1..this) res *= i
	return res;
}

// 이항계수 구하기
// 이항계수 (N, M) -> N개중 M개를 고르는 경우의 수