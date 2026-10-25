import java.util.regex.Pattern;

public class Regex2 {
    public static void main(String[] args) {
        String regex = "abcdefghijklmnopqrstuv18340";
        String[] tests = {
                "abcdefghijklmnopqrstuv18340",
                "abcdefghijklmnoasdfasdpqrstuv18340"
        };
        for (int i = 0; i < tests.length; i++) {
            System.out.println(tests[i] + " - " + Pattern.matches(regex, tests[i]));
        }
    }
}
