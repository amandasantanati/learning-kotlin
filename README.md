## README

### Context
This repository is part of learning Kotlin language to backend.
The lessons and exercises are from an Udemy course named "Build fully functional, robust and efficient applications with Spring Boot and the Kotlin programming language" from Matt Greencroft.
It's a 8 hours course with 20 chapters and 21 sections.

I've been also reading [the official documentation for Kotlin](https://kotlinlang.org/docs/home.html).

### Java Interoperability
**Note: For all this code I'm using IntelliJ IDEA as my IDE.**

Let's say we have a class in Kotlis as below:
```
class data Customer(id: Long, name: String)
```

When we try to initialize an instance of this class in a Java main function as below:
```
public static void main(String[] args) {
    Customer phill = new Customer(null, null);
    Customer claire = new Customer(0, null);
}
```

We get a compiler error for the first declaration because of Java transforms the Long for its long primitive type, which doesn't allow null. 
For the second declaration we get not a compiler error but an `IllegalArgumentException` since in our Kotlin class the name is declared as non nullable value.

In Java we also get `component1()` and `component2()` as `Long` and `String` respectively as the desconstructor methods for our properties. 
Although, the most interesting thing is to notice that we do not have any `set` method for our Customer class since its properties are `val` in Kotlin.

Now, let's say we have a CustomerDatabase class consisted by an immutable list of customers in Kotlin as bellow:
```
class CustomerDatabase() {
    val customers = listOf(
        Customer(1, "Jay"),
        Customer(1, "Gloria")
    )
}
```

In Java, we don't get a compiler error again, since Kotlin immutable lists have a trick based on Java List to have compability. 
But when we try to add an item to this list as in the following code:
```
public static void main(String[] args) {
    Customer claire = new Customer(0, "Claire");
    CustomerDatabase db = new CustomerDatabase();

    db.add(claire)
}
```
We get an `UnsupportedOperationException` at runtime.

//TODO - Exception handling
//TODO - Usinf static functions
//TODO - Importing Kotlin jar into Java project 