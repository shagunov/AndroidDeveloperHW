class Car(private val weight : Int, private var speed : Int = 0) {
    fun stop(){
        speed = 0
        println("Автомобиль остановился.")
    }

    fun move(speed: Int){
        this.speed = speed
        println("Автомобиль начал движение. Теперь его скорость - ${this.speed} км/ч")
    }
}