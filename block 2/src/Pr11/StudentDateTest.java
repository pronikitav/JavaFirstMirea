package Pr11;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class StudentDateTest {
    public static void main(String[] args) {
        Calendar cal = new GregorianCalendar(2004, Calendar.MARCH, 15);
        Student s = new Student(105, "Иван", "Петров", "Информатика", 2, "ИКБО-01", 4.5, cal.getTime());

        System.out.println(s);
        System.out.println("Короткий: " + s.getBirthDateString(DateFormat.SHORT));
        System.out.println("Средний: " + s.getBirthDateString(DateFormat.MEDIUM));
        System.out.println("Длинный: " + s.getBirthDateString(DateFormat.LONG));
        System.out.println("Полный: " + s.getBirthDateString(DateFormat.FULL));
    }
}