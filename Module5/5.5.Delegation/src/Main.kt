//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val srcDecimal = "2341"
    val srcBinary = "1011011011010"
    val dstDecimal = toDecimal(srcBinary)
    val dstBinary = toBinary(srcDecimal)

    println("from $srcBinary to $dstDecimal")
    println("from $srcDecimal to $dstBinary")

    println("Слово \"Шабаш\" - палиндром is ${isPalindrome("Шабаш")}")
    println("Слово \"мама\" - палиндром is ${isPalindrome("мама")}")
}

fun toBinary(fromDecimal: String) : String{
    var value = fromDecimal.toInt()
    var result = ""
    while(value != 0){
        val ostatock = value % 2
        value /= 2
        result += ostatock.toString()
    }
    return result.reversed()
}
fun toDecimal(fromBinary: String) : String{
    var result = 0
    for(charIndex in fromBinary.indices){
        if(fromBinary[fromBinary.length - 1 - charIndex] == '1'){
            result += power2(charIndex)
        }
    }
    return result.toString()
}

fun power2(num: Int): Int{
    var result = 1
    if(num == 0) return 1
    for(cur in 1..num){
        result *= 2
    }
    return result
}

fun isPalindrome(string: String): Boolean{
    val isDifferent = false
    for(charIndex in string.indices){
        if(!string[charIndex].equals(string[string.length - 1 - charIndex], true)) return false
    }
    return true
}