fun main() {
    println(gcd(12 ,18))
    println(gcd(16 ,20))
    println(gcd(120 ,900))
    println(gcd(105 ,26))
}

fun gcd(a: Int, b: Int): Int {
    var a1 = a
    var b1 = b
    if (a == 0) {
        return abs(b)
    }
    if (b == 0) {
        return abs(a)
    }
    while (b1 != 0) {
        val h : Int = a1 % b1
        a1 = b1
        b1 = h
    }
    return abs(a1)
}

fun abs(n: Int): Int {
    if ( n < 0 ) {
        return 0-n
    }
    return n
}

