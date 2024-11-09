fun main() {
    val n = 12
    var harmonicSeries = 0.0
    for(counter in 1..n){
        harmonicSeries += 1.0 / counter.toDouble()
    }
    println("Значение суммы первых $n членов гармонического ряда равна $harmonicSeries\n")

    val a = 2
    val b = 24

    var sum = 0
    for(counter in a .. b){
        sum += counter * counter
    }
    println("Сумма квадратов чисел от $a до $b включительно равна $sum\n")

    val A = 3
    val B = 10
    println("Полученный ряд : ")
    for(counter in A .. B){
        for(count in 0 .. counter - A){
            print(counter)
        }
        print(" ")
    }

    println("\nЧто это такое: синий, большой, с усами и полностью набит зайцами?")
    loop@ for(counter in 1 .. 3){
        when (readln().toString()) {
            "Троллейбус" -> {
                println("Правильно!")
                break@loop
            }
            "Сдаюсь" -> {
                println("Правильный ответ: Троллейбус.")
                break@loop
            }
            else -> {
                if(counter < 3) println("Подумай ещё.")
                else println("Правильный ответ: Троллейбус.")
            }
        }
    }


}