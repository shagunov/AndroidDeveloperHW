//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val box = Box(32, 43, 53)
    println("Объём коробки равен ${box.volume()}\n")

    val n = 15
    val array = Array(n){0}
    for(index in array.indices){
        array[index] = (-300..300).random()
    }

    var minArrayElement = array[0]
    var maxArrayElement = array[0]
    for(element in array){
        if(minArrayElement > element) minArrayElement = element
        if(maxArrayElement < element) maxArrayElement = element
    }
    println("В массиве ${array.contentToString()}\n" +
            "Наименьший элемент равен $minArrayElement\n" +
            "Наибольший элемент равен $maxArrayElement\n")


    println("Массив: ${arrayOf(3, 67, 1, 55, 65, 89, 23).contentToString()}")

    val number = (Int.MIN_VALUE..Int.MAX_VALUE).random()
    var numberInfo = "Число $number "
    if(number == 0) numberInfo += "нулевое число"
    else{
        numberInfo += if(number < 0) "отрицательное "
        else "положительное "
        numberInfo += if(number % 2 == 0) "чётное "
        else "нечётное "
        numberInfo += "число.\n"
    }
    println(numberInfo)

    var car = Car(32, 43)
    car.stop()
    car.move(53)
}