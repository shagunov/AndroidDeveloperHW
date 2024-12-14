fun main() {
    val list = List(20){(-100..100).random()}
    var sum = 0
    var count = 0
    for(element in list) {
        sum += element
        count++
    }
    var indicesSum = 0
    var sumOfTwoLastElements = 0
    for(idx in list.indices.first..list.indices.last){
        if(idx == list.indices.last){
            sumOfTwoLastElements = list[idx] + list[idx - 1]
        }
        indicesSum += idx
    }
    val average = sum.toDouble() / list.size.toDouble()

    println("Список: $list")
    println("\tПервый элемент списка: ${list.first()} и ${list[0]}")
    println("\tСреднее арифметическое: ${list.average()} и $average")
    println("\tСумма элементов: ${list.sum()} и $sum")
    println("\tКоличество элементов: ${list.count()} и $count")
    println("\tСумма последних двух элементов: ${list.takeLast(2).sum()} и $sumOfTwoLastElements")
    println("\tСумма индексов: ${list.indices.sum()} и $indicesSum")
}