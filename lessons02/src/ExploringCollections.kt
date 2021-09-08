fun main(args: Array<String>) {
    //Immutable list - can't be modified
    val colors = listOf("Red", "Green", "Blue")
    println(colors::class.qualifiedName)
    println(colors[0])

    //Mutable list - can be modified
    val days = mutableListOf("Máni's day, Tyr's day", "Odin's day", "Thor's day", "Frigg's day")
    val numbers = mutableListOf(0..9)

    println(days::class.qualifiedName)
    println(numbers::class.qualifiedName)

    //Sets
    val monthsQ1 = setOf("Jan", "Feb", "Mar")
    val noJanuaryAtMonthsQ1 = monthsQ1.minus("Jan")
    println(noJanuaryAtMonthsQ1)
    println(monthsQ1)

    val monthsQ2 = mutableSetOf("Abr", "Jun")
    monthsQ2.add("Jul")
    println(monthsQ2)

    //Maps
    val rgb = mapOf("red" to "ff0000", "green" to "00ff00", "blue" to "0000ff")
    println(rgb)

    val rgbShort = mutableMapOf("red" to "f00")
    rgbShort.put("blue", "0f0")
    rgbShort["green"] = "00f"

    println(rgbShort)
    rgbShort.forEach { println(it.key) }


}