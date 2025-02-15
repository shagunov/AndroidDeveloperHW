//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val congratulation = fun (name: String, year: Int){
        println("Поздравляем, $name, с новым $year-ым годом\n")
    }

    congratulation("Ваня", 2025)

    val isEven = fun (number: Int) = number % 2 == 0
    val array = Array((5..10).random()){(0..100).random()}
    checkArrayElement(array, isEven)

    val concat = fun (string1: String, string2: String) = string1 + string2
    val string1 = "Hello"
    val string2 = "World"
    println("\"$string1\" + \"$string2\" = \"${concat(string1, string2)}\"")

}

fun checkArrayElement(array: Array<Int>, predicate: (Int) -> Boolean) {
    for(element in array){
        if(predicate(element)) println("Элемент $element - чётное число")
        else println("Элемент $element - нечётное число")
    }
}