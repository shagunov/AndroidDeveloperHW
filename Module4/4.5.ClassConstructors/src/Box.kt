class Box (private var width: Int = 0, private var height: Int = 0, private var depth: Int = 0){

    fun volume() : Int{
        return width * height * depth
    }
}