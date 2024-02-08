import java.util.Scanner;
import java.util.Vector;

public class MainInputLogin {

    public static void main(String[] args) {
        Vector<String> logins = new Vector<>();
        Scanner scan = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Введите логин:");
            if ((input = scan.nextLine()).isEmpty()) break;
            logins.add(input);
        }

        System.out.println("Список введенных логинов, начинающихся на 'f'");
        logins.stream().filter(login -> login.charAt(0) == 'f').forEach(System.out::println);
    }
}
