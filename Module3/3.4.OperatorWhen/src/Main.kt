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

    val oclock = 15

    when{
        (oclock >= 0 && oclock < 3 || oclock == 23) -> println("Ночь")
        (oclock >= 3 && oclock < 7) -> println("Раннее утро")
        (oclock >= 7 && oclock < 11) -> println("Утро")
        (oclock >= 11 && oclock < 16) -> println("День")
        (oclock >= 16 && oclock < 20) -> println("Вечер")
        (oclock >= 20 && oclock < 23) -> println("Поздний вечер")
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