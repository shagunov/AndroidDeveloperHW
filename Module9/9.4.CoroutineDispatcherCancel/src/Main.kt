import kotlinx.coroutines.*
import java.util.*

data class Person(val name: String, val salary: Int)

class PersonManager {
    val personList = mutableListOf<Person>()

    fun addPerson(person: Person) {
        personList.add(person)
    }
}

val resultList = mutableMapOf<Person, Int>()

suspend fun main() = coroutineScope {
    println("Программа работы с базой данных сотрудников")
    delay(1000L)

    val personManager = PersonManager()

    loop@ while (true) {
        println("Добавить сотрудника:\n1.Да\n2.Прочитать базу данных")
        when (readlnOrNull()) {
            "1" -> {
                print("Введите имя сотрудника: ")
                val name = readlnOrNull() ?: ""
                print("Введите зарплату сотрудника: ")
                val salary = readlnOrNull()?.toIntOrNull() ?: 0
                val person = Person(name, salary)
                personManager.addPerson(person)
                println("Сотрудник $name добавлен.")
            }
            "2" -> break@loop
            else -> println("Некорректный ввод. Пожалуйста, выберите 1 или 2.")
        }
    }

    val job1 = launch {
        personManager.personList.forEach {
            addPassword(it)
        }
        readDataPersonList()
    }


    val job2 = launch {
        print("Введите 0 для отмены работы:\n")
        val input = readlnOrNull()

        if (input == "0") {
            job1.cancel()
            println("Завершение полной работы")
        }
    }

    job1.join()
    job2.join()
}

suspend fun addPassword(person: Person) {
    delay(500L)
    val password = (100000..999999).random()
    resultList[person] = password
}

suspend fun readDataPersonList() {
    for (i in resultList) {
        delay(1000L)
        println("Сотрудник: ${i.key}; пароль: ${i.value}")
    }
}
