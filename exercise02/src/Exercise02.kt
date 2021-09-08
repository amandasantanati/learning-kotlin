import java.math.BigDecimal

fun main(args: Array<String>) {
    val cheapSeats = Theater().seats.filter { it.price == BigDecimal(14.50) }

    for(seat in cheapSeats) println(seat)
}