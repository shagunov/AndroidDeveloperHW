fun main() {
    val intArray = arrayOf(
        intArrayOf(3, 4, 1),
        intArrayOf(5, 6, 8),
        intArrayOf(1, 5, 6)
    )

    var minValue = intArray[0][0]
    for(row in intArray){
        for(element in row) {
            if (element < minValue) minValue = element
        }
    }

    println("Массив:\n")
    for(row in intArray){
        for (element in row){
            print("$element\t")
        }
        println()
    }
    println("Наименьший элемент - $minValue\n")


    val matrix = arrayOf(
        arrayOf(3, 12, 43, 19, 50),
        arrayOf(34, 54, 12, 5, 19),
        arrayOf(3, 5, 6, 5, 6),
    )

    println("Массив:\n")
    for(row in matrix){
        for (element in row){
            print("$element\t")
        }
        println()
    }
    println("Средний элемент: ${matrix[1][2]}")


    val binaryMatrix = arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 1, 0, 0),
        intArrayOf(0, 1, 1, 1, 0),
        intArrayOf(1, 1, 1, 1, 1)
    )

    println("Двоичная матрица:\n")
    for(row in binaryMatrix){
        for (element in row){
            print("$element\t")
        }
        println()
    }

    var firstMax = 0
    var secondMax = 0

    val arrayInt = intArrayOf(3, 5, 2, 56, 23, 654, 21, 452)
    for(element in arrayInt){
        when{
            element > firstMax -> {
                secondMax = firstMax
                firstMax = element
            }
            element > secondMax -> {
                secondMax = element
            }
        }
    }
    println("В массиве ${arrayInt.contentToString()} второе наибольшее число равно $secondMax")

}