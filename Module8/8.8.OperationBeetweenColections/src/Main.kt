fun main() {
    val arrayString = listOf("one", "two", "three")
    val arrayReversedString = arrayString.map { it.reversed() }
    println("Список строк: ${arrayString.joinToString()}}")
    println("Список перевёрнутых строк: ${arrayReversedString.joinToString()}\n")

    val numberList = List(30){(1..100).random()}
    val quadraticNumberList = numberList.filter { it >= 3 }.map { it * it}
    println("Список чисел: ${numberList.joinToString()}")
    println("Список квадратов от чисел не больше, чем 3: ${quadraticNumberList.joinToString()}\n")

    val valuesArray = listOf("red", "blue", "white")
    val translatesArray = listOf("красный", "синий", "белый")
    val result = valuesArray zip translatesArray
    val stringInfo = result.joinToString("; ") { "Значение: ${it.first}, перевод: ${it.second}" }
    println("Списки слов: $valuesArray, $translatesArray")
    println(stringInfo + "\n")

    val stringArray = listOf("Jan", "Feb", "Mar", "Apr", "May")
    val charCount = stringArray.fold(0){ acc, element -> acc + element.length }
    println("Список строк: ${stringArray.joinToString()}")
    println("Общее количество символов в списке: $charCount")
}