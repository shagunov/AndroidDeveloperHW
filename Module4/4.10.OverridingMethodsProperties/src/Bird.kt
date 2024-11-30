open class Bird(val type: String, val name: String, weight: Int, private val canFly: Boolean) {

    open fun fly(){
        when(canFly){
            true -> println("Птица летит")
            false -> println("Птица не может летать")
        }
    }

    open fun makeSound(){
        println("Птица издаёт звук")
    }
}

class Penguin(name: String): Bird("Penguin", name, 20, false){

    override fun fly() {
        println("Пингвины не летают!!!")
    }

    override fun makeSound() {
        println("Пингвин пищит")
    }
}

class Eagle(name: String): Bird("Eagle", name, 5, true){

    override fun fly(){
        println("Орёл летит высоко в небе.")
    }

    override fun makeSound() {
        println("Орёл издаёт крик")
    }
}