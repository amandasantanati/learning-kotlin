fun main(args: Array<String>) {

    val people = ArrayList<KotlinPerson>()
    people.add(KotlinPerson(1, "Mr", "Fitzwillian", "Darcy", null))
    people.add(KotlinPerson(2, "Mrs", "Elizabeth", "Bennet", null))
    people.add(KotlinPerson(3, "Mrs", "Jane", "Bennet", null))
    people.add(KotlinPerson(4, "Mr", "Charles", "Bingley", null))

    for(person in people) {
        println("$person has id ${person.id}")
    }

    for((id, title, firstName, surname) in people) {
        println("$title $firstName $surname has id $id")
    }

    val characters = HashMap<Int, KotlinPerson>()
    characters.put(1, KotlinPerson(1, "Mr", "Fitzwillian", "Darcy", null))
    characters.put(2, KotlinPerson(2, "Mrs", "Elizabeth", "Bennet", null))
    characters.put(3, KotlinPerson(3, "Mrs", "Jane", "Bennet", null))
    characters.put(4, KotlinPerson(4, "Mr", "Charles", "Bingley", null))

    for((key, value) in characters) {
        println("$value has key $key")
    }

    var x : Int = 0
    while (x < 10) {
        println(x)
        x++
    }

    for(i in 0..9) {
        println(i)
    }

    (0..9).forEach { println(it) }
    (9 downTo 0).forEach { println(it) }
    (0 until 9).forEach { println(it) }
    (0..9 step 2).forEach { println(it) }
    ('A'..'F').forEach { println(it) }
}