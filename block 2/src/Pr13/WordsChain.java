import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordsChain {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Имя файла: ");
        String fileName = sc.nextLine();

        StringBuilder text = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            text.append(line).append(' ');
        }
        reader.close();

        String[] words = text.toString().trim().split("\\s+");
        StringBuilder result = getLine(words);
        if (result.length() == 0) {
            System.out.println("Цепочку из всех слов составить нельзя");
        } else {
            System.out.println(result);
        }
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder();
        if (words == null || words.length == 0 || words[0].isEmpty()) {
            return result;
        }
        boolean[] used = new boolean[words.length];
        ArrayList<String> chain = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            chain.add(words[i]);
            used[i] = true;
            if (build(words, used, chain)) {
                break;
            }
            chain.remove(chain.size() - 1);
            used[i] = false;
        }
        if (chain.size() == words.length) {
            for (int i = 0; i < chain.size(); i++) {
                result.append(chain.get(i));
                if (i < chain.size() - 1) {
                    result.append(' ');
                }
            }
        }
        return result;
    }

    private static boolean build(String[] words, boolean[] used, ArrayList<String> chain) {
        if (chain.size() == words.length) {
            return true;
        }
        String last = chain.get(chain.size() - 1);
        char lastLetter = last.charAt(last.length() - 1);
        for (int j = 0; j < words.length; j++) {
            if (!used[j] && Character.toLowerCase(lastLetter) == Character.toLowerCase(words[j].charAt(0))) {
                used[j] = true;
                chain.add(words[j]);
                if (build(words, used, chain)) {
                    return true;
                }
                chain.remove(chain.size() - 1);
                used[j] = false;
            }
        }
        return false;
    }
}