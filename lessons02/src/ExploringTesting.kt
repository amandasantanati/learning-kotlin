
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.util.Calendar
import kotlin.test.assertEquals

class AgeCalculation {
    fun getAge(dateOfBirth: Calendar) : Int {
        val today = Calendar.getInstance()

        if(dateOfBirth.timeInMillis > today.timeInMillis) throw IllegalArgumentException()

        val years = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR)

        return if(dateOfBirth.get(Calendar.DAY_OF_YEAR) > today.get(Calendar.DAY_OF_YEAR)) {
            years - 1
        }
        else
            years
    }
}

//JUnit4 doesn't work great with Kotlin
//JUnit5 (Jupiter) works just fine
class AgeCalculationTest {

    private val ageCalculation = AgeCalculation()

    @Test
    fun checkAgeWhenBornToday() {
        assertEquals(0, ageCalculation.getAge(Calendar.getInstance()))
    }

    @Test
    fun checkAgeWhenBorn1000DaysAgo() {
        val date = Calendar.getInstance()
        date.add(Calendar.DAY_OF_YEAR, -1000)

        assertEquals(2, ageCalculation.getAge(date))
    }

    @Test
    fun testForExceptionWhenBornInTheFuture() {
        val date = Calendar.getInstance()
        date.add(Calendar.DAY_OF_YEAR, 10)

        assertThrows(java.lang.IllegalArgumentException::class.java) {
            ageCalculation.getAge(date)
        }
    }
}
