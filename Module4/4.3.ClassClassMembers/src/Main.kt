//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val alligator = Helicopter()
    alligator.takeOfWeight = 2000
    alligator.maxHeightFly = 3000
    alligator.flySpeed = 200
    alligator.name = "alligator"
    println("$alligator\n")

    val duck = HomeAnimal()
    duck.weight = 4
    duck.type = "Утка"
    duck.name = "Аврелия"
    println(duck)

    val floatingPoint = 5.87
    val intNumber = floatingPoint.toInt()
    println("\nЧисло с плавающей точкой $floatingPoint приведено к целому числу $intNumber")

}