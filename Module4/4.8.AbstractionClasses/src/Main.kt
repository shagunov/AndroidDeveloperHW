//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val pyaterochka : Shop = Pyaterochka("Moscow")
    pyaterochka.makeLogoForShop()
    pyaterochka.callDirector()
    println()
    val magnit : Shop = Magnit("Saint-Petersburg")
    magnit.makeLogoForShop()
    magnit.callDirector()
    println()

    val student : Person = Student("Иван", "Иванов", 18)
    student.birthDay()
    student.action()
    student.firing()
    println()

    val employee : Person = Employee("Василий", "Васильев", 30)
    employee.birthDay()
    employee.action()
    employee.firing()
    println()

    val lengthMeters = 34.31
    val lengthUnitNumber = (1..5).random()

    when(lengthUnitNumber){
        1 -> println("Длина отрезка: ${lengthMeters * 10} дециметров")
        2 -> println("Длина отрезка: ${lengthMeters / 1000} километров")
        3 -> println("Длина отрезка: $lengthMeters метров")
        4 -> println("Длина отрезка: ${lengthMeters * 1000} милиметров")
        5 -> println("Длина отрезка: ${lengthMeters * 100} сантиметров")
        else -> println("Неверный номер для единицы длины")
    }
}