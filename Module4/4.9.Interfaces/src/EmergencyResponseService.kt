abstract class EmergencyResponseService(val name: String, val phone: String) {
    abstract fun emergencyCall()
}

class Police: EmergencyResponseService("Police", "02"){
    override fun emergencyCall() {
        println("Полиция выезжает на срочный вызов")
    }
}

class FireFighters: EmergencyResponseService("FireFighters", "01"){
    override fun emergencyCall() {
        println("Пожарные выезжают на срочный вызов")
    }
}

interface IGetDescription{
    fun getDescription(emergencyResponseService: EmergencyResponseService)
}

class ShortDescription: IGetDescription{
    override fun getDescription(emergencyResponseService: EmergencyResponseService) {
        println("Service: ${emergencyResponseService.name}, phone number: ${emergencyResponseService.phone}")
    }
}