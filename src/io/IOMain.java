package io;

import map.treeMap.AverageStudentGrade;
import map.treeMap.SubjectGrade;
import map.treeMap.TreeMapRunner;

import java.io.*;
import java.util.*;

public class IOMain {

    public static final String FILE_NAME = "GradeBook.txt";

    public static void main(String[] args) throws IOException {
        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades = TreeMapRunner.createGrades();
//        writeFile(grades);
//        writeFile();

        Formatter formatter = new Formatter("BankAccounts.txt");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter clientId, clientName, clientSurname, clientBalance:");
        int i = 0;
        while (i < 3){
            try{
                formatter.format("%d, %s, %s, %f%n",
                        scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextFloat());
                i++;
            } catch (InputMismatchException e){
                System.out.println("Input is incorrect. Please try again");
                scanner.nextLine();
            }
        }
        formatter.close();
    }

    private static void writeFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        String c;
        while ((c = reader.readLine()) != null){
            System.out.println(c);
        }
    }

    private static void writeFile(NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))){
            for (AverageStudentGrade gradeKey : grades.keySet()) {
                writer.write("------------------------------------\n");
                writer.write("Student: " + gradeKey.getName() + " Average grade: " +
                        gradeKey.getAverageGrade() + "\n");
                for (SubjectGrade grade : grades.get(gradeKey)) {
                    writer.write("Subject: " + grade.getSubject() + " Grade: " + grade.getGrade() + "\n");
                }
            }
        }
    }
}