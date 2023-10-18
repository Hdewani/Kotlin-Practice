fun main() {
    val shapes:MutableList<String> = mutableListOf("triangle", "square", "circle")
    println("the list has ${shapes.count()} items")
    println(shapes)
    shapes.add("pentagon")
    shapes.add("pentagon")
    shapes.remove("square")
    println(shapes)

    val setOfFruits:MutableSet<String> = mutableSetOf("apple", "banana", "cherry", "cherry")
    setOfFruits.add("mango")
    println(setOfFruits)

    val mapOfJuice:MutableMap<String,Int> = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    mapOfJuice["mango"] = 120
    mapOfJuice["banana"] = 20
//    mapOfJuice.put("mango" , 120)
    mapOfJuice.remove("apple")
    println(mapOfJuice)
}
