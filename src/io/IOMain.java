package io;

import map.treeMap.AverageStudentGrade;
import map.treeMap.SubjectGrade;
import map.treeMap.TreeMapRunner;

import java.io.*;
import java.util.*;

public class IOMain {

    public static final String FILE_NAME = "GradeBook.txt";
    public static final String BINARY_FILE = "Students.bin";
    public static final String BUFFERED_FILE = "Buffered.bin";

    public static void main(String[] args) throws IOException {
        SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades = TreeMapRunner.createGrades();
        Reader reader = new Reader();
        Writter writter = new Writter();
        writter.writeFile(grades, FILE_NAME);
//        reader.readFile(FILE_NAME);
//        writter.writeWithFormatter();
//        processGrades(grades, writter, BINARY_FILE);
//        outputObject(reader, BINARY_FILE);

//        System.out.println(System.getProperty("user.dir"));

        FileUtils utils  = new FileUtils();
//        utils.printIOFileDetails("./");
//        utils.printNioFileDetails(FILE_NAME);
//        reader.readFileInFull(FILE_NAME);
//        reader.nioReadFileWithBuffer(FILE_NAME);
//        writter.nioWriteWithBuffer(BUFFERED_FILE);
//        reader.nioReadWithStream(FILE_NAME);
//        writter.nioWriteWithStream(BUFFERED_FILE);
//        reader.nioReadWithChannel(FILE_NAME);
//        writter.nioWriteWithChannel(BUFFERED_FILE);
//        writter.writeWithRandomAccess(FILE_NAME);
//        System.out.println(Color.RED.getS());
        utils.processDir();
    }

    enum Color{
        RED("111"), BLUE("222"), GREEN("333");
        private final String s;

        Color(String s) {
            this.s = s;
        }
        public String getS(){
            return s;
        }
    }

    private static void processGrades(SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades,
                                      Writter writter, String fileName){
        List<Student> students = new ArrayList<>();
        for(AverageStudentGrade gradeKey: grades.keySet()){
            students.add(new Student(gradeKey.getName(), gradeKey.getAverageGrade(), grades.get(gradeKey)));
        }
        writter.writeObject(students, fileName);
    }

    private static void outputObject(Reader reader, String fileName){
        List<Student> students = reader.readObject(fileName);

        for (Student student: students){
            System.out.printf("%s, %.2f %n", student.getName(), student.getAverageGrade());
            System.out.println(student.getGrades());
        }
    }

}