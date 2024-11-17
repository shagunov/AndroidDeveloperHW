class HomeAnimal {
    var weight = 0
    var name = ""
    var type = ""

    override fun toString(): String {
        return "Домашнее животное.\n" +
                "Кличка - $name\n" +
                "Вид животного - $type\n" +
                "Вес животного равен $weight кг."
    }


}