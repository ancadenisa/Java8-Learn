package LambdaExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * ParallelOperationsOnCollections.java
 * Created by Anca.Barbu on 8/26/2015.
 */
enum Gender {
    Female("f"), Male("m");

    String type;

    Gender(String type) {
        this.type = type;
    }
}

class Person {
    Gender gender;
    String name;

    Person(Gender gender, String name) {
        this.gender = gender;
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return this.name;
    }
}

public class ParallelOperationsOnCollections {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(Gender.Female, "Anca"));
        persons.add(new Person(Gender.Male, "Mihai"));
        persons.add(new Person(Gender.Female, "Teo"));
        persons.add(new Person(Gender.Male, "Justinian"));
        persons.add(new Person(Gender.Male, "Nicu"));
        persons.add(new Person(Gender.Female, "Gina"));
        ConcurrentMap<Gender, List<Person>> byGender =
                persons.parallelStream().collect(
                        Collectors.groupingByConcurrent(Person::getGender));

        System.out.println(byGender.toString());

    }
}
