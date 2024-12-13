package bruteforce.src

fun main() {
    // 1. 입력 받기
    val (n, m) = readln().split(" ").map { it.toInt() }
    val board = Array(n) { readln() }

    // 2. 체스판 패턴 정의
    val chess1 = Array(8) { i ->
        CharArray(8) { j -> if ((i + j) % 2 == 0) 'W' else 'B' }
    }
    val chess2 = Array(8) { i ->
        CharArray(8) { j -> if ((i + j) % 2 == 0) 'B' else 'W' }
    }

    // 3. 최소 칠해야 하는 칸 계산
    var minCount = Int.MAX_VALUE

    for (i in 0..n - 8) {
        for (j in 0..m - 8) {
            val subBoard = board.sliceArray(i..<i + 8)
            val count1 = countMismatch(subBoard, chess1, j)
            val count2 = countMismatch(subBoard, chess2, j)
            minCount = minOf(minCount, count1, count2)
        }
    }

    // 4. 결과 출력
    println(minCount)
}

// 5. 체스판과의 불일치 개수 계산
fun countMismatch(board: Array<String>, chess: Array<CharArray>, colStart: Int): Int {
    var count = 0
    for (i in 0..7) {
        for (j in 0..7) {
            if (board[i][j + colStart] != chess[i][j]) count++
        }
    }
    return count
}