package Pr11;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Student implements Comparable<Student> {
    private int idNumber;
    private String name;
    private String surname;
    private String speciality;
    private int course;
    private String group;
    private double gpa;
    private Date birthDate;

    public Student(int idNumber, String name, String surname, String speciality, int course, String group, double gpa) {
        this.idNumber = idNumber;
        this.name = name;
        this.surname = surname;
        this.speciality = speciality;
        this.course = course;
        this.group = group;
        this.gpa = gpa;
    }

    public Student(int idNumber, String name, String surname, String speciality, int course, String group, double gpa, Date birthDate) {
        this(idNumber, name, surname, speciality, course, group, gpa);
        this.birthDate = birthDate;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDateString(int style) {
        if (birthDate == null) {
            return "не указана";
        }
        DateFormat f = DateFormat.getDateInstance(style, Locale.forLanguageTag("ru-RU"));
        return f.format(birthDate);
    }

    public int compareTo(Student other) {
        return Integer.compare(idNumber, other.idNumber);
    }

    public String toString() {
        return idNumber + " " + surname + " " + name + ", " + speciality + ", " + course + " курс, группа " + group
                + ", балл " + gpa + ", родился " + getBirthDateString(DateFormat.LONG);
    }
}