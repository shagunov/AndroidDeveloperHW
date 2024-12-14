class City(val name: String){
    var population = 0
    override fun toString(): String {
        return "City: $name\n" +
                "Its population is equal $population people"
    }

}

fun main() {
    var string: String? = "Moscow"
    string?.let{ println("$it. ${it.length} symbols") }
    println()

    val city = City("Moscow").apply { population = 14123124 }
    println(city)
    println()

    val array = Array(20){(0..1000).random()}
    with(array){
        println("Array: ${contentToString()}\n" +
                "His size is $size elements\n" +
                "Sum of his elements ${sum()}")
    }
}