class Registration {
    private var email = "user@mail.com"
    private var password = "000000"

    fun setPassword(newPassword : String){
        if(newPassword.length < 6){
            println("Пароль слишком короткий! Длина пароля должна составлять не менее 6 символов.")
            return
        }
        password = newPassword
        println("Пароль успешно изменён.")
    }

    fun getEmail() = email.uppercase()
}