class Human {
    private val leg = Leg()
    private val head = Head()
    private val arm = Arm()
    private val body = Body()

    fun standUp(){
        println("Человек встаёт")
        head.rotate()
        arm.omit()
        body.banding()
        leg.raise()
        println("Человек стоит.")
    }

    inner class Leg{
        fun raise(){
            println("\tНога поднимается.")
        }
    }
    inner class Head{
        fun rotate(){
            println("\tГолова поворачивается.")
        }

    }
    inner class Arm{
        fun omit(){
            println("\tРука опущена вниз.")
        }
    }
    inner class Body{
        fun banding(){
            println("\tТуловище наклоняется вперёд.")
        }
    }
}