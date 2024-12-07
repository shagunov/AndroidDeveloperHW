const val MAX_CATALOGUE_SIZE = 10

class UserCatalog(){
    inner class UserCatalogException(what: String) : Exception(what)
    private var users: Array<String> = Array(MAX_CATALOGUE_SIZE){""}

    fun greeting(){
        for(elementIdx in users.indices){
            if(users[elementIdx] != ""){
                println("Hello, ${users[elementIdx]}")
            }
        }
    }

    fun createList(list: Array<String>){
        for(elementIdx in list.indices){
            if(list.size > MAX_CATALOGUE_SIZE) throw UserCatalogException("Размер переданного массива равен ${list.size}, что превышает размер в $MAX_CATALOGUE_SIZE элементов")
            println("В каком месте вставить пользователя ${list[elementIdx]}?")
            val idx = readln().toInt()
            if(idx >= MAX_CATALOGUE_SIZE || idx < 0) throw UserCatalogException("Места $idx в каталоге не существует")
            if(list[elementIdx].isEmpty()) throw UserCatalogException("Имя $elementIdx является пустой строкой")
            users[idx] = list[elementIdx]
        }
    }

    fun resetList(){
        users = Array(MAX_CATALOGUE_SIZE){""}
    }
}



fun main() {
    val users = arrayOf("Иван", "Павел", "Матвей")
    val userCatalog = UserCatalog()

    try{
        userCatalog.createList(users)
    }
    catch (ex: UserCatalog.UserCatalogException){
        println("Возникло исключение в программе")
        println("\t$ex")
    }
    catch(ex: NumberFormatException){
        println("Возникло исключение в программе")
        println("\tОшибка при вводе с консоли")
        println("\t$ex")
    }
    catch (ex: Exception){
        println("Необработанное исключение")
        println("\t$ex")
        println(ex.stackTrace.contentToString())
    }
    finally {
        println("Исключение успешно обработано")
    }

    userCatalog.greeting()
}