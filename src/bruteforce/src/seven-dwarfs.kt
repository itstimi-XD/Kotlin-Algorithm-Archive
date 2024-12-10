package bruteforce.src

fun main() {
    // 1. 입력받기
    val dwarfs = IntArray(9) { readln().toInt() } // 아홉 난쟁이의 키를 배열로 입력받음

    // 2. 아홉 명 중 일곱 명을 고르는 모든 조합 검사
    for (i in 0..<9) { // 첫 번째 제외할 난쟁이
        for (j in i + 1..<9) { // 두 번째 제외할 난쟁이
            val selected = dwarfs.filterIndexed { index, _ -> index != i && index != j }
            if (selected.sum() == 100) {
                // 3. 출력: 오름차순으로 정렬하여 출력
                selected.sorted().forEach { println(it) }
                return // 정답을 찾았으니 프로그램 종료
            }
        }
    }
}