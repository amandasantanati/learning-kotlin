
import java.util.Calendar
import java.util.Calendar.DAY_OF_YEAR
import java.util.Calendar.YEAR
import java.util.GregorianCalendar

data class KotlinPerson (
    val id: Int,
    val title: String,
    val firstName: String,
    val surname: String,
    val dateOfBirth: Calendar?
) {

    companion object {
        fun getAge(dateOfBirth: Calendar?): Int {
            if(dateOfBirth == null) return -1

            val today = GregorianCalendar()
            val years = today.get(YEAR) - dateOfBirth.get(YEAR)

            if(dateOfBirth.get(DAY_OF_YEAR) >= today.get(DAY_OF_YEAR)) {
                return years - 1
            }

            return years
        }
    }

    override fun toString() =
        "$title $firstName $surname"

    val age: Int
        get() = getAge(this.dateOfBirth)
}