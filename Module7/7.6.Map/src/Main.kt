data class Person(val name: String, val age: Int, val post: String)

fun main() {
    val array = arrayOf(3, 3, 2, 39, 10, 2, 43, 39, 3, 5, 6, 6, 5, 10)
    val map = mapDuplicates(array)
    println("Массив: ${array.contentToString()}")
    println("Отображение, в котором ключ - элемент, значение - количество в массиве: $map")

    val people = mutableMapOf(1 to "Иван", 2 to "Петр",3 to "Лида", 4 to "Петр", 5 to "Анна")
    println("Список людей: $people")
    println("Введите имя, которое нужно удалить из списка: ")
    val person = readln()
    println("Новый список: ${cutElement(people, person)}")

    val personHashMap = hashMapOf(
        1 to Person("Иван", 45, "Программист"),
        2 to Person("Матвей", 34, "Полицейский"),
        3 to Person("Екатерина", 32, "Президент")
    )
    personHashMap.forEach { (int, person) -> println("$int. Имя: ${person.name}, возраст: ${person.age}, должность: ${person.post}")}
}

fun <T> mapDuplicates(array: Array<T>): HashMap<T, Int>{
    val result = hashMapOf<T, Int>()
    for(element in array){
        if(result[element] == null) result[element] = 1
        else result[element] = result[element]!! + 1
    }
    return result
}

fun cutElement(map: Map<Int, String>, value: String): Map<Int, String>{
    return map.filterValues { it != value }
}