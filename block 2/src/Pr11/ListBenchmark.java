import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListBenchmark {
    static final int N = 50000;

    static void test(String name, List<Integer> list) {
        long t = System.nanoTime();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        print(name, "добавление в конец (" + N + ")", System.nanoTime() - t);

        t = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list.add(list.size() / 2, i);
        }
        print(name, "вставка в середину (10000)", System.nanoTime() - t);

        t = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            list.contains(-1);
        }
        print(name, "поиск значения (100 раз)", System.nanoTime() - t);

        t = System.nanoTime();
        for (int i = 0; i < 5000; i++) {
            list.get(list.size() / 2);
        }
        print(name, "доступ по индексу (5000)", System.nanoTime() - t);

        t = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list.remove(0);
        }
        print(name, "удаление из начала (10000)", System.nanoTime() - t);
    }

    static void print(String name, String operation, long nanos) {
        System.out.printf("%-11s %-32s %10.2f мс%n", name, operation, nanos / 1000000.0);
    }

    public static void main(String[] args) {
        test("ArrayList", new ArrayList<Integer>());
        System.out.println();
        test("LinkedList", new LinkedList<Integer>());
    }
}