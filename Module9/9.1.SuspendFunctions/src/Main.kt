import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch

data class Person(val name: String, val age: Int)
data class Weather(val city: String, val description: String, val temp: Double)
suspend fun main() = coroutineScope{
    val persons = listOf(
        Person("Lisa", 25),
        Person("Eugene", 25),
        Person("Elena", 51),
        Person("Artyom", 18),
        Person("Daniel", 22),
        Person("Daniel", 23),
        Person("Vyatta", 23),
        Person("Stanislav", 40),
        Person("Victoria", 33),
        Person("Vasilis", 18),
    )
    val weatherList = listOf(
        Weather(city = "London", description = "Cloudy", temp = 12.5),
        Weather(city = "New York", description = "Sunny", temp = 25.0),
        Weather(city = "Tokyo", description = "Rainy", temp = 18.2),
        Weather(city = "Paris", description = "Partly cloudy", temp = 15.8),
        Weather(city = "Sydney", description = "Clear", temp = 28.1)
    )
    val randoms = List(10){ (1..100).random() }

    var downloadedPersons : List<Person>? = null
    var downloadedWeathers : List<Weather>? = null
    var downloadedRandoms : List<Int>? = null

    val downloads = listOf(
        launch { downloadedPersons = downloadData(persons) },
        launch { downloadedWeathers = downloadData(weatherList) },
        launch { downloadedRandoms = downloadData(randoms) }
    )

    downloads.joinAll()
    println("Данные загружены")
    println(downloadedPersons?.joinToString("\n") + "\n"
    + downloadedWeathers?.joinToString("\n", "\n") + "\n"
    + downloadedRandoms?.joinToString(", ", "\n") + "\n")

    println("Программа завершилась")
}

suspend fun <T> downloadData(list: List<T>) : List<T> {
    for(element in list){
        delay(1000L)
        println("Загрузка элемента: $element")
    }
    println("Список ${list.hashCode()} загружен")
    return list
}