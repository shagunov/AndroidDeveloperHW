class BankCard (private var passwordCard : String, cardNumber : String, cardCode : String){
    var cardNumber = cardNumber
        get() = field
        private set(value){
            when{
                value.length != 12 -> println("Номер карты должен иметь длину 12 чисел")
                else -> field = value
            }
        }
    private var cardCode = cardCode
        get() = field
        private set(value) {
            field = value
        }

    fun getDataCard(password: String) {
        if (password != passwordCard) {
            println("Неверный пароль карты")
            return
        }
        println(
            "Номер карты: $cardNumber\n" +
                    "Код карты: $cardCode"
        )
    }

}