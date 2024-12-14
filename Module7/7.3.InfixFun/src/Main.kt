class Person(private val name: String){
    infix fun say(message: String) = println("$message, $name")
}

data class Point(val x: Int, val y: Int)

fun main() {
    val numberLeftOperand = (1..199).random()
    val numberRightOperand = (1..199).random()

    println("Левый операнд: $numberLeftOperand. Правый операнд: $numberRightOperand.")
    println("\tСумма равна ${numberLeftOperand sum numberRightOperand}")
    println("\tРазность равно ${numberLeftOperand dif numberRightOperand}")
    println("\tПроизведение равно ${numberLeftOperand mul numberRightOperand}")
    println("\tЧастное равно ${numberLeftOperand div numberRightOperand}")
    println()

    val person = Person("Maxim")
    person say "Hello"

    val point1 = Point((-100..100).random(), (-100..100).random())
    val point2 = Point((-100..100).random(), (-100..100).random())

    when{
        point1 isAbove point2 -> println("$point1 выше, чем $point2")
        else -> println("$point1 ниже, чем $point2")
    }

    when{
        point1 isRight point2 -> println("$point1 правее, чем $point2")
        else -> println("$point1 левее, чем $point2")
    }
}

infix fun Int.sum(rightNumber: Int) = this + rightNumber
infix fun Int.mul(rightNumber: Int) = this * rightNumber
infix fun Int.dif(rightNumber: Int) = this - rightNumber
infix fun Int.div(rightNumber: Int) = this.toDouble() / rightNumber.toDouble()

infix fun Point.isAbove(other: Point) = this.y > other.y
infix fun Point.isRight(other: Point) = this.x > other.x