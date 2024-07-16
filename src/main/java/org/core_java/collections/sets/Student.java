package org.core_java.collections.sets;

import java.util.Objects;

public class Student implements Comparable<Student> {
    String name;
    int rollNo;

    public Student(String name, int rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }

    @Override
    public int compareTo(Student other) {
        // Compare by id first, then by name if ids are the same
        if (this.rollNo != other.rollNo) {
            return Integer.compare(this.rollNo, other.rollNo);
        } else {
            return this.name.compareTo(other.name);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo == student.rollNo && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rollNo);
    }
}
