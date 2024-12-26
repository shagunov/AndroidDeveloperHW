//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
data class Employee(val name: String, val age: Int, val salary: Double)

fun main() {
    // Создание списка сотрудников
    val employees = listOf(
        Employee("Иван", 30, 50000.0),
        Employee("Мария", 25, 60000.0),
        Employee("Петр", 35, 75000.0),
        Employee("Анна", 28, 55000.0),
        Employee("Сергей", 32, 65000.0)
    )

    println("Исходный список: ${employees.joinToString()}")
    println("Отсортированный по именам: ${sortEmployeesByName(employees)}")
    println("Отсортированный по возрасту: ${sortEmployeesByAge(employees)}")
    println("Отсортированный по зарплате: ${sortEmployeesBySalary(employees)}")

    val matrix3x4 = Array(3) { Array(4){(-100..100).random()} }
    println("Исходная Матрица")
    printMatrix(matrix3x4)
    for(rowIndex in matrix3x4.indices){
        matrix3x4[rowIndex] = matrix3x4[rowIndex].sortedBy { it }.toTypedArray()
    }
    println("Матрица с отсортированными строками")
    printMatrix(matrix3x4)

    val matrix = arrayOf(
        arrayOf(1, 3, 2, 4),
        arrayOf(5, 2, 6, 1),
        arrayOf(7, 8, 9, 10)
    )

    val sawtoothArrays = findSawtoothArrays(matrix)
    println("Исходная матрица")
    printMatrix(matrix)

    println("Количество пилообразных массивов: ${sawtoothArrays.size}")
    println("Пилообразные массивы:")
    sawtoothArrays.forEach { println(it.contentToString()) }

}

// Функция для сортировки списка сотрудников по имени
fun sortEmployeesByName(employees: List<Employee>): List<Employee> {
    return employees.sortedBy { it.name }
}

// Функция для сортировки списка сотрудников по возрасту
fun sortEmployeesByAge(employees: List<Employee>): List<Employee> {
    return employees.sortedBy { it.age }
}

// Функция для сортировки списка сотрудников по зарплате
fun sortEmployeesBySalary(employees: List<Employee>): List<Employee> {
    return employees.sortedBy { it.salary }
}

fun printMatrix(matrix: Array<Array<Int>>){
    for(row in matrix){
        for(element in row) {
            if(element < 0) print("\b")
            print("$element\t ")
        }
        println()
    }
}

fun findSawtoothArrays(matrix: Array<Array<Int>>): List<Array<Int>> {
    val sawtoothArrays = mutableListOf<Array<Int>>()

    for (row in matrix) {
        if (isSawtooth(row)) {
            sawtoothArrays.add(row)
        }
    }

    return sawtoothArrays
}

fun isSawtooth(arr: Array<Int>): Boolean {
    if (arr.size < 3) return true // Массивы с менее чем 3 элементами считаем пилообразными

    for (i in 1 until arr.size - 1) {
        val prev = arr[i - 1]
        val curr = arr[i]
        val next = arr[i + 1]

        // Проверка пилообразности: либо предыдущий и следующий больше текущего, либо меньше
        if (!((curr > prev && curr > next) || (curr < prev && curr < next))) {
            return false
        }
    }
    return true
}
