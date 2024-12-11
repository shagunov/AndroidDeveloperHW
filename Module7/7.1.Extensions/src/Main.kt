//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val number = (1..10).random()
    val number1 = number.sqr()
    println("$number1 - квадрат числа $number")

    val stroke1 = "hello"
    val stroke2 = ", world"
    val stroke = stroke1.concat(stroke2)
    println("\"$stroke1\" + \"$stroke2\" = \"$stroke\". Last index of stroke is ${stroke.lastIndex()}")

    val number2 = (1..1000).random()
    val sqrtNumber2 = number2.sqrt()
    println("$sqrtNumber2 - квадратный корень числа $number2")

}

fun Int.sqr(): Int{
    return this.times(this)
}

fun String.concat(other: String): String{
    return this + other
}

fun String.lastIndex(): Int{
    return this.lastIndex
}

fun Int.sqrt(): Double{
    return kotlin.math.sqrt(this.toDouble())
}