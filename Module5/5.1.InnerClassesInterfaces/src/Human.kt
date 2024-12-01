class Human {
    val leg = Leg()
    val head = Head()
    val arm = Arm()
    val body = Body()

    fun standUp(){
        println("Человек встаёт")
        head.rotate()
        arm.omit()
        body.banding()
        leg.raise()
        println("Человек стоит.")
    }

    class Leg{
        fun raise(){
            println("\tНога поднимается.")
        }
    }
    class Head{
        fun rotate(){
            println("\tГолова поворачивается.")
        }

    }
    class Arm{
        fun omit(){
            println("\tРука опущена вниз.")
        }
    }
    class Body{
        fun banding(){
            println("\tТуловище наклоняется вперёд.")
        }
    }
}