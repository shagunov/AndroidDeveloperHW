fun main() {
    val arrayFloat = arrayOf<Float>(3.4f, 32.2f, 43.3f, 12f, 43.245f, 32.2f, 33.342f, 34.6f, 323.5f, 75.3f)
    var mul = 1.0f
    for(number in arrayFloat){
        mul *= number
    }
    println("Массив: ${arrayFloat.contentToString()}. Произведение чисел: $mul\n")

    val arrayInt = arrayOf<Int>(3, 23, 543, 1234, 12, 54, 123, 54)
    var average = arrayInt.average()
    println("Массив: ${arrayInt.contentToString()}. Среднее арифметическое: $average")

    val evenIntArray = arrayInt.filter{value -> value % 2 == 0}.toIntArray()
    println("Чётные числа: ${evenIntArray.contentToString()}. Всего их ${evenIntArray.size}\n")

    val intArray = Array<Int>(9){1}
    for(index in intArray.indices){
        for(counter in 0..index){
            intArray[index] *= 2
        }
    }
    println("Массив со степенями двойки: ${intArray.contentToString()}.")

}