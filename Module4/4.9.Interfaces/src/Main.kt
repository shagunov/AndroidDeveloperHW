//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val police: EmergencyResponseService = Police()
    val fighters: EmergencyResponseService = FireFighters()
    val shortDescription: IGetDescription = ShortDescription()

    shortDescription.getDescription(police)
    shortDescription.getDescription(fighters)
    println()
    police.emergencyCall()
    fighters.emergencyCall()
    println()

    var firstMax = 0
    var secondMax = 0

    val arrayInt = intArrayOf(3, 5, 2, 56, 23, 654, 21, 452)
    for(element in arrayInt){
        when{
            element > firstMax -> {
                secondMax = firstMax
                firstMax = element
            }
            element > secondMax -> {
                secondMax = element
            }
        }
    }
    println("В массиве ${arrayInt.contentToString()} второе наибольшее число равно $secondMax")

    val first = (1..100).random()
    val second = (1..300).random()
    println("У чисел $first и $second НОД равен ${nodEuclid(first, second)}")
}

fun nodEuclid(number: Int, otherNumber: Int) : Int{
    var one = number
    var two = otherNumber

    while (one != 0 && two != 0) {
        when{
            one > two -> one %= two
            two > one -> two %= one
        }
    }

    return when{
        one != 0 -> one
        two != 0 -> two
        else -> 1
    }
}