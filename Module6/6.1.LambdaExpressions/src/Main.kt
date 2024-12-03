fun main() {
    timesPrint(5) { println("Hello, world!!!") };

    val average = { numbs: Array<Int> -> numbs.average() }
    val array = Array<Int>((5..10).random()) { (-100..100).random() }
    println("\nСреднее арифметическое массива: ${array.contentToString()} равно ${average(array)}")

    var numberOfPositiveNumbers = 0
    for (element in array) {
        if (element > 0) numberOfPositiveNumbers++
    }
    val positiveNumbersArray = Array(numberOfPositiveNumbers) { 0 }
    var counterOfPositiveArray = 0
    for (element in array) {
        if (element > 0) {
            positiveNumbersArray[counterOfPositiveArray] = element
            counterOfPositiveArray++
        }
    }
    println("Исходный массив: ${array.contentToString()}")
    println("Массив без отрицательных чисел: ${positiveNumbersArray.contentToString()}");

    val array1 = Array<Int>((5..10).random()) { (0..100).random() };

    println("Исходный массив: ${array1.contentToString()}");

    {array: Array<Int> ->
        for(elementIdx in array.indices){
            if(array[elementIdx] % 2 == 0) array[elementIdx] /= 2
            else if(array[elementIdx] % 2 == 1) array[elementIdx] *= 3
        }
    }(array1)

    println("Maссив с преобразованными элементами: ${array1.contentToString()}")
}

fun timesPrint(count: Int, print: () -> Unit){
    for(counter in 0..<count){
        print()
    }
}