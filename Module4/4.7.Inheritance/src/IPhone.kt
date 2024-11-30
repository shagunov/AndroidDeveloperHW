open class IPhone(private val modelName : String, private val phoneNumber: String) {
    fun callPhone(phoneNumber : String){
        println("Calling on phone number $phoneNumber")
    }
    fun callPhone(phone : IPhone){
        println("Calling on phone ${phone.modelName}: ${phone.phoneNumber}")
    }
}

open class Smartphone(modelName: String, phoneNumber: String) : IPhone(modelName, phoneNumber){

}

class Nokia(phoneNumber: String) : Smartphone("Nokia", phoneNumber){

}

class Sony(phoneNumber: String) : Smartphone("Sony", phoneNumber){

}