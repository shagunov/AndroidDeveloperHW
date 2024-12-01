//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val human = Human()
    human.standUp()

    val array = arrayOf("Иванов", "Петров", "Сидоров", "Процветов", "Протасов")
    val result = mutableListOf<String>()
    while(true){
        println("Введите строку для поиска")
        val searchString = readln()
        if(searchString == "exit") break
        for(element in array){
            var elementOutStr = ""
            var isMatched = false
            var curSearchStringCharIndex = 0
            var matchString = ""
            var nonMatchString = ""
            var isFound = false
            for(char in element){
                if(curSearchStringCharIndex == searchString.length - 1){
                    curSearchStringCharIndex = 0
                } else if(isMatched){
                    curSearchStringCharIndex++
                }

                if(char == searchString[curSearchStringCharIndex] && !isMatched){
                    matchString += "["
                    isMatched = true
                }
                if(char != searchString[curSearchStringCharIndex] && isMatched) {
                    isMatched = false
                    matchString += "]"

                    if(curSearchStringCharIndex != 0){
                        elementOutStr += nonMatchString
                    }
                    else {
                        elementOutStr += matchString
                        isFound = true
                    }

                    matchString = ""
                    nonMatchString = ""
                    curSearchStringCharIndex = 0
                }

                if(!isMatched) elementOutStr += char
                else {
                    nonMatchString += char
                    matchString += char
                }
            }
            if(isMatched) elementOutStr += "$matchString]"
            if(isFound) result.add(elementOutStr)
        }
        println(result.toString())
        result.clear()
    }

    val array1 = arrayOf(5, 6, 9, 0, 3, 5, 6, 0, 2, 4, 5, 6)
    var betweenZero = false
    var elementsBetweenZero = 0
    for(element in array1){
        if(betweenZero && element == 0) betweenZero = false
        else if(!betweenZero && element == 0) betweenZero = true
        else if (betweenZero) elementsBetweenZero++
    }
    println("В массиве ${array1.contentToString()} $elementsBetweenZero элементов между нулями")
}