import kotlinx.coroutines.*
import kotlin.system.exitProcess

suspend fun paymentProcess() {
    println("Оплата продукта началась")
    delay(2000) // 2 секунды
    println("Сканирование и обработка...")
    delay(2000)
    println("Покупка оплачена.")
}

suspend fun cancelPayment() {
    println("Отмена покупки...")
    delay(2000)
    println("Покупка отменена.")
}

fun goodBye() {
    println("До свидания")
}

fun main() = runBlocking {
    println("Программа покупки продуктов")
    delay(1000) // 1 секунда

    while (true) {
        print("Купить товар:\n1.Да\n2.Нет\n")
        val choice = readlnOrNull()

        when (choice) {
            "1" -> {
                paymentProcess()
                break
            }
            "2" -> {
                cancelPayment()
                break
            }
            else -> println("Ошибка: Неверный ввод. Пожалуйста, выберите 1 или 2.")
        }
    }
    goodBye()


    launch {
        println("Начало программы")
        launch{
            for(counter in 1..4){
                println(counter)
                delay(1000)
            }
        }
        launch {
            delay(4000L)
            println("Програма завершена")
        }
        val lazyLaunch = launch(start = CoroutineStart.LAZY) { println("Произошёл ленивый запуск") }
        delay(2000L)
        lazyLaunch.start()

    }

    Unit
}
