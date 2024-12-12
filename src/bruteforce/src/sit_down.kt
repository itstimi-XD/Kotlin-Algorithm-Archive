package bruteforce.src

fun main() {
    // 1. 입력 받기
    val (a, b) = readln().split(" ").map { it.toInt() }

    // 2. 총 카드와 남은 카드 계산
    val totalCards = (1..10).flatMap { listOf(it, it) }.toMutableList()
    totalCards.remove(a)
    totalCards.remove(b)

    // 3. 상대방 패 조합 생성
    var winCount = 0
    var totalCases = 0

    for (i in totalCards.indices) {
        for (j in i + 1..<totalCards.size) {
            totalCases++
            val opponent = listOf(totalCards[i], totalCards[j])

            // 4. 족보 비교
            if (compareRank(listOf(a, b), opponent)) {
                winCount++
            }
        }
    }

    // 5. 승리 확률 계산
    val winProbability = winCount.toDouble() / totalCases
    println("%.3f".format(winProbability))
}

// 족보 비교 함수
fun compareRank(myCards: List<Int>, opponentCards: List<Int>): Boolean {
    val myRank = getRank(myCards)
    val opponentRank = getRank(opponentCards)
    return myRank > opponentRank
}

// 족보 계산 함수
fun getRank(cards: List<Int>): Int {
    return if (cards[0] == cards[1]) {
        100 + cards[0] // 땡: 높은 숫자일수록 강함
    } else {
        (cards.sum() % 10) // 끗: 합의 일의 자리
    }
}