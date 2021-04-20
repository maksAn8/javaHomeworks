package homeworks.streams;

import java.util.*;
import java.util.stream.Collectors;
import static homeworks.streams.StudentsData.*;

public class Streams {
    public List<Student> students;

    public Streams() {
        students = createStudentsList();
    }

    public List<Student> getStudentsByFaculty(String faculty) {
        return students.stream().filter(student -> student.getFaculty().equals(faculty)).collect(Collectors.toList());
    }

    public Map<String, Map<String, List<Student>>> getStudentsInEachFacultyAndGroup() {
        return students.stream().collect(Collectors.groupingBy(Student::getFaculty, Collectors.groupingBy(Student::getGroup)));
    }

    public List<Student> getStudentsByYearOfBirth(int yearOfBirth) {
        return students.stream().filter(student -> student.getYearOfBirth() > yearOfBirth).collect(Collectors.toList());
    }

    public List<Student> getStudentByYearOfBirth(int yearOfBirth) {
        return students.stream().filter(student -> student.getYearOfBirth() > yearOfBirth).limit(1).collect(Collectors.toList());
    }

    public List<String> getGroupList(String group) {
        return students.stream().filter(student -> student.getGroup().equals(group)).map(student -> student.getFirstName() + " " + student.getLastName()).collect(Collectors.toList());
    }

    public long countStudentsOnFaculty(String faculty) {
        return students.stream().filter(student -> student.getFaculty().equals(faculty)).count();
    }

    public List<Student> changeGroup(String oldGroup, String newGroup) {
        students.stream().filter(student -> student.getGroup().equals(oldGroup)).forEach(student -> student.setGroup(newGroup));
        return students;
    }

    public List<Student> changeFaculty(String oldFaculty, String newFaculty) {
        students.stream().filter(student -> student.getFaculty().equals(oldFaculty)).forEach(student -> student.setFaculty(newFaculty));
        return students;
    }

    public Student findStudentOnFaculty(String faculty) {
        return students.stream().filter(student -> student.getFaculty().equals(faculty)).findAny().orElseThrow();
    }

    public void printStudents(int limit) {
        String result = students.stream().limit(limit).map(student -> student.getFirstName() + " "
                + student.getLastName() + " - "
                + student.getFaculty() + ", "
                + student.getGroup() + ";\n").reduce(String::concat).orElseThrow();
        System.out.print(result);
    }

    public Map<String, List<Student>> groupByFaculty() {
        Map<String, List<Student>> result;
        result = students.stream().collect(Collectors.groupingBy(Student::getFaculty));
        System.out.println(result);
        return result;
    }

    public Map<String, List<Student>> groupByCourse() {
        Map<String, List<Student>> result;
        result = students.stream().collect(Collectors.groupingBy(Student::getCourse));
        System.out.println(result);
        return result;
    }

    public Map<String, List<Student>> groupByGroupName() {
        Map<String, List<Student>> result;
        result = students.stream().collect(Collectors.groupingBy(Student::getGroup));
        System.out.println(result);
        return result;
    }

    public boolean isSameFacultyForAll(String faculty) {
        return students.stream().allMatch(student -> student.getFaculty().equals(faculty));
    }

    public boolean isSameFaculty(String faculty) {
        return students.stream().anyMatch(student -> student.getFaculty().equals(faculty));
    }

    public boolean isSameGroupForAll(String group) {
        return students.stream().allMatch(student -> student.getGroup().equals(group));
    }

    public boolean isSameGroup(String group) {
        return students.stream().anyMatch(student -> student.getGroup().equals(group));
    }

    public List<Student> createStudentsList() {
        List<Student> list = new ArrayList<>();

        list.add(new Student(1,"Паша", "Павлов", 1998, "ул. Пушкина, дом Колотушкина", "1234567890", "Информационных технологий", "1-й", "КИТ-37у"));
        list.add(new Student(2,"Саша", "Цветков", 1998, "ул. Странных, 47", "0987654321", "Менеджмент", "2-й", "М-1337"));
        list.add(new Student(3,"Гриша", "Иванов", 1998, "ул. Маршала, 22", "1111111111", "Сварка", "3-й", "СВ-13"));
        list.add(new Student(4,"Миша", "Попов", 1998, "ул. Генерала, 123", "2222222222", "Сварка", "4-й", "СВ-14"));
        list.add(new Student(5,"Влад", "Дуров", 1997, "ул. Полковника, 12", "3333333333", "Информационных технологий", "1-й", "КИТ-37у"));
        list.add(new Student(6,"Толя", "Муров", 1997, "ул. Подполковника, 2", "4444444444", "Менеджмент", "2-й", "М-1337"));
        list.add(new Student(7,"Коля", "Нуров", 1996, "ул. Майора, 70", "5555555555", "Менеджмент", "3-й", "М-1338"));
        list.add(new Student(8,"Даня", "Шнуров", 1996, "ул. Прапорщика 1337", "6666666666", "Менеджмент", "4-й", "М-1339"));
        list.add(new Student(9,"Роман", "Острый", 1996, "ул. Лейтенанта 11", "7777777777", "Информационных технологий", "4-й", "КИТ-47"));
        list.add(new Student( 10,"Славик", "Якименко", 1996, "ул. Сержанта 25", "8888888888", "Сварка", "2-й", "СВ-12"));
        list.add(new Student( 11,"Андрей", "Шалёпа", 1996, "ул. Ефрейтора 85", "9999999999", "Сварка", "3-й", "СВ-13"));
        list.add(new Student( 12,"Максим", "Анацкий", 1997, "ул. НЕПОНЯТНОКАКАЯ 50", "0000000000", "Информационных технологий", "4-й", "КИТ-47"));
//
//        list.add(student1);
//        list.add(student2);
//        list.add(student3);
//        list.add(student4);
//        list.add(student5);
//        list.add(student6);
//        list.add(student7);
//        list.add(student8);
//        list.add(student9);
//        list.add(student10);
//        list.add(student11);
//        list.add(student12);
        return list;
    }
}
