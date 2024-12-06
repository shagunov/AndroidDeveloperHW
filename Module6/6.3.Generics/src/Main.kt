data class Person<T>(val age: Int, val name: String, val phoneNumber: T)

fun main() {
    println("Вызовы print.")
    print(3)
    print(3.5)
    print("void")
    print(3 == 2)
    println()

    val numberPerson = Person(30, "Ivan", "+79891233242")
    val strokePerson = Person(30, "Vladimir", 8912345678)

    println("Телефон-число: $numberPerson")
    println("Телефон-строка: $strokePerson\n")

    formatPrint(3, '\'')
    formatPrint("Hello", '{', '}')


}

fun <T> print(printable: T) = println("\t$printable")

fun <T> formatPrint(printable: T, beginEndChar: Char) = println("${beginEndChar}${printable}${beginEndChar}")
fun <T> formatPrint(printable: T, beginChar: Char, endChar: Char) = println("${beginChar}${printable}${endChar}")