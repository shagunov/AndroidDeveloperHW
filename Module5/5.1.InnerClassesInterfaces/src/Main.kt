//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val human = Human()
    human.standUp()

    val array = arrayOf("Иванов", "Петров", "Сидоров", "Процветов", "Протасов")
    val result = mutableListOf<String>()
    while(true){
        println("Введите строку для поиска")
        val searchString = readln()
        if(searchString == "exit") break
        for(element in array) if(element.contains(searchString)) result.add(element)
        println("Найденные фамилии: $result")
        result.clear()
    }

    val multiplier = {a: Int, b: Int -> a * b}
    val array1 = arrayOf(5, 6, 9, 0, 3, 5, 6, 0, 2, 4, 5, 6)
    var betweenZero = false
    var elementsBetweenZero = 0
    for(element in array1){
        if(betweenZero && element == 0) betweenZero = false
        else if(!betweenZero && element == 0) betweenZero = true
        else if (betweenZero) elementsBetweenZero++
    }
    println("В массиве ${array1.contentToString()} $elementsBetweenZero элементов между нулями")
}