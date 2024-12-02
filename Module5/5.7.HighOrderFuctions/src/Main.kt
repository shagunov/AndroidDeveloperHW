//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    action("Red", "Blue", fun (color1: String, color2: String): String{
        return when{
            (color1 == "Red" && color2 == "Blue") || (color1 == "Blue" && color2 == "Red") -> "Magenta"
            else -> "Green"
        }
    })

    val array = Array((5..10).random()){(1..50).random()}

    println("Исходный массив: ${array.contentToString()}")
    println("Массив с инкрементированными числами: ${map(array, ::increment).contentToString()}")
    println("Массив с удвоенными числами: ${map(array, ::mulOn2).contentToString()}")
}

fun action(color1: String, color2: String, colorBlender: (String, String) -> String): String{
    return colorBlender(color1, color2)
}

fun mulOn2(num: Int) = num * 2
fun increment(num: Int) = num + 1

fun map(nums: Array<Int>, function: (Int) -> Int): Array<Int>{
    val result = Array<Int>(nums.size){0}
    for(elementIdx in result.indices) result[elementIdx] = function(nums[elementIdx])
    return result
}