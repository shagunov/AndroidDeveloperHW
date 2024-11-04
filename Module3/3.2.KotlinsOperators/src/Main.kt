
const val pi = 3.14

fun main(){
    // TODO Квадрат
    val a = 5

    val S = a * a
    val P = 4 * a

    // TODO Прямоугольник
    val a1 = 6
    val b1 = 2

    val S1 = 6 * 2
    val P1 = 2 * (a1 + b1)

    // TODO Окружность
    val d = 67

    val L = d * pi

    // TODO Сантиметры в метры
    val L1 = 345

    val L1Metres = L1 / 100

    // TODO Отрезки
    val A = 1000
    val B = 43

    val BinA = A / B

    println("S = $S | P = $P | S1 = $S1 | P1 = $P1 | L = $L | Lm = $L1Metres | A = $BinA")
}