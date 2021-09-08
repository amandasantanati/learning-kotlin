import java.util.GregorianCalendar;

public class Exercise {

    public static void main(String[] args) {
        JavaPerson john = new JavaPerson(1L, "Mr.", "John", "Blue", new GregorianCalendar(1977,9,3));
        JavaPerson jane = new JavaPerson(1L, "Mrs.", "Jane", "Green", null);

        System.out.println(john + "'s age is " + john.getAge());
        System.out.println(jane + "'s age is " + jane.getAge());

        int age = JavaPerson.getAge(new GregorianCalendar(1988, 5, 3));
        System.out.println("The age of someone born on 3rd May 1988 is " + age);
    }
}
