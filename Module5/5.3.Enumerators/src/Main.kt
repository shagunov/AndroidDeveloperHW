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
    DECEMBER("december");

    fun season(): Season{
        return when (this) {
            Month.JANUARY, Month.FEBRUARY, Month.DECEMBER -> Season.WINTER
            Month.MARCH, Month.APRIL, Month.MAY -> Season.SPRING
            Month.JUNE, Month.JULY, Month.AUGUST -> Season.SUMMER
            Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER -> Season.AUTUMN
            else -> throw IllegalArgumentException("Неизвестный месяц") // Обработка неизвестного месяца
        }
    }
}

enum class Season(val season: String){
    WINTER("winter"),
    SPRING("spring"),
    SUMMER("summer"),
    AUTUMN("autumn");
}

class SeasonProgram{

    fun run(){
        while(true){
            println("Введите название месяца на английском маленькими буквами")
            val enterString = readln()
            val month = when (enterString) {
                Month.JANUARY.month -> Month.JANUARY
                Month.FEBRUARY.month -> Month.FEBRUARY
                Month.MARCH.month -> Month.MARCH
                Month.APRIL.month -> Month.APRIL
                Month.MAY.month -> Month.MAY
                Month.JUNE.month -> Month.JUNE
                Month.JULY.month -> Month.JULY
                Month.AUGUST.month -> Month.AUGUST
                Month.SEPTEMBER.month -> Month.SEPTEMBER
                Month.OCTOBER.month -> Month.OCTOBER
                Month.NOVEMBER.month -> Month.NOVEMBER
                Month.DECEMBER.month -> Month.DECEMBER
                else -> null // Обработка некорректного ввода
            }
            if (month == null) println("Неверное название месяца")
            else {
                val season = month.season()
                println("Наступила ${season.season}")
            }
            println("продолжить/закончить программу? (1/2)")
            when(readln()){
                "1" -> continue
                "2" -> break
                else -> continue
            }
        }


    }
}

fun main() {
    val seasonProgram = SeasonProgram()
    seasonProgram.run()

    data class FindResult(var symbol: Char, var repeatedCounter: Int = 1)
    val findResult = mutableListOf<FindResult>()

    val string = "Шумоизоляция"
    loop@for(char in string){
        for(element in findResult){
            if(char == element.symbol) {
                element.repeatedCounter++
                continue@loop
            }
        }
        findResult.add(FindResult(char))
    }

    println("Найдены повторяющиися символы")
    for(element in findResult){
        if(element.repeatedCounter > 1){
            println("${element.symbol} ${element.repeatedCounter} раз")
        }
    }
}