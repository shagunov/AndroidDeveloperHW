open class Animal(weight: Int, name: String) {
    var name = name
        private set

    var weight = weight
        private set

    fun eat(){
        println("$name is eating")
    }
}

class Dog(weight: Int, name: String): Animal(weight, name) {
    fun makeDogSound(){
        println("Dog $name is making sound gaw")
    }
}

class Cat(weight: Int, name: String): Animal(weight, name) {
    fun makeCatSound(){
        println("Cat $name is making sound meow")
    }
}