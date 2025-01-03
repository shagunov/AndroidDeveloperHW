import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlin.system.measureTimeMillis

class Storage {
    val text = """
        Мартышка к старости слаба глазами стала;
        А у людей про то она слыхала,
        Что это зло еще не так большой беды:
        Лишь стоит завести Очки.
        Очков с полдюжины себе достала;
        Вертит Очками так и сяк:
        То к темю их прижмет, то их на хвост нанижет,
        То их понюхает, то их полижет;
        Очки не действуют никак.
        "Тьфу пропасть!" говорит она, "и тот дурак,
        Кто слушает людских всех врак;
        Всё про Очки мне ложь сказали;
        А пользы нет в них ни на малой капли".
    """.trimIndent()
}


suspend fun getList(text: String, channel: Channel<String>) {
    text.split(" ", "\n", ",", ";", ":", ".", "!", "?", "\"").filter { it.isNotBlank() }.forEach { word ->
        channel.send(word)
        delay(10L)
    }
    channel.close()
}

suspend fun getStringList(text: String, channel: Channel<String>) {
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
        launch { getStringList(storage.text, channel2)}
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
