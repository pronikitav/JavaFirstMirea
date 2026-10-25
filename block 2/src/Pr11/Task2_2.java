import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Task2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        System.out.print("Введите дату и время (дд.мм.гггг чч:мм): ");
        String text = sc.nextLine();

        Date entered;
        try {
            entered = f.parse(text);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты");
            return;
        }

        Date now = new Date();
        System.out.println("Сейчас: " + f.format(now));
        System.out.println("Введено: " + f.format(entered));

        if (entered.before(now)) {
            System.out.println("Введённая дата раньше текущей");
        } else if (entered.after(now)) {
            System.out.println("Введённая дата позже текущей");
        } else {
            System.out.println("Даты совпадают");
        }

        long diff = Math.abs(now.getTime() - entered.getTime());
        long days = diff / (1000L * 60 * 60 * 24);
        long hours = diff / (1000L * 60 * 60) % 24;
        System.out.println("Разница: " + days + " дн. " + hours + " ч.");
    }
}