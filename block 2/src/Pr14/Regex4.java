import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex4 {
    public static void main(String[] args) {
        String[] tests = {"(1 + 8) – 9 / 4", "6 / 5 – 2 * 9"};
        Pattern notFollowedByPlus = Pattern.compile("\\d(?!\\s*\\+)");
        Pattern followedByPlus = Pattern.compile("\\d\\s*\\+");

        for (int i = 0; i < tests.length; i++) {
            Matcher m1 = notFollowedByPlus.matcher(tests[i]);
            Matcher m2 = followedByPlus.matcher(tests[i]);
            System.out.println("Текст: " + tests[i]);
            System.out.println("Есть цифра без плюса после неё: " + m1.find());
            System.out.println("Есть цифра с плюсом после неё: " + m2.find());
        }
    }
}