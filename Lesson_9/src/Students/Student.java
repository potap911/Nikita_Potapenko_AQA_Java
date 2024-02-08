package Students;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Student {
    private final String name;
    private final Integer age;
    private final Gender gender;

    public Student(String name, Integer age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public static int getAverageAge(Collection<Student> students) {
        int sumAge = students.stream().map(Student::getAge).mapToInt(Integer::intValue).sum();
        return sumAge / students.size();
    }

    public static List<Student> getConscriptsList(Collection<Student> students) {
        return students.stream().filter(student -> student.getAge() >= 18 && student.getAge() <= 27).toList();
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(age, student.age) && gender == student.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }
}
