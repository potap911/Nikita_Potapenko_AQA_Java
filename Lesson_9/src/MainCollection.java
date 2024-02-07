import java.util.Arrays;
import java.util.Collection;

public class MainCollection {
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }

    public static long getCountEvenNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .count();
    }

    public static long counterHigh(Collection<String> collection) {
        return collection.stream()
                .filter(s -> s.equals("High"))
                .count();
    }

    public static String getFirstElement(Collection<String> collection) {
        return collection.isEmpty() ? "0" : collection.iterator().next();
    }

    public static String getLastElement(Collection<String> collection) {
        return collection.isEmpty() ? "0" : collection.stream().reduce((prev, next) -> next).orElse(null);
    }


    public static void sortCollection(Collection<String> collection) {

    }


}