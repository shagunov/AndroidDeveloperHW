//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
data class Product(val name: String, var quantity: Int)

fun main() {
    val numbers = (1..20).toList()
    val numberCount = numbers.drop(4).count { it % 2 == 0 }
    val numberSum = numbers.take(7).sum()
    println("Числа: ${numbers.joinToString()}")
    println("Количество четных чисел списка, начиная с 5 элемента: $numberCount")
    println("Сумма первых 7 элементов: $numberSum\n")

    val stringList = listOf("one", "two", "three")
    val letterList = stringList.map{ it.toCharArray().toList() }.flatten()
    println("Список строк: ${stringList.joinToString()}")
    println("Список букв из него: ${letterList.joinToString()}\n")

    val stringList1 = listOf(
        "Книга",
        "Чашка",
        "Телефон",
        "Лампа",
        "Ключ",
        "Ручка",
        "Стол",
        "Стул",
        "Очки",
        "Компьютер",
        "Ноутбук",
        "Рюкзак",
        "Блокнот",
        "Наушники",
        "Зарядка"
    )

    val maxLengthString = stringList1.reduce{ acc, element ->
        if(element.length > acc.length) element
        else acc
    }
    println("Список слов: ${stringList1.joinToString()}")
    println("Самое длинное слово в списке: $maxLengthString\n")

    val products = listOf(
        Product("Яблоко", 10),
        Product("Банан", 15),
        Product("Апельсин", 8),
        Product("Молоко", 5),
        Product("Хлеб", 2),
        Product("Яйца", 12),
        Product("Сыр", 3),
        Product("Мясо", 1),
        Product("Рыба", 4),
        Product("Вода", 20)
    )

    val numberOfProducts = products.map{ it.quantity }.fold(0){ acc, element -> acc + element }
    println("Список продуктов: ${products.joinToString("\n\t", "\n\t"){"${it.name} - ${it.quantity} шт."}}")
    println("Общее число продуктов: $numberOfProducts\n")


}