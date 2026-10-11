interface StringTools {
    int countChars(String s);

    String oddChars(String s);

    String reverse(String s);
}

class ProcessStrings implements StringTools {
    public int countChars(String s) {
        return s.length();
    }

    public String oddChars(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i += 2) {
            result += s.charAt(i);
        }
        return result;
    }

    public String reverse(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }
}

public class StringsTest {
    public static void main(String[] args) {
        StringTools tools = new ProcessStrings();
        String s = "abcdefgh";
        System.out.println("Строка: " + s);
        System.out.println("Количество символов: " + tools.countChars(s));
        System.out.println("Символы на нечётных позициях: " + tools.oddChars(s));
        System.out.println("Перевёрнутая строка: " + tools.reverse(s));
    }
}