import kotlin.math.absoluteValue

fun main() {
    val intArray = arrayOf(1, 3, 5, 3, 123, 3, 12, 22, 1, 4, 4, 3, 4).toList()
    val intSet = mutableSetOf<Int>().apply{ for(counter in 0 .. 19) add((-100..100).random()) }
    val evenSet = intSet.filter { it.absoluteValue % 2 == 0 }
    val oddSet = intSet.filter { it.absoluteValue % 2 == 1 }

    println("Множество чисел: $intSet")
    println("Чётные числа:    $evenSet")
    println("Нечётные числа:  $oddSet")

    val intSet2 = intSet.map { it * 2 }.filter { it.absoluteValue % 5 == 0 }
    println("Тот же список, но с удвоенными элементами, кратными пяти: $intSet2")

    println("Список с удалёнными повторами: ${removeDuplicates(intArray)}")

    val array = arrayOf(0, 6, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0)
    println(array.contentToString())
    println(nullsInEnd(array).contentToString())
}

fun <T> removeDuplicates(collection: Collection<T>?): Collection<T>?{
    return collection?.toMutableSet()
}

fun nullsInEnd(array: Array<Int>): Array<Int>{
    mainLoop@for(elemIdx in array.indices){
        if(array[elemIdx] == 0){
            for(elemIdx1 in elemIdx..<array.size) {
                if (array[elemIdx1] != 0){
                    val tmp = array[elemIdx1]
                    array[elemIdx1] = array[elemIdx]
                    array[elemIdx] = tmp
                    continue@mainLoop
                }
            }
        }
    }
    return array
}