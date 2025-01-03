import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlin.system.measureTimeMillis

class Storage {
    val text =
        "Мартышка к старости слаба глазами стала;\n" +
        "А у людей про то она слыхала,\n" +
        "Что это зло еще не так большой беды:\n" +
        "Лишь стоит завести Очки.\n" +
        "Очков с полдюжины себе достала;\n" +
        "Вертит Очками так и сяк:\n" +
        "То к темю их прижмет, то их на хвост нанижет,\n" +
        "То их понюхает, то их полижет;\n" +
        "Очки не действуют никак.\n" +
        "\"Тьфу пропасть!\" говорит она, \"и тот дурак,\n" +
        "Кто слушает людских всех врак;\n" +
        "Всё про Очки мне ложь сказали;\n" +
        "А пользы нет в них ни на малой капли\""
}


suspend fun getList(text: String, channel: Channel<String>) {
    text.split("\n").filter { it.isNotBlank() }.forEach { line ->
        channel.send(line)
    }
    channel.close()
}

suspend fun modifiedList(inputChannel: ReceiveChannel<String>, outputChannel: Channel<String>) {
    for (line in inputChannel) {
        val words = line.split(" ").filter { it.isNotBlank() }
        words.forEach{ word ->
            if (word.isNotEmpty())
                outputChannel.send(word[0].toUpperCase().toString())
        }

    }
    outputChannel.close()
}



fun main() = runBlocking {

    val storage = Storage()

    // --- Задание 1 ---
    val channel1 = Channel<String>()
    val time1 = measureTimeMillis {
        launch { getList(storage.text, channel1) }
        var stringResult = ""
        for (word in channel1) {
            stringResult += "$word "
        }
        println("Результат задания 1:\n$stringResult\n")
    }
    println("Время выполнения задания 1: $time1 мс\n")



    // --- Задание 2 ---
    val channel2 = Channel<String>()
    val channel3 = Channel<String>()
    val time2 = measureTimeMillis {
        launch { getList(storage.text, channel2)}
        launch { modifiedList(channel2, channel3) }


        var stringResult = ""
        for (symbol in channel3) {
            stringResult += symbol
        }

        val list = stringResult.chunked(1)
        println("Результат задания 2:\n$list\n")
    }
    println("Время выполнения задания 2: $time2 мс")
}
