import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DateInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Год: ");
        int year = sc.nextInt();
        System.out.print("Месяц (1-12): ");
        int month = sc.nextInt();
        System.out.print("Число: ");
        int day = sc.nextInt();
        System.out.print("Часы: ");
        int hours = sc.nextInt();
        System.out.print("Минуты: ");
        int minutes = sc.nextInt();

        Calendar cal = new GregorianCalendar(year, month - 1, day, hours, minutes);
        Date date = cal.getTime();

        SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        System.out.println("Date: " + f.format(date));

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date);
        System.out.println("Год: " + cal2.get(Calendar.YEAR));
        System.out.println("Месяц: " + (cal2.get(Calendar.MONTH) + 1));
        System.out.println("День: " + cal2.get(Calendar.DAY_OF_MONTH));
        System.out.println("Часы: " + cal2.get(Calendar.HOUR_OF_DAY));
        System.out.println("Минуты: " + cal2.get(Calendar.MINUTE));
    }
}