data class Place(val row: Int, val column: Int)
data class Time(val clocks: Int, val minutes: Int)

data class Ticket(val film: String, val place: Place, val time: Time){
    override fun toString(): String {
        return "\nФильм: $film\n" +
                "Время: ${time.clocks}:${time.minutes}\n" +
                "Место: ${place.row} ${place.column}"
    }
}

class Film(val filmName: String, private val beginTime: Time){
    private var placeArray = Array(20){Array(15){false}}
    fun reservePlace(place: Place): Ticket{
        if(place.row > placeArray.size || place.column > placeArray[0].size){
            println("Такого места нет в зале")
            return Ticket("", Place(0, 0), Time(0, 0))
        }
        if(!placeArray[place.row][place.column]) {
            placeArray[place.row][place.column] = true
            println("Билет успешно приобретён")
            println("Фильм: $filmName")
            println("Время: ${beginTime.clocks}:${beginTime.minutes}")
            println("Место: ${place.row} ряд, ${place.column} место")
            return Ticket(filmName, place, beginTime)
        }
        else println("Место уже занято")
        return Ticket("", Place(0, 0), Time(0, 0))
    }
}

fun main() {
    val ticket = mutableListOf<Ticket>()
    val seances = arrayOf(
        Film("Moscow", Time(10, 30)),
        Film("Ugly", Time(20, 40)))

    var film = ""
    var row = 0
    var column = 0
    loop@while (true){
        println("Ведите название фильма")
        film = readln()
        if(film == "exit") break
        println("Ведите ряд")
        row = readln().toInt()
        println("Введите место")
        column = readln().toInt()

        for(element in seances){
            if(film == element.filmName) {
                ticket.add(element.reservePlace(Place(row, column)))
                continue@loop
            }
        }
        println("Такого фильма не показывают")

    }

    println("Билеты: $ticket")


}