package homeworks.streams;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int yearOfBirth;
    private String address;
    private String telephone;
    private String faculty;
    private String course;
    private String group;

    public Student(int id, String firstName, String lastName, int yearOfBirth, String address, String telephone, String faculty, String course, String group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
        this.telephone = telephone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCourse() {
        return this.course;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && yearOfBirth == student.yearOfBirth && firstName.equals(student.firstName)
                && lastName.equals(student.lastName) && address.equals(student.address) && telephone.equals(student.telephone)
                && faculty.equals(student.faculty) && course.equals(student.course) && group.equals(student.group);
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", faculty='" + faculty + '\'' +
                ", course='" + course + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
