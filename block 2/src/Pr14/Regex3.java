import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex3 {
    public static void main(String[] args) {
        String text = "Хлеб 25.98 USD, молоко 44 ERR, сыр 0.004 EU, ручка 120 RUB, кофе 7.50 EU, чай 3.5 RUB";
        Pattern p = Pattern.compile("(?<![\\d.])\\d+(\\.\\d{2})?(?!\\d)\\s(USD|RUB|EU)\\b");
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}