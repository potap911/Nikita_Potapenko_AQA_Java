public class Main {
    public static void main(String[] args) {
        System.out.println("\tСписок сотрудников");
        printEmployees(initEmployees());

        System.out.println("\tСписок атракционов");
        Park park = initPark();
        park.printAttractionList();
    }


    public static Employee[] initEmployees() {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee(
                "Иванов Иван Иванович",
                "Сантехник",
                "ivivan@mailbox.com",
                "89205632673",
                15000,
                50
        );
        employees[1] = new Employee(
                "Сидоров Геннадий Петрович",
                "Электрик",
                "sidorov@mailbox.com",
                "89107654832",
                20000,
                29
        );
        employees[2] = new Employee(
                "Васин Олег Яковлевич",
                "Электрик",
                "vasin@mailbox.com",
                "89632894576",
                20000,
                30
        );
        employees[3] = new Employee(
                "Кручин Дмитрий Николаевич",
                "Программист",
                "kruchin@mailbox.com",
                "891912347857",
                12000,
                18
        );
        employees[4] = new Employee(
                "Антонов Алексей Аикторович",
                "Генеральный директор",
                "antonov@mailbox.com",
                "89231281354",
                70000,
                23
        );

        return employees;
    }

    public static void printEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
            System.out.println();
        }
    }

    public static Park initPark() {
        Park park = new Park();
        park.addAttraction("Колесо обозрения", "10:00 - 20:00", 100);
        park.addAttraction("Гонки на медведях", "10:00 - 20:00", 0);
        park.addAttraction("До луны и обратно", "10:00 - 24:00", 123);
        return park;
    }

}