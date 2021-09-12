import java.math.BigDecimal

interface BookingManager {

    val version : String

    fun isSeatFree(seat : Seat) : Boolean
    fun reserveSeat(seat : Seat, customerId: Long) : Boolean

    fun systemStatus() = "All operations are functional"
}

//Custom exception
class UnauthorizedUserException : Throwable()

//Implementing an interface
//It needs to be open so it can be extended because all classes in Kotlin are final by default
open class BasicBookingManager(authKey: String) : BookingManager {

    override val version = "1.0"

    override fun isSeatFree(seat : Seat) = true
    override fun reserveSeat(seat : Seat, customerId: Long) = false

    init {
        if (authKey != "12345") throw UnauthorizedUserException()
    }
}

//Extending a class - Class inheritance
//Like Java, in Kotlin you can only extend from a single class
//But you can implement multiple interfaces
class AdvancedBookingManager : BasicBookingManager("12345"), java.io.Closeable {
    override val version = "1.0"

    fun howManyBookings() = 10

    override fun close() { }
}

//Adding functions to existing classes (extension functions) - Works even in final classes
fun String.toSentenceCase() : String {
    return this[0].uppercase() + this.substring(1)
}

fun main(args: Array<String>) {
    val isSeatFree = AdvancedBookingManager().isSeatFree(Seat(1, 1, BigDecimal.ZERO, ""))
    println(isSeatFree)

    val greeting = "welcome to the system"
    println(greeting.toSentenceCase())
}