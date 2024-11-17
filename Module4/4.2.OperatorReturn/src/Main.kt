//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val array = arrayOf(3, 2, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 3, 5)
    println("В массиве чисел ${array.contentToString()} ${localMinimums(array)} локальных минимумов\n")

    val array1 = arrayOf(2, -2, 4, -5, -3, 32)
    println("Исходный массив: ${array1.contentToString()}")
    println("Преобразованный массив: ${incNegative(array1).contentToString()}\n")


    val rows = 5
    val columns = 6
    val matrix = Array(rows){Array(columns){0} }
    for(row in matrix.indices) {
        for (element in matrix[row].indices) {
            matrix[row][element] = (0..100).random()
        }
    }

    println("Матрица: ")
    for(row in matrix){
        for(element in row){
            print("$element\t")
        }
        println()
    }

    val k = 3
    // Поскольку в задании диапазон для значений (1 <= k <= M), k уменьшаем на единицу
    println("Строка $k: ${matrix[k - 1].contentToString()}")

    
}

fun localMinimums(array: Array<Int>) : Int{
    var result = 0
    for(index in array.indices){
        if(index < array.size - 1 && index > 0){
            if(array[index - 1] > array[index] && array[index + 1] > array[index]){
                result += 1
            }
        }
    }
    return result
}

fun incNegative(array : Array<Int>) : Array<Int>{
    val result = Array(array.size){0}

    for(index in array.indices){
        if(array[index] < 0){
            result[index] = array[index] + 1
        } else {
            result[index] = array[index]
        }
    }

    return result
}