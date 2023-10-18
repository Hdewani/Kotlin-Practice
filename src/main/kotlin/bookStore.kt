data class Book(val name: String, val author: String, val year: Int, val price: Double, val stock: Int)

class BookStore {
    private val books = mutableListOf<Book>()

    fun run() {
        var choice = 0
        while (choice != 5) {
            printMenu()
            choice = readln().toInt()
            when (choice) {
                1 -> addBook()
                2 -> deleteBookPrompt()
                3 -> listBooks()
                4 -> printTotalBooks()
                5 -> println("Exiting...")
                else -> println("Invalid choice")
            }
            println()
        }
    }

    private fun printMenu() {
        println("1. Add book")
        println("2. Delete book")
        println("3. List books")
        println("4. Total books")
        println("5. Exit")
        print("Enter choice: ")
    }

    private fun addBook() {
        val name = readNonEmptyInput("Enter book name")
        val author = readNonEmptyInput("Enter author name")
        val year = readInput("Enter year").toInt()
        val price = readInput("Enter price").toDouble()
        val stock = readInput("Enter stock").toInt()
        books.add(Book(name, author, year, price, stock))
    }

    private fun deleteBookPrompt() {
        val name = readInput("Enter book name to delete")
        deleteBook(name)
    }

    private fun readNonEmptyInput(prompt: String): String {
        var input: String
        do {
            input = readInput(prompt)
            if (input.isEmpty()) {
                println("Input cannot be empty. Please try again.")
            }
        } while (input.isEmpty())
        return input
    }

    private fun deleteBook(name: String) {
        val removed = books.removeIf { it.name == name }
        if (removed) {
            println("Book '$name' has been deleted.")
        } else {
            println("No book found with the name '$name'.")
        }
    }

    private fun listBooks() {
        println("\nBooks:")
        books.forEach {
            println("-\tname: ${it.name}, author: ${it.author}, year: ${it.year}, price: ${it.price}, stock: ${it.stock}")
        }
    }

    private fun printTotalBooks() {
        if (books.isEmpty()) {
            println("No books in the store.")
        } else {
            println("Total books:")
            books.forEach { book ->
                println("Name: ${book.name}, Stock: ${book.stock}")
            }
        }
    }

    private fun readInput(prompt: String): String {
        print("$prompt: ")
        return readln()
    }
}

fun main() {
    val bookStore = BookStore()
    bookStore.run()
}