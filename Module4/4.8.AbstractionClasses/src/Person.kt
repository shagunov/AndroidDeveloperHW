abstract class Person(val name : String, val lastName: String, age : Int) {
    var age = age
        get() = field
        private set

    fun birthDay(){
        age++
        println("У человека день рождения. Теперь ему $age")
    }

    abstract fun action()
    abstract fun firing()
}

class Student(name: String, lastName: String, age: Int) : Person(name, lastName, age) {

    override fun action() {
        println("Студент $name $lastName сидит на паре")
    }

    override fun firing() {
        println("Студент $name $lastName отчислен")
    }

}

class Employee(name: String, lastName: String, age: Int) : Person(name, lastName, age) {
    override fun action() {
        println("Сотрудник $name $lastName работает")
    }

    override fun firing() {
        println("Сотрудник $name $lastName уволен")
    }
}