//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var card = BankCard("2311", "1234-1243-1242-1244", "1231")
    card.getDataCard("2322")
    card.getDataCard("2311")
    println(card.cardNumber)

    var a = (0..30).random()
    val b = a
    a += 7
    a -= 4
    a *= 2
    a %= 3
    println("Число a = $b после преобразований равно $a")

    val x = (10..99).random()
    val y = x % 10 * 10 + x / 10
    println("Исходное число: $x, полученное число: $y")

}