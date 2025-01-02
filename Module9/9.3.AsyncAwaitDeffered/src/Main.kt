import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun getRandomList(size: Int, charSet: CharRange): List<Char> {
    return List(size) { charSet.random() }
}

fun getRandomList(size: Int, intRange: IntRange): List<Int> {
    return List(size) { intRange.random() }
}

suspend fun <T> unpack(list: List<T>): Int {
    var count = 0
    for (element in list) {
        delay(1000) // Задержка в 1 секунду
        println("Element: $element")
        count++
    }
    return count
}

fun <T> concatenate(vararg lists: List<T>): Pair<Int, MutableList<T>> {
    val combinedList = mutableListOf<T>()
    var totalSize = 0

    for (list in lists) {
        combinedList.addAll(list)
        totalSize += list.size
    }

    return Pair(totalSize, combinedList)
}

fun main() = runBlocking {
    val listSize = 10

    val intList = getRandomList(listSize, (1..100))
    val charList = getRandomList(listSize, ('a'..'z'))

    println("Start processing lists")
    val time = measureTimeMillis {
        val intUnpackJob = async { unpack(intList) }
        val charUnpackJob = async { unpack(charList) }

        val totalUnpackedSize = intUnpackJob.await() + charUnpackJob.await()
        println("Total unpacked size: $totalUnpackedSize")


        val concatenated = concatenate(intList, charList)
        println("Combined list size: ${concatenated.first}")
        println("Combined list: ${concatenated.second}")
    }
    println("Total processing time: $time")
    println("End processing lists")
}
