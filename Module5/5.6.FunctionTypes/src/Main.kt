//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val num = (0..10).random()
    println("Факториал числа $num равен ${recursiveFact(num)}")
    println("10 в $num-ой степени равно ${power10Recursive(num)}")

    val array = arrayOf(1, 2, 3, 4, 5, 6, 7)
    println("Исходный массив: ${array.contentToString()}")
    println("Массив после преобразования: ${incrementIntoOne(array).contentToString()}")
}

fun recursiveFact(num: Int): Int{
    if(num == 1) return 1
    if(num == 0) return 1
    return num * recursiveFact(num - 1)
}

fun power10Recursive(num: Int): Int{
    if(num == 1) return 10
    if(num == 0) return 1
    return 10 * power10Recursive(num - 1)
}

fun incrementIntoOne(array: Array<Int>): Array<Int>{
    val result = Array(array.size){0}
    for(elementIdx in array.indices){
        when(elementIdx % 2) {
            0 -> result[elementIdx] = array[elementIdx] + 1
            1 -> result[elementIdx] = array[elementIdx]
        }
    }
    return result
}