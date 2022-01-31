package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        String name = student.getFirstName();
        String lastName = student.getLastName();

            if (!this.students.contains(student) && this.students.size() < capacity) {
                this.students.add(student);
                return String.format("Added student %s %s", name, lastName);
            } else if (this.students.contains(student) && this.students.size() < capacity) {
                return "Student is already in the university";
            } else {
                return "No seats in the university";
            }

    }

    public String dismissStudent(Student student) {
        if (this.students.contains(student)) {
            String name = student.getFirstName();
            String lastName = student.getLastName();
            this.students.remove(student);
            return String.format("Removed student %s %s", name, lastName);
        }
        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName) {
        Student student = null;
        for (Student student1 : students) {
            if (student1.getFirstName().equals(firstName) && student1.getLastName().equals(lastName)) {
                student = student1;
            }
        }
        return student;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                    student.getFirstName(),
                    student.getLastName(),
                    student.getBestSubject()))
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
