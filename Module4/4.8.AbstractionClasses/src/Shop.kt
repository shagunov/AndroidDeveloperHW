abstract class Shop(city : String, name : String) {
    val city = city
        get() = field

    val name = name

    abstract fun callDirector()
    abstract fun makeLogoForShop()

    fun buyPlace(){
        println("Place for building has been bought")
    }
}

class Pyaterochka(city: String) : Shop(city, "Pyaterochka") {
    override fun callDirector() {
        println("called director of pyaterochka")
    }

    override fun makeLogoForShop() {
        println("Making logo for shop $name: five digit")
    }
}

class Magnit(city: String) : Shop(city, "Magnit") {
    override fun callDirector() {
        println("called director of magnit")
    }

    override fun makeLogoForShop() {
        println("Making logo for shop $name: m-letter")
    }
}