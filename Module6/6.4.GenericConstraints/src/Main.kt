class GenericMethod<T>(){
    fun <U: T> isItIncluded(array: Array<U>, element1: U): Boolean{
        for(element in array){
            if(element == element1) return true
        }
        return false
    }
}

fun main() {
    println("Среднее чисел 1, 2, 3, 6, 8, 19 равно ${getAverage(1, 2, 3, 6, 8, 19)}")
    val numbers = arrayOf(1, 2, 3, 6, 8, 19)
    println("Среднее чисел ${numbers.contentToString()} равно ${getAverage(numbers)}")

    val genericMethodInt = GenericMethod<Int>()
    println(genericMethodInt.isItIncluded(arrayOf(1, 2, 3, 4), 1))
}

@JvmName("getAverageVararg")
fun <T: Number> getAverage(vararg numbers: T): Double{
    var result = 0.0
    for(number in numbers) result += number.toDouble()
    return result / numbers.size
}

fun <T: Number> getAverage(numbers: Array<T>): Double{
    var result = 0.0
    for(number in numbers) result += number.toDouble()
    return result / numbers.size
}
