package com11.java;

import java.io.*;
import java.util.HashMap;

public class StudentFileService {

    private static final String FILE_NAME = "students.dat";

    public void saveStudents(HashMap<Integer, Student> students) {
        try (ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            out.writeObject(students);
            System.out.println("Student Details Saved Successfully!");

        } catch (IOException e) {
            System.out.println("Error Saving File: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public HashMap<Integer, Student> loadStudents() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No Previous Student File Found!");
            return new HashMap<>();
        }

        try (ObjectInputStream in =
                new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            HashMap<Integer, Student> students =
                    (HashMap<Integer, Student>) in.readObject();

            System.out.println("Student Details Loaded Successfully!");
            return students;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error Loading File: " + e.getMessage());
            return new HashMap<>();
        }
    }
}