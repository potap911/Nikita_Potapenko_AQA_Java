import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    private HashMap<String, HashSet<String>> phoneBook;


    public PhoneBook() {
        phoneBook = new HashMap<>();
    }


    public void add(String name, String phone) {
        if (checkPhone(phone)) {
            if (phoneBook.containsKey(name)) {
                phoneBook.get(name).add(phone);
            } else {
                phoneBook.put(name, new HashSet<>(2));
                phoneBook.get(name).add(phone);
            }

        } else System.out.println("Не корректный номер!");
    }

    public String get(String name) {
        StringBuilder phoneList = new StringBuilder();
        if (phoneBook.containsKey(name)) {
            phoneList.append("Контакты по имени: ").append(name).append('\n');
            phoneBook.get(name).forEach(phone -> phoneList.append('\t').append(phone).append('\n'));
        }
        return phoneList.toString();
    }

    private boolean checkPhone(String phone) {
        Pattern pattern = Pattern.compile("[+]?[7-8]?[-\\s]?[(]?[0-9]{3}[)]?[-\\s]?[0-9]{3}[-\\s]?[0-9]{2}[-\\s]?[0-9]{2}");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}


