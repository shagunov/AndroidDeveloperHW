//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val registration = Registration()
    println(registration.getEmail())
    registration.setPassword("123")
    registration.setPassword("12345678")

    val matrix = initArray4x4()
    findEvenNumbersInArray4x4(matrix)

    val matrix1 = initArray4x4(minValue = - 100, maxValue = 100)
    findPositiveElementsInArray4x4(matrix1)

}

fun initArray4x4(array: Array<Array<Int>> = Array(4){Array(4){0}}, minValue : Int = 1, maxValue: Int = 16) : Array<Array<Int>>{
    if(array.size != 4 || array[0].size != 4){
        println("Размер массива не подходит!")
    }
    for(row in array){
        for(index in row.indices){
            row[index] = (minValue..maxValue).random()
        }
    }
    return array
}

fun findEvenNumbersInArray4x4(array: Array<Array<Int>>){
    if(array.size != 4 || array[0].size != 4){
        println("Размер массива не подходит!")
    }
    println()
    for(rowIndex in array.indices){
        for(elementIndex in array[rowIndex].indices){
            if(array[rowIndex][elementIndex] % 2 == 0){
                println("Найдено чётное число. Позиция: [$rowIndex, $elementIndex]. Значение: ${array[rowIndex][elementIndex]}.")
            }
        }
    }
    println()
}

fun findPositiveElementsInArray4x4(array: Array<Array<Int>>){
    if(array.size != 4 || array[0].size != 4){
        println("Размер массива не подходит!")
    }
    fun isPositive(number: Int) : Boolean{
        return number > 0
    }

    for(rowIndex in array.indices){
        for(elementIndex in array[rowIndex].indices){
            if(isPositive(array[rowIndex][elementIndex])){
                println("Найдено положительное число. Позиция: [$rowIndex, $elementIndex]. Значение: ${array[rowIndex][elementIndex]}.")
            }
        }
    }
}