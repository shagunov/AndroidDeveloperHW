//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val bird = Bird("Eagle", "Masya", 32, true)
    bird.makeSound()
    bird.fly()
    println()

    val eagle: Bird = Eagle("Petr")
    eagle.fly()
    eagle.makeSound()
    println()

    val penguin: Bird = Penguin("Roma")
    penguin.fly()
    penguin.makeSound()
    println()

    val arrayString = arrayOf("Moscow", "Riga", "Brazil", "Kiev", "Washington")
    var longestString = ""
    for(element in arrayString){
        if(element.length > longestString.length) longestString = element
    }
    println("В массиве строк ${arrayString.contentToString()} самое длинное $longestString. Его длина равна ${longestString.length}\n")

    val string = "ПриВет, кАк деЛа"
    var upperCaseCount = 0
    var out = "["
    for(char in string){
        if (char.isUpperCase()) {
            out += "$char, "
            upperCaseCount++
        }
    }
    out += "\b\b]"
    println("В строке $string $upperCaseCount символов в верхнем регистре: $out")
}