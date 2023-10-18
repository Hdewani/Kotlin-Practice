class Contact(val id: Int, var email: String = "example@gmail.com") {
    val category: String = "work"
}

fun main(){
    val details=Contact(1,"example@gmail.com",)
    println(details.email)

}
