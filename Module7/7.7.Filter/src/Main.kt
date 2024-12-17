fun main() {
    val people = mutableMapOf(5 to "Иван", 21 to "Петр", 33 to "Лида", 41 to "Петр", 25 to "Григорий", 4 to "Сергей", 2 to "Макар", 0 to "Лида", 311 to "Георгий")
    val people1 = people.filterKeys { it < 5 }
    val people2 = people.filterValues { it.last() == 'а' }
    val people3 = people.filterValues { it.first() == 'Г' }

    println("Список людей: $people")
    println("Значение ключа не больше 5: $people1")
    println("Имя заканчивается на \"а\": $people2")
    println("Имя заканчивается на \"Г\": $people3")

    val employees = hashMapOf(
        1 to 32,
        2 to 10,
        3 to 34,
        4 to 12,
        5 to 14,
        6 to 23,
        7 to 12,
        8 to 10,
        9 to 14,
        10 to 8,
        11 to 76,
        12 to 32,
        13 to 11,
        14 to 29,
        15 to 35)

    println("Сотрудники и премия: $employees")
    println("Сотрудники с номером на 5 и с премией более 20%: ${employees.filter { (int1, int2) -> int1 % 10 == 5 && int2 > 20 }}")
}