package com11.java;

import java.util.HashMap;

public class StudentService {

    private HashMap<Integer, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        if (students.containsKey(student.getId())) {
            System.out.println("Student ID Already Exists!");
            return;
        }

        students.put(student.getId(), student);
        System.out.println("Student Added Successfully!");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No Students Found!");
            return;
        }

        for (Student student : students.values()) {
            student.displayStudent();
        }
    }

    public Student searchById(int id) {
        Student student = students.get(id);

        if (student == null) {
            System.out.println("Student Not Found!");
        } else {
            student.displayStudent();
        }

        return student;
    }

    public void searchByName(String name) {
        boolean found = false;

        for (Student student : students.values()) {
            if (student.getName().equalsIgnoreCase(name)) {
                student.displayStudent();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Student Not Found!");
        }
    }

    public void updateMarks(int id, double marks) {
        Student student = students.get(id);

        if (student == null) {
            System.out.println("Student Not Found!");
            return;
        }

        student.setMarks(marks);
        System.out.println("Marks Updated Successfully!");
    }

    public void updateAttendance(int id, int attendance) {
        Student student = students.get(id);

        if (student == null) {
            System.out.println("Student Not Found!");
            return;
        }

        student.setAttendance(attendance);
        System.out.println("Attendance Updated Successfully!");
    }

    public void calculateGrade(int id) {
        Student student = students.get(id);

        if (student == null) {
            System.out.println("Student Not Found!");
            return;
        }

        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Grade: " + student.calculateGrade());
    }

    public void removeStudent(int id) {
        if (students.remove(id) != null) {
            System.out.println("Student Removed Successfully!");
        } else {
            System.out.println("Student Not Found!");
        }
    }

    public void displayTopper() {
        if (students.isEmpty()) {
            System.out.println("No Students Available!");
            return;
        }

        Student topper = null;

        for (Student student : students.values()) {
            if (topper == null || student.getMarks() > topper.getMarks()) {
                topper = student;
            }
        }

        System.out.println("\n===== TOPPER DETAILS =====");
        topper.displayStudent();
    }

    public HashMap<Integer, Student> getStudents() {
        return students;
    }

    public void setStudents(HashMap<Integer, Student> students) {
        this.students = students;
    }
}