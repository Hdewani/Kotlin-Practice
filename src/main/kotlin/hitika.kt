fun main(){
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)
    // Write your code here
    val sum= greenNumbers + redNumbers
    println(sum.count())

    val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
    val requested = "ftp"
    val isSupported = requested.uppercase() in SUPPORTED
    println("Support for $requested: $isSupported")

    val number2word:MutableMap<Int,String> = mutableMapOf(1 to "M", 2 to "A" , 3 to "P")
    val n = 2
    println("$n is spelt as '${number2word[n]}'")
}