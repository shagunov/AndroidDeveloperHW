import kotlin.math.abs
import kotlin.math.sqrt

const val pi = 3.14

fun main() {
    val a = 23;
    val b = 32;

    println("Среднее арифметическое от a = $a и b = $b равно ${(a + b) / 2}\n")

    val S = 123.423

    val D = sqrt(S / pi) * 2
    val L = D * pi

    println("Круг площадью $S квадратных единиц имеет диаметр $D единиц и длину окружности $L единиц\n")

    val x1 = 2.0
    val y1 = 5.0
    val x2 = 44.0
    val y2 = 32.0

    println("Прямоугольник с координатами противоположных вершин: {$x1; $y1}, {$x2; $y2} имеет площадь ${abs(x2 - x1) * abs(y2 - y1)} и периметр ${(abs(x2 - x1) + abs(y2 - y1)) * 2}\n")

    var number = 1
    for(counter in 0..9){
        println(number)
        number *= 2
    }

    println()

    for(counter in 20 downTo 0 step 2){
        println(counter)
    }

}