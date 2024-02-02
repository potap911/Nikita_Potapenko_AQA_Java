import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String[] words = {"test1", "test1", "test1", "test2", "test1", "test2",
                "test3", "test4", "test5", "test5", "word1", "word2", "word", "еще одно слово", "еще одно слово"};
        System.out.println(getUniqueWordsList(words));

        phoneBookTest1();
        phoneBookTest2();
    }

    public static String getUniqueWordsList(String[] words) {
        HashMap<String, Integer> uniqueWordsList = new HashMap<>();
        StringBuilder resultList = new StringBuilder();

        for (String word : words) {
            if (uniqueWordsList.containsKey(word)) {
                uniqueWordsList.replace(word, uniqueWordsList.get(word) + 1);
                continue;
            }
            uniqueWordsList.put(word, 1);
        }

        resultList.append("\t#Список уникальных слов:\n");

        uniqueWordsList.keySet().forEach(key -> resultList.append(key)
                .append(" - колличество повторений: ")
                .append(uniqueWordsList.get(key))
                .append('\n'));
        return resultList.toString();
    }

    public static void phoneBookTest1() {
        System.out.println("\t#Тест добавления и получения номеров");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Мой номер", "89531281919");
        phoneBook.add("Мой номер", "89201231353");
        phoneBook.add("Другой номер", "89201231353");

        System.out.println(phoneBook.get("Мой номер"));
        System.out.println(phoneBook.get("Другой номер"));
    }

    public static void phoneBookTest2() {
        System.out.println("\t#Тест добавление не верного номера: 89531281919000");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Мой номер", "89531281919000");
    }
}