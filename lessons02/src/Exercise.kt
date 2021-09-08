import java.util.GregorianCalendar

class Exercise

fun main(args: Array<String>) {
    val john = KotlinPerson(1, "Mr.", "John", "Blue", GregorianCalendar(1977, 9, 3))
    val jane = KotlinPerson(1, "Mrs.", "Jane", "Green", null)

    println(john.toString() + "'s age is " + john.age)
    println(jane.toString() + "'s age is " + jane.age)

    val age = KotlinPerson.getAge(GregorianCalendar(1988, 5, 3))
    println("The age of someone born on 3rd May 1988 is $age")
}
