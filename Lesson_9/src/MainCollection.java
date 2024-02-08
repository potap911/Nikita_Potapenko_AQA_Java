import Students.Gender;
import Students.Student;

import java.util.*;

public class MainCollection {
    public static void main(String[] args) {
        Collection<String> collection1 = List.of("Highload", "High", "Load", "Highload");
        Collection<String> collection2 = List.of("f10", "f15", "f2", "f4", "f4");
        Collection<Student> students = List.of(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN)
                );

        System.out.println("Задание 1");
        System.out.println("Последовательность: 22, 38, 95, 85, 63, 14, 84, 17, 36, 73");
        System.out.println("Ответ: " + getCountEvenNumbers(new int[] {22, 38, 95, 85, 63, 14, 84, 17, 36, 73}));
        System.out.println();

        System.out.println("Задание 2.1");
        System.out.println("Ответ: " + counterWord(collection1, "High"));
        System.out.println();


        System.out.println("Задание 2.2");
        System.out.println("Ответ: " + getFirstElement(collection1));
        System.out.println();

        System.out.println("Задание 2.3");
        System.out.println("Ответ: " + getLastElement(collection1));
        System.out.println();

        System.out.println("Задание 3");
        String[] array = sortCollectionToArray(collection2);
        Arrays.stream(array).forEach(s -> System.out.print(s + " "));
        System.out.println("\n");

        System.out.println("Задание 4.1");
        System.out.println("Ответ: " + Student.getAverageAge(students));
        System.out.println();

        System.out.println("Задание 4.2");
        List<Student> conscriptsList = Student.getConscriptsList(students);
        conscriptsList.forEach(System.out::println);
        System.out.println();
    }

    public static long getCountEvenNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .count();
    }

    public static long counterWord(Collection<String> collection, String word) {
        return collection.stream()
                .filter(s -> s.equals(word))
                .count();
    }

    public static String getFirstElement(Collection<String> collection) {
        return collection.isEmpty() ? "0" : collection.iterator().next();
    }

    public static String getLastElement(Collection<String> collection) {
        return collection.isEmpty() ? "0" : collection.stream().reduce((prev, next) -> next).orElse(null);
    }

    public static String[] sortCollectionToArray(Collection<String> collection) {
        return collection.stream().sorted(new SpecialComparator()).toArray(String[]::new);
    }
}