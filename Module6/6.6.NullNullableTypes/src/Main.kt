//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    displayFavorBook(null)
    displayFavorBook("Архитектура компьютера")
    println()

    val number1 = 10
    val number2 = 2
    println(when(divideIfWhole(number1, number2))
        { null -> "Число $number1 не делится на $number2 без остатка\n"
          else -> "Число $number1 делится на $number2 без остатка ${divideIfWhole(number1, number2)} раз\n"
    })

    println("Число $number1 делится на $number2 без остатка ${divideIfWholeIfNoReturnZeroNumber(number1, number2)} раз\n")

    val array = arrayOf("Привет","как", null, "дела")
    val nonHaveNullArray = array.filterNotNull().toTypedArray()
    println("Исходный массив: ${array.contentToString()}")
    println("Массив без нулевых переменных: ${nonHaveNullArray.contentToString()}")
}

fun displayFavorBook(bookName: String?){
    if(bookName == null) println("У меня нет любимой книги")
    else println("Моя любимая книга - «$bookName»")
}

fun divideIfWhole(number1: Int, number2: Int): Int?{
    var divideCounter = 0
    var halfResult = number1
    var divisionRemainder = 0
    while(true){
        divisionRemainder = halfResult % number2
        halfResult /= number2
        if(divisionRemainder != 0) break
        divideCounter++
    }
    return if(divideCounter > 0) divideCounter
    else null
}

fun divideIfWholeIfNoReturnZeroNumber(number1: Int, number2: Int): Int{
    var divideCounter = 0
    var halfResult = number1
    var divisionRemainder = 0
    while(true){
        divisionRemainder = halfResult % number2
        halfResult /= number2
        if(divisionRemainder != 0) break
        divideCounter++
    }
    return divideCounter
}