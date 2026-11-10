package com11.java;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService service = new StudentService();
        StudentFileService fileService = new StudentFileService();

        
        HashMap<Integer, Student> data = fileService.loadStudents();
        service.setStudents(data);

        int choice = 0;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student By ID");
            System.out.println("4. Search Student By Name");
            System.out.println("5. Update Marks");
            System.out.println("6. Update Attendance");
            System.out.println("7. Calculate Grade");
            System.out.println("8. Remove Student");
            System.out.println("9. Display Topper");
            System.out.println("10. Save Student Details");
            System.out.println("11. Load Student Details");
            System.out.println("12. Exit");

            System.out.print("Enter Your Choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Enter Student ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Student Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        double marks = Double.parseDouble(sc.nextLine());

                        System.out.print("Enter Attendance: ");
                        int attendance = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Course ID: ");
                        int courseId = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Course Name: ");
                        String courseName = sc.nextLine();

                        System.out.print("Enter Course Fee: ");
                        double courseFee = Double.parseDouble(sc.nextLine());

                        Course course = new Course(
                                courseId, courseName, courseFee);

                        Student student = new Student(
                                id, name, email, marks, attendance,
                                StudentStatus.ACTIVE, course);

                        service.addStudent(student);
                        break;

                    case 2:
                        service.displayAllStudents();
                        break;

                    case 3:
                        System.out.print("Enter Student ID: ");
                        int searchId = Integer.parseInt(sc.nextLine());
                        service.searchById(searchId);
                        break;

                    case 4:
                        System.out.print("Enter Student Name: ");
                        String searchName = sc.nextLine();
                        service.searchByName(searchName);
                        break;

                    case 5:
                        System.out.print("Enter Student ID: ");
                        int updateId = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter New Marks: ");
                        double newMarks = Double.parseDouble(sc.nextLine());

                        service.updateMarks(updateId, newMarks);
                        break;

                    case 6:
                        System.out.print("Enter Student ID: ");
                        int attendanceId = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter New Attendance: ");
                        int newAttendance = Integer.parseInt(sc.nextLine());

                        service.updateAttendance(attendanceId, newAttendance);
                        break;

                    case 7:
                        System.out.print("Enter Student ID: ");
                        int gradeId = Integer.parseInt(sc.nextLine());
                        service.calculateGrade(gradeId);
                        break;

                    case 8:
                        System.out.print("Enter Student ID: ");
                        int removeId = Integer.parseInt(sc.nextLine());
                        service.removeStudent(removeId);
                        break;

                    case 9:
                        service.displayTopper();
                        break;

                    case 10:
                        fileService.saveStudents(service.getStudents());
                        break;

                    case 11:
                        service.setStudents(fileService.loadStudents());
                        break;

                    case 12:
                        fileService.saveStudents(service.getStudents());
                        System.out.println("Application Closed Successfully!");
                        break;

                    default:
                        System.out.println("Invalid Choice! Please Try Again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please Enter Valid Numeric Values!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 12);

        sc.close();
    }
}