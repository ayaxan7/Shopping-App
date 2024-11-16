package eu.testing.compui
fun main(){
    val obj=Demo("Irfan",21)
    println(obj.hashCode())
    val obj1=obj.copy()
    println(obj1.hashCode())
    obj1.name="Uddin"
    val obj2=obj.copy(name = "Uddin")
    println(obj2.hashCode())
}
data class Demo(var name:String, val age:Int) {
}