import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // This creates a List of Person objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30, "New York"));
        people.add(new Person("Bob", 25, "Los Angeles"));
        people.add(new Person("Charlie", 35, "New York"));
        people.add(new Person("David", 28, "Chicago"));
        people.add(new Person("Eve", 22, "New York"));
        people.add(new Person("Frank", 40, "Los Angeles"));

        System.out.println("Original List:");
        people.forEach(System.out::println); // Uses forEach with a method reference for printing

        // Sorts by Age: Using lambda expressions and the Comparator interface
        // to sort the list of Person objects by age in ascending order.
        people.sort(Comparator.comparingInt(Person::getAge));
        // An alternative way would be using a direct lambda:
        // people.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        System.out.println("\nSorted by Age (Ascending):");
        people.forEach(System.out::println);

        // Filters by City: Uses lambda expressions to filter the sorted list
        // and to keep in it only the people from a specific city ("New York").
        String targetCity = "New York";
        people.removeIf(person -> !person.getCity().equals(targetCity));

        System.out.println("\nFiltered by City (\"" + targetCity + "\"):");
        people.forEach(System.out::println);
    }
}