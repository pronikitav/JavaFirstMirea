import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return Double.compare(b.getGpa(), a.getGpa());
    }

    public void quickSort(Student[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        Student pivot = arr[(low + high) / 2];
        int i = low;
        int j = high;
        while (i <= j) {
            while (compare(arr[i], pivot) < 0) {
                i++;
            }
            while (compare(arr[j], pivot) > 0) {
                j--;
            }
            if (i <= j) {
                Student temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        quickSort(arr, low, j);
        quickSort(arr, i, high);
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student(105, "Иван", "Петров", "Информатика", 2, "ИКБО-01-22", 4.5),
                new Student(101, "Анна", "Сидорова", "Информатика", 2, "ИКБО-01-23", 4.9),
                new Student(110, "Олег", "Смирнов", "Экономика", 3, "ЭКБО-02-26", 3.8),
                new Student(103, "Мария", "Иванова", "Экономика", 1, "ЭКБО-05-23", 4.2),
                new Student(107, "Павел", "Кузнецов", "Информатика", 4, "ИКБО-09-25", 3.5)
        };
        SortingStudentsByGPA sorter = new SortingStudentsByGPA();
        sorter.quickSort(students, 0, students.length - 1);
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}