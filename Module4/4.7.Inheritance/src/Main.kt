//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val nokia = Nokia("89321231212")
    val sony = Sony("81231231233")

    nokia.callPhone(sony)
    println()

    val dog = Dog(32, "Zhutchka")
    val cat = Cat(5, "Missa")
    dog.eat()
    dog.makeDogSound()
    println()

    cat.eat()
    cat.makeCatSound()
    println()

    var arrayString = "["
    val array = arrayOf(3, 67, 1, 55, 65, 89, 23)
    for(element in array){
        if(element % 5 == 0)
            arrayString += "$element, "
    }
    arrayString += "\b\b]"
    println("Исходный массив: ${array.contentToString()}\n" +
            "Числа, которые делятся на 5: $arrayString")
}