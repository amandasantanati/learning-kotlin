import java.math.BigDecimal

// SEAT PRICES:
// Seats in rows 14 and 15 cost 14.50
// Seats in rows 1 to 13 and numbered 1 to 3 or 34 to 36 cost 16.50
// All other seats in row 1 cost 21.00
// All other seats cost 18.00

// SEAT DESCRIPTIONS:
// Seats in row 15: "Back row
// Seats in row 14: "Cheap seat"
// All other rows, seats 1 to 3 and 34 to 36: "Restricted View"
// All other seats in rows 1 and 2: "Best view"
// All other seats: "Standard seat"

class Theater {
    val seats = buildSeats()

    private fun buildSeats() : List<Seat> {
        val seats = mutableListOf<Seat>()

        for(row in 1..15) {
            for(num in 1..36) {
                println("$row-$num")

                if((row in 1..13) && (num in 1..3 || num in 34..36)) {
                    seats.add(Seat(row, num, BigDecimal(16.50), "Restricted View"))
                } else if(row in 1..2) {
                    seats.add(Seat(row, num, BigDecimal(21.00), "Best View"))
                } else if(row == 14) {
                    seats.add(Seat(row, num, BigDecimal(14.50), "Cheap View"))
                } else if(row == 15) {
                    seats.add(Seat(row, num, BigDecimal(14.50), "Back Row"))
                } else {
                    seats.add(Seat(row, num, BigDecimal(18.00), "Standard View"))
                }
            }
        }

        //Immutable list is returned
        return seats.toList()
    }
}