fun main() {
    val a = 5
    val n = 3
    println("число $a в степени $n равно ${power(a, n)}")

    val c = 3
    val d = 5
    println("Произведение всех целых чисел от $c до $d включительно равно ${multiply(c, d)}")

    val r = 12
    val b = 24
    println("Наибольший общий делитель $r и $b равен ${nod(r, b)}")

}

fun power(number: Int, pow: Int) : Int{
    var result = 1
    for(counter in 1 .. pow){
        result *= number
    }
    return result;
}

fun multiply(a: Int, b: Int) : Int{
    var result = 1
    for(counter in a..b){
        result *= counter
    }
    return result
}

fun nod(number: Int, otherNumber: Int) : Int{
    var one = number
    var two = otherNumber

    while (one != 0 && two != 0) {
        when{
            one > two -> one %= two
            two > one -> two %= one
        }
    }

    return when{
        one != 0 -> one
        two != 0 -> two
        else -> 1
    }
}