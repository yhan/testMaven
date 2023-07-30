import java.util.Comparator;

public class Person {
    private Integer age;
    private String name;

    Person(){ // without access modifier, ctor is public
    }

    private class ComparatorByAge implements Comparator<Person> {
        @Override
        public int compare(Person a, Person b) {
            if (a == null && b == null) return 0;
            if (a == null) return -1;
            if (b == null) return 1;
            return a.age.compareTo(b.age);
        }
    }

    private class ComparatorByName implements Comparator<Person> {
        @Override
        public int compare(Person a, Person b) {
            if (a == null && b == null) return 0;
            if (a == null) return -1;
            if (b == null) return 1;
            return a.name.compareTo(b.name);
        }
    }
}


