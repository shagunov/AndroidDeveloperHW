fun main() {
    val naturalNumber = 5;

    if(naturalNumber <= 0){
        println("Факториал можно вычислить только у положительного числа!")
    } else{
        var counter = 1
        var result = 1
        while(counter++ < naturalNumber){
            result *= counter
        }
        println("Факториал числа $naturalNumber = $result\n")
    }

    val costOfCandy = 423.0

    var counter = 0
    while (counter++ < 10){
        println("Стоимость $counter кг. конфет составляет ${costOfCandy * counter} рублей")
    }

    val A = 3
    val B = 12

    var quantityOfNumbers = 0

    counter = A
    println(" ")
    do {
        println("Между числами $A и $B лежит число $counter")
        quantityOfNumbers++
    } while (counter++ <= B)
    println("Всего между числами $A и $B лежит $quantityOfNumbers чисел\n")

    val number = 12314
    var digit = number
    do{
        println(digit % 10)
        digit /= 10
    }while (digit > 0)

    counter = 1
    println(" ")
    do{
        if(counter % 4 == 0){
            println("Число $counter нацело делится на 4, выводим, умножая на два: ${counter * 2}")
        } else if (counter % 2 == 0){
            println("Число $counter чётное, выводим без изменений: $counter")
        }
    } while (counter++ < 20)

    val deposit = 350.0
    var months = 9
    var percent = 7
    counter = 1

    var result = deposit
    do{
        result += result * percent / 100
    } while (counter++ < months)

    println("\nЧерез $months месяцев вклад с первоначальным депозитом в $deposit долларов с процентной ставкой $percent процентов вырастет до $result долларов.")

}