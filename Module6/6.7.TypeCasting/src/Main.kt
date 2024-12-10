import com.sun.jdi.connect.Connector.Argument

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val stroke = "12.3"
    println("Строка $stroke.")
    println("Целое число ${stroke.toFloat().toInt()}.")
    println("Число с плавающей точкой ${stroke.toFloat()}.")
    println("Число в двоичном представлении ${Integer.toBinaryString(stroke.toFloat().toInt())}.")
    println()

    checkArgumentType("Привет")
    checkArgumentType(3L)
    checkArgumentType(3.1F)
    checkArgumentType('a')
    checkArgumentType(arrayOf(3,3,3))
    println()


    val string = "Mama"
    val int = 4
    val array = arrayOf(3, 4, 5, 6)

    println("${array.contentToString()} - ${printArgumentType(array)}")
    println("$int - ${printArgumentType(int)}")
    println("$string - ${printArgumentType(string)}")
}

fun <T> checkArgumentType(parameter: T){
    when (parameter) {
        is String -> println("Это строка.")
        is Int, is Long, is Short -> println("Это число.")
        is Float, is Double -> println("Это число с плавающей точкой.")
        is Char -> println("Это символ.")
        else -> println("Неизвестный тип.")
    }
}

fun <T> printArgumentType(argument: T): Int?{
    return when(argument){
        is Int -> argument + 1
        is String -> argument.length + 1
        is Array<*> -> argument.sumOf { element -> if(element is Int) element; else 0 }
        else -> null
    }
}