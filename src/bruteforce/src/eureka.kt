package bruteforce.src

fun main() {
    // 입력받기
    val t = readln().toInt() // 테스트케이스 개수
    val cases = IntArray(t) { readln().toInt() } // 각 K 값을 저장

    // 1. 삼각수 계산
    val triangleNumbers = mutableListOf<Int>()
    for (n in 1..44) { // T₄₄까지 계산 (최대값 1000 이하)
        triangleNumbers.add(n * (n + 1) / 2)
    }

    // 2. 테스트케이스 처리
    for (k in cases) {
        if (isEureka(triangleNumbers, k)) {
            println(1) // 3개의 삼각수로 표현 가능
        } else {
            println(0) // 불가능
        }
    }
}

// 3개의 삼각수의 합으로 표현 가능한지 검사하는 함수
fun isEureka(triangleNumbers: List<Int>, k: Int): Boolean {
    for (i in triangleNumbers) {
        for (j in triangleNumbers) {
            for (l in triangleNumbers) {
                if (i + j + l == k) return true
            }
        }
    }
    return false
}