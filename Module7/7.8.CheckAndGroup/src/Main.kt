//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val names = listOf(
        "Александр", "Андрей", "Анна", "Борис", "Василий", "Вера", "Виктор", "Галина", "Дмитрий", "Елена",
        "Иван", "Ирина", "Кирилл", "Мария", "Михаил", "Наталья", "Олег", "Сергей", "Татьяна", "Юрий"
    )

    println("Список имён: ${ names.toStringAnother() }")
    names.groupBy { it.first() }.forEach { println("\tНа букву ${it.key}: ${it.value.toStringAnother()}") }

    val strings = listOf(
        "кот", "дом", "снег", "лес", "река", "море", "гора", "солнце", "луна", "звезда",
        "облако", "ветер", "дождь", "птица", "рыба", "дерево", "трава", "цветы", "дорога", "автомобиль"
    )

    println()
    println("Строки: ${strings.toStringAnother()}")
    names.groupBy { it.length }.forEach { println("\t${it.key} сиволов: ${it.value.toStringAnother()}") }

    val phoneToYear = listOf(
        "Nexus One" to 2010,
        "Pixel 2" to 2017,
        "Pixel 4a" to 2020,
        "iPhone 4" to 2010,
        "iPhone X" to 2017,
        "Galaxy Note 8" to 2017,
        "Galaxy S11" to 2020
    )

    println()
    println("Список телефонов: $phoneToYear")
    phoneToYear.groupBy { it.second }.forEach { println("${it.key} год: ${it.value.toStringAnother()}") }




}

fun Collection<String>.toStringAnother() : String{
    var result = ""
    for(element in this){
        result += "$element, "
    }
    return result.substring(0, result.length - 2)
}

@JvmName("toStringAnotherPair")
fun Collection<Pair<String, Int>>.toStringAnother(): String{
    var result = ""
    for(element in this){
        result += "${element.first}, "
    }
    return result.substring(0, result.length - 2)
}