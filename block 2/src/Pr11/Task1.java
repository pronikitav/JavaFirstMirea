import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Task1 {
    public static void main(String[] args) {
        String developer = "Иванов";
        Calendar received = new GregorianCalendar(2026, Calendar.OCTOBER, 20, 10, 30, 0);
        Date submitted = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        System.out.println("Разработчик: " + developer);
        System.out.println("Задание получено: " + f.format(received.getTime()));
        System.out.println("Задание сдано: " + f.format(submitted));
    }
}