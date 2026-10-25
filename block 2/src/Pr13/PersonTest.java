class Person {
    private String surname;
    private String name;
    private String patronymic;

    public Person(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public String getShortName() {
        StringBuilder sb = new StringBuilder(surname);
        boolean hasName = name != null && !name.isEmpty();
        boolean hasPatronymic = patronymic != null && !patronymic.isEmpty();
        if (hasName || hasPatronymic) {
            sb.append(' ');
            if (hasName) {
                sb.append(name.charAt(0)).append('.');
            }
            if (hasPatronymic) {
                sb.append(patronymic.charAt(0)).append('.');
            }
        }
        return sb.toString();
    }
}

public class PersonTest {
    public static void main(String[] args) {
        System.out.println(new Person("Иванов", "Иван", "Иванович").getShortName());
        System.out.println(new Person("Петрова", "Анна", null).getShortName());
        System.out.println(new Person("Сидоров", "", "Петрович").getShortName());
        System.out.println(new Person("Кузнецов", null, null).getShortName());
    }
}