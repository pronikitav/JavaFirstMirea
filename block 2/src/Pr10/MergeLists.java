package Pr10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class ByGpaDesc implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return Double.compare(b.getGpa(), a.getGpa());
    }
}

public class MergeLists {
    public static ArrayList<Student> merge(ArrayList<Student> x, ArrayList<Student> y, Comparator<Student> c) {
        ArrayList<Student> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < x.size() && j < y.size()) {
            if (c.compare(x.get(i), y.get(j)) <= 0) {
                result.add(x.get(i));
                i++;
            } else {
                result.add(y.get(j));
                j++;
            }
        }
        while (i < x.size()) {
            result.add(x.get(i));
            i++;
        }
        while (j < y.size()) {
            result.add(y.get(j));
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Student> list1 = new ArrayList<>();
        list1.add(new Student(105, "Иван", "Петров", "Информатика", 2, "ИКБО-01-22", 4.5));
        list1.add(new Student(110, "Олег", "Смирнов", "Экономика", 3, "ЭКБО-02-23", 3.8));
        list1.add(new Student(101, "Анна", "Сидорова", "Информатика", 2, "ИКБО-01-23", 4.9));

        ArrayList<Student> list2 = new ArrayList<>();
        list2.add(new Student(103, "Мария", "Иванова", "Экономика", 1, "ЭКБО-05-24", 4.2));
        list2.add(new Student(107, "Павел", "Кузнецов", "Информатика", 4, "ИКБО-09-25", 3.5));
        list2.add(new Student(120, "Елена", "Орлова", "Экономика", 2, "ЭКБО-03-26", 4.7));

        Comparator<Student> c = new ByGpaDesc();
        Collections.sort(list1, c);
        Collections.sort(list2, c);

        ArrayList<Student> all = merge(list1, list2, c);
        for (int i = 0; i < all.size(); i++) {
            System.out.println(all.get(i));
        }
    }
}