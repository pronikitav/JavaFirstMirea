import java.util.Random;
import java.util.Scanner;

public class Poker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Сколько игроков: ");
        int n = sc.nextInt();
        if (n < 1 || n * 5 > 52) {
            System.out.println("Можно от 1 до 10 игроков");
            return;
        }

        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "В", "Д", "К", "Т"};
        String[] suits = {"пик", "черв", "буб", "треф"};
        String[] deck = new String[52];
        int k = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[k] = ranks[j] + " " + suits[i];
                k++;
            }
        }

        Random rand = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            String temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }

        int pos = 0;
        for (int p = 1; p <= n; p++) {
            System.out.println("Игрок " + p + ":");
            for (int c = 0; c < 5; c++) {
                System.out.println(deck[pos]);
                pos++;
            }
            System.out.println();
        }
    }
}