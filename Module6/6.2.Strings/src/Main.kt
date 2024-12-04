//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val stroke = "Занятие"
    for(element in stroke){
        print("\'${element}\' ")
    }
    println()

    val rightPhoneNumber = "+71234567890"
    val wrongPhoneNumber = "13523414"

    println("Телефон $rightPhoneNumber ${when(checkPhoneNumber(rightPhoneNumber)){true -> "Верный"; false -> "Неверный."}}")
    println("Телефон $wrongPhoneNumber ${when(checkPhoneNumber(wrongPhoneNumber)){true -> "Верный"; false -> "Неверный."}}")

    val stroke1 = "Moscow"
    val reverseStroke1 = stroke1.reversed()
    println("$stroke1 - $reverseStroke1")

    val string = "kotlin2023course"
    println("В строке $string ${string.filter { char -> char.isDigit()}.length} цифр(ы).")
}

fun checkPhoneNumber(phoneNumber: String): Boolean {
    return phoneNumber.substring((0..1)) == "+7" && phoneNumber.length - 2 == 10 && phoneNumber.length == phoneNumber.filter { char -> char.isDigit() }.length
}