//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val words = arrayOf("hello", "world", "kotlin", "programming", "is", "fun")
    println("Исходный массив слов: ${words.contentToString()}")
    var longestWord = ""
    for(word in words){
        if(longestWord.length < word.length) longestWord = word
    }
    println("Самое длинное слово - $longestWord длинной в ${longestWord.length} символов")

    val array2x2 = Array(4){Array(4){(0..10).random()} }
    println("Массив")
    println("_________________")
    for(row in array2x2){
        print('|')
        for(element in row){
            print("$element\t|")
        }
        println()
        println("_________________")
    }

    var sum = 0
    for(a in 0..3){
        sum += array2x2[3 - a][a]
    }
    println("\nСумма чисел на побочной диагонали равна $sum")

    val printerOneString = object: Printer("|"){
        override fun print_(vararg words: String){
            for(str in words){
                print("${separator}$str")
            }
            println()
        }
    }
    val printerMultiString = object: Printer(""){
        override fun print_(vararg words: String){
            println()
            for(str in words){
                println(str)
            }
            println()
        }
    }

    printerOneString.print_("Moscow", "Seat", "Put")
    printerMultiString.print_("Moscow", "Seat", "Put")
}

abstract class Printer(val separator: String){
    abstract fun print_(vararg words: String)
}