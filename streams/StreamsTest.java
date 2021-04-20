package homeworks.streams;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

import static homeworks.streams.StudentsData.*;

public class StreamsTest {

    public Streams myStream;
    public List<Student> testData;

    @BeforeEach
    public void setUp() {
        myStream = new Streams();
        testData = myStream.createStudentsList();
    }

    @Test
    public void test_getStudentsByFaculty() {
        List<Student> expected = new ArrayList<>();
        expected.add(student3);
        expected.add(student4);
        expected.add(student10);
        expected.add(student11);
        List<Student> actual = myStream.getStudentsByFaculty("Сварка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_getStudentsInEachFacultyAndGroup() {
        Map<String, Map<String, List<Student>>> expected = new HashMap<>();
        Map<String, List<Student>> faculty1 = new HashMap<>();
        faculty1.put("СВ-12", testData.stream().filter(student -> student.getGroup().equals("СВ-12")).collect(Collectors.toList()));
        faculty1.put("СВ-13", testData.stream().filter(student -> student.getGroup().equals("СВ-13")).collect(Collectors.toList()));
        faculty1.put("СВ-14", testData.stream().filter(student -> student.getGroup().equals("СВ-14")).collect(Collectors.toList()));
        expected.put("Сварка", faculty1);

        Map<String, List<Student>> faculty2 = new HashMap<>();
        faculty2.put("КИТ-37у", testData.stream().filter(student -> student.getGroup().equals("КИТ-37у")).collect(Collectors.toList()));
        faculty2.put("КИТ-47", testData.stream().filter(student -> student.getGroup().equals("КИТ-47")).collect(Collectors.toList()));
        expected.put("Информационных технологий", faculty2);

        Map<String, List<Student>> faculty3 = new HashMap<>();
        faculty3.put("М-1337", testData.stream().filter(student -> student.getGroup().equals("М-1337")).collect(Collectors.toList()));
        faculty3.put("М-1338", testData.stream().filter(student -> student.getGroup().equals("М-1338")).collect(Collectors.toList()));
        faculty3.put("М-1339", testData.stream().filter(student -> student.getGroup().equals("М-1339")).collect(Collectors.toList()));

        expected.put("Менеджмент", faculty3);
        Map<String, Map<String, List<Student>>> actual = myStream.getStudentsInEachFacultyAndGroup();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_getStudentsByYearOfBirth() {
        List<Student> expected = new ArrayList<>();
        expected.add(student1);
        expected.add(student2);
        expected.add(student3);
        expected.add(student4);
        List<Student> actual = myStream.getStudentsByYearOfBirth(1997);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_getStudentByYearOfBirth() {
        List<Student> expected = new ArrayList<>();
        expected.add(student1);
        List<Student> actual = myStream.getStudentByYearOfBirth(1996);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_getGroupList() {
        List<String> expected = new ArrayList<>();
        expected.add(student1.getFirstName() + " " + student1.getLastName());
        expected.add(student5.getFirstName() + " " + student5.getLastName());
        List<String> actual = myStream.getGroupList("КИТ-37у");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_countStudentsOnFaculty() {
        long expected = 4;
        long actual = myStream.countStudentsOnFaculty("Менеджмент");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_changeGroup() {
        testData.get(1).setGroup("xz");
        testData.get(5).setGroup("xz");

        List<Student> actual = myStream.changeGroup("М-1337", "xz");
        Assertions.assertEquals(testData, actual);
    }

    @Test
    public void test_changeFaculty() {
        testData.get(2).setFaculty("Бизнес");
        testData.get(3).setFaculty("Бизнес");
        testData.get(9).setFaculty("Бизнес");
        testData.get(10).setFaculty("Бизнес");

        List<Student> actual = myStream.changeFaculty("Сварка", "Бизнес");
        Assertions.assertEquals(testData, actual);
    }

    @Test
    public void test_findStudentOnFaculty() {
        Assertions.assertEquals(testData.get(2), myStream.findStudentOnFaculty("Сварка"));
    }

    @Test
    public void test_printStudents() {
        ByteArrayOutputStream actual = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actual));
        String expected = "Паша Павлов - Информационных технологий, КИТ-37у;\nСаша Цветков - Менеджмент, М-1337;\nГриша Иванов - Сварка, СВ-13;\n";
        myStream.printStudents(3);
        Assertions.assertEquals(expected, actual.toString());
    }

    @Test
    public void test_groupByFaculty() {
        Map<String, List<Student>> expected = new HashMap<>();
        expected.put("Информационных технологий", testData.stream().filter(student -> student.getFaculty().equals("Информационных технологий")).collect(Collectors.toList()));
        expected.put("Менеджмент", testData.stream().filter(student -> student.getFaculty().equals("Менеджмент")).collect(Collectors.toList()));
        expected.put("Сварка", testData.stream().filter(student -> student.getFaculty().equals("Сварка")).collect(Collectors.toList()));

        Map<String, List<Student>> actual = myStream.groupByFaculty();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_groupByCourse() {
        Map<String, List<Student>> expected = new HashMap<>();
        expected.put("1-й", testData.stream().filter(student -> student.getCourse().equals("1-й")).collect(Collectors.toList()));
        expected.put("2-й", testData.stream().filter(student -> student.getCourse().equals("2-й")).collect(Collectors.toList()));
        expected.put("3-й", testData.stream().filter(student -> student.getCourse().equals("3-й")).collect(Collectors.toList()));
        expected.put("4-й", testData.stream().filter(student -> student.getCourse().equals("4-й")).collect(Collectors.toList()));

        Map<String, List<Student>> actual = myStream.groupByCourse();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_groupByGroupName() {
        Map<String, List<Student>> expected = new HashMap<>();
        expected.put("КИТ-37у", testData.stream().filter(student -> student.getGroup().equals("КИТ-37у")).collect(Collectors.toList()));
        expected.put("М-1337", testData.stream().filter(student -> student.getGroup().equals("М-1337")).collect(Collectors.toList()));
        expected.put("СВ-12", testData.stream().filter(student -> student.getGroup().equals("СВ-12")).collect(Collectors.toList()));
        expected.put("СВ-13", testData.stream().filter(student -> student.getGroup().equals("СВ-13")).collect(Collectors.toList()));
        expected.put("СВ-14", testData.stream().filter(student -> student.getGroup().equals("СВ-14")).collect(Collectors.toList()));
        expected.put("М-1338", testData.stream().filter(student -> student.getGroup().equals("М-1338")).collect(Collectors.toList()));
        expected.put("М-1339", testData.stream().filter(student -> student.getGroup().equals("М-1339")).collect(Collectors.toList()));
        expected.put("КИТ-47", testData.stream().filter(student -> student.getGroup().equals("КИТ-47")).collect(Collectors.toList()));

        Map<String, List<Student>> actual = myStream.groupByGroupName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_isSameFacultyForAll() {
        Assertions.assertFalse(myStream.isSameFacultyForAll("Сварка"));
        myStream.students.removeIf(student -> !student.getFaculty().equals("Сварка"));
        Assertions.assertTrue(myStream.isSameFacultyForAll("Сварка"));
    }

    @Test
    public void test_isSameFaculty() {
        Assertions.assertFalse(myStream.isSameFaculty("xz"));
        Assertions.assertTrue(myStream.isSameFaculty("Менеджмент"));
    }

    @Test
    public void test_isSameGroupForAll() {
        Assertions.assertFalse(myStream.isSameGroupForAll("КИТ-1000"));
        myStream.students.removeIf(student -> !student.getFaculty().equals("М-1337"));
        Assertions.assertTrue(myStream.isSameGroupForAll("М-1337"));
    }

    @Test
    public void test_isSameGroup() {
        Assertions.assertFalse(myStream.isSameGroup("xz"));
        Assertions.assertTrue(myStream.isSameGroup("СВ-13"));
    }

}
