package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public void readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String c;
        while ((c = reader.readLine()) != null){
            System.out.println(c);
        }
    }

    public List<Student> readObject(String fileName){
        List<Student> students = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            boolean keepReading = true;

            while (keepReading){
                Student student = (Student) in.readObject();
                if(!"".equals(student.getName())){
                    students.add(student);
                } else {
                    keepReading = false;
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to open file " + fileName + ". Program terminates.");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Invalid object type.");
            throw new RuntimeException(e);
        }
        return students;
    }

}
