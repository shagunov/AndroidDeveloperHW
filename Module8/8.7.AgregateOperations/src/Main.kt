data class Player(val name: String, val score: Int, val money: Double)

fun main() {
    val numberList = List(20){ (1..100).random() }
    val sum3to9 = numberList.foldIndexed(0) { idx, sum, element -> when {
        idx in 2..8 -> sum + element
        else -> sum
    }}

    println("Список чисел: ${ numberList.joinToString() }")
    println("Сумма с 3-го по 9-ый элемент: $sum3to9")
    println("Числа в одну строку: ${numberList.fold(""){ acc, element -> "$acc$element"}}")

    val playerList = listOf(
        Player("Alice", 1200, 500.50),
        Player("Bob", 850, 200.00),
        Player("Charlie", 1500, 750.25),
        Player("Diana", 900, 300.75),
        Player("Eve", 1100, 400.00)
    )

    println(playerList.joinToString("\n", "Список игроков.\n", "\n") { "\tигрок ${it.name}. Очки: ${it.score}. Количество денег: ${it.money}" })
    println("Общее количество очков: ${playerList.fold(0){ sum, element -> sum + element.score}}")
    println("Общее количетсво денег: ${playerList.fold(0.00){ sum, element -> sum + element.money}}")

    val fruits = listOf("Яблоко", "Абрикос", "Банан", "Виноград", "Вишня", "Кокос")
    println("Список фруктов: ${fruits.joinToString() }}")
    println("Список фруктов по первым буквам с чётной длиной строки\n" +
            "\t${fruits.groupBy { it[0] }.mapValues { it -> it.value.filter { it.length % 2 == 0 } }}")
}