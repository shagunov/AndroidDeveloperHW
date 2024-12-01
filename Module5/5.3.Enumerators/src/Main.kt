enum class Month(val month: String){
    JANUARY("january"),
    FEBRUARY("february"),
    MARCH("march"),
    APRIL("april"),
    MAY("may"),
    JUNE("june"),
    JULY("july"),
    AUGUST("august"),
    SEPTEMBER("september"),
    OCTOBER("october"),
    NOVEMBER("november"),
    DECEMBER("december")
}

enum class Season{
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN
}

class SeasonProgram{

    fun run(){}
}

fun main() {
    val seasonProgram = SeasonProgram()
    seasonProgram.run()

}