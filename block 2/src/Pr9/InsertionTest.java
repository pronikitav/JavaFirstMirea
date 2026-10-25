import Pr10.Student;

public class InsertionTest {
    public static void insertionSort(Comparable[] list) {
        for (int i = 1; i < list.length; i++) {
            Comparable key = list[i];
            int j = i - 1;
            while (j >= 0 && list[j].compareTo(key) > 0) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student(105, "Иван", "Петров", "Информатика", 2, "КВБО-01-23", 4.5),
                new Student(101, "Анна", "Сидорова", "Информатика", 2, "КВБО-02-24", 4.9),
                new Student(110, "Олег", "Смирнов", "Экономика", 3, "ЭКБО-02", 3.8),
                new Student(103, "Мария", "Иванова", "Экономика", 1, "ЭКБО-05", 4.2),
                new Student(107, "Павел", "Кузнецов", "Информатика", 4, "ИКБО-09", 3.5)
        };
        System.out.println("До сортировки:");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
        insertionSort(students);
        System.out.println("После сортировки по idNumber:");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}