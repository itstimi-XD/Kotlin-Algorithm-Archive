package bruteforce.src

fun main() {
    val n = readln().toInt() // 콘솔에서 한 줄 읽어서 정수 변환 (예: 216)

    var result = 0 //  결과를 저장할 변수, 0이면 생성자 없음

    for (i in 1..<n) {
        if (decompositionSum(i) == n) {
            result = i
            break // 가장 작은 생성자를 찾으면 바로 종료
        }
    }
    println(result)
}

// i의 분해합을 구하는 함수
fun decompositionSum(x: Int): Int {
    var sum = x
    var num = x

    // num이 0이 될 때까지 각 자리수를 더한다
    while (num > 0) {
        sum += num % 10 // num % 10 하면 num의 마지막 자리수
        num /= 10       // num을 10으로 나눠서 자리수를 한 칸 당긴다.
    }
    return sum
}