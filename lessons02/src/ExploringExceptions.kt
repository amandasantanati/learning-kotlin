import java.io.FileInputStream

// Just compatibility with Java
// Doesn't mean much in Kotlin
@Throws(InterruptedException::class)
fun divide(a: Int, b: Int) : Double {
    Thread.sleep(1000)
    return (a.toDouble() / b)
}

fun printFile() {
    val input = FileInputStream("file.txt")

    input.use {
        // an exception could be thrown here
    }
}

fun main(args: Array<String>) {
    // All exceptions in Kotlin are unchecked
    try {
        println(7/0)
    } catch (e: ArithmeticException) {
        println("caught")
    }

    //In Java it would alert of an exception
    //But not in Kotlin because all exception are
    Thread.sleep(1000)

    val result = try {
        divide(5, 23)
    } catch (e: Exception) {
        println(e)
        0
    }

    println(result)
}