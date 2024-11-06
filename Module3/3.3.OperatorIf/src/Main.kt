fun main(){
    var a = 3
    println("Положительное число: $a")
    if(a > 0) a++;
    println("Положительное число изменено: $a\n")
    var b = -1
    println("Отрицательное число: $b")
    if(b > 0) b++;
    println("Отрицательное число не изменено: $b\n")

    var _1 = 4
    var _2 = 45
    var _3 = -2
    var _4 = 8
    println("Целые числа: $_1, $_2, $_3, $_4")
    var positiveNumberCount = 0
    if(_1 > 0) ++positiveNumberCount
    if(_2 > 0) ++positiveNumberCount
    if(_3 > 0) ++positiveNumberCount
    if(_4 > 0) ++positiveNumberCount
    println("Среди них $positiveNumberCount положительных числа\n")

    val x = 39
    val y = 54
    if(x < y) println("Среди чисел x = $x и y = $y $y наибольшее\n")
    if(y < x) println("Среди чисел x = $x и y = $y $x наибольшее\n")

    val dayOfWeek = 3
    if(dayOfWeek == 1) println("Сегодня понедельник\n")
    else if(dayOfWeek == 2) println("Сегодня вторник\n")
    else if(dayOfWeek == 3) println("Сегодня среда\n")
    else if(dayOfWeek == 4) println("Сегодня четверг\n")
    else if(dayOfWeek == 5) println("Сегодня пятница\n")
    else if(dayOfWeek == 6) println("Сегодня суббота\n")
    else if(dayOfWeek == 7) println("Сегодня воскресение\n")
    else println("Невозможно определить день недели!\n")

    var K = 3
    if(K == 1) println("Плохо\n")
    else if(K == 2) println("Неудовлетворительно\n")
    else if(K == 3) println("Удовлетворительно\n")
    else if(K == 4) println("Хорошо\n")
    else if(K == 5) println("Отлично\n")
    else println("Ошибка!\n")

    val num1 = 34.0
    val num2 = 56.4
    val operation = 3
    val operationString : String

    val result : Double
    if(operation == 1){
        operationString = "Сложение"
        result = num1 + num2
    }
    else if(operation == 2){
        operationString = "Вычитание"
        result = num1 - num2
    }
    else if(operation == 3){
        operationString = "Умножение"
        result = num1 * num2
    }
    else if(operation == 4){
        operationString = "Деление"
        result = num1 / num2
    }
    else{
        operationString = "null"
        result = 0.0
    }

    if(operationString != "" && result != 0.0) println("$operationString чисел $num1 и $num2: $result")
    else println("Операция присвоена с ошибкой")

}