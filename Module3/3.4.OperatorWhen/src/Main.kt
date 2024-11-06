fun main() {
    val month = 11
    when(month){
        1 -> println("Зима: Январь")
        2 -> println("Весна: Февраль")
        3 -> println("Весна: Март")
        4 -> println("Весна: Апрель")
        5 -> println("Весна: Май")
        6 -> println("Лето: Июнь")
        7 -> println("Лето: Июль")
        8 -> println("Лето: Август")
        9 -> println("Осень: Сентябрь")
        10 -> println("Осень: Октябрь")
        11 -> println("Осень: Ноябрь")
        12 -> println("Зима: Декабрь")
        else -> println("Неверное число месяца")
    }

    val c = 34.4f
    val cApproximate : Int
    when {
        (c - c.toInt() < 0.5) -> cApproximate = c.toInt()
        else -> cApproximate = c.toInt() + 1
    }

    println("\nApproximated c = $c: cApproximate = $cApproximate\n")

    val `o'clock` = 15

    when{
        (`o'clock` >= 0 && `o'clock` < 3 || `o'clock` == 23) -> println("Ночь")
        (`o'clock` >= 3 && `o'clock` < 7) -> println("Раннее утро")
        (`o'clock` >= 7 && `o'clock` < 11) -> println("Утро")
        (`o'clock` >= 11 && `o'clock` < 16) -> println("День")
        (`o'clock` >= 16 && `o'clock` < 20) -> println("Вечер")
        (`o'clock` >= 20 && `o'clock` < 23) -> println("Поздний вечер")
        else -> println("Неправильно введён номер часа. Невозможно определить время суток")
    }

    var a = 8
    var b = 5
    println("\nИсходные числа: a = $a, b = $b")

    a = a + b // Числу a присваиваем сумму двух чисел
    b = a - b // Теперь если в b записать разность a - b, то в b будет лежать a
    a = a - b // Поскольку в b лежит уже a, то эта разность даст число b
    println("Полученные числа: a = $a, b = $b")

}