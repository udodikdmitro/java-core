package map.treeMap;

import java.util.*;

public class TreeMapRunner {

    public static void main(String[] args) {
        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades = createGrades();
        printGrades(grades, true);
    }

    private static void printGrades(Map<AverageStudentGrade, Set<SubjectGrade>> grades, boolean printValue){
        Set<AverageStudentGrade> averageGrades = grades.keySet();
        for(AverageStudentGrade gr: averageGrades){
            System.out.println(gr);
            if(printValue){
                System.out.println(grades.get(gr));
            }
        }
    }
    private static NavigableMap<AverageStudentGrade, Set<SubjectGrade>> createGrades(){
        Set<SubjectGrade> alexGrades = new HashSet<>();
        alexGrades.add(new SubjectGrade("Mathematics", 89));
        alexGrades.add(new SubjectGrade("Physics", 65));
        alexGrades.add(new SubjectGrade("History", 95));
        alexGrades.add(new SubjectGrade("Literature", 90));
        alexGrades.add(new SubjectGrade("Chemistry", 75));

        Set<SubjectGrade> jamesGrades = new HashSet<>();
        alexGrades.add(new SubjectGrade("Mathematics", 75));
        alexGrades.add(new SubjectGrade("Physics", 80));
        alexGrades.add(new SubjectGrade("History", 55));
        alexGrades.add(new SubjectGrade("Literature", 70));
        alexGrades.add(new SubjectGrade("Chemistry", 80));

        Set<SubjectGrade> antonyGrades = new HashSet<>();
        alexGrades.add(new SubjectGrade("Mathematics", 93));
        alexGrades.add(new SubjectGrade("Physics", 91));
        alexGrades.add(new SubjectGrade("History", 82));
        alexGrades.add(new SubjectGrade("Literature", 78));
        alexGrades.add(new SubjectGrade("Chemistry", 80));

        Set<SubjectGrade> victoriaGrades = new HashSet<>();
        alexGrades.add(new SubjectGrade("Mathematics", 73));
        alexGrades.add(new SubjectGrade("Physics", 65));
        alexGrades.add(new SubjectGrade("History", 75));
        alexGrades.add(new SubjectGrade("Literature", 66));
        alexGrades.add(new SubjectGrade("Chemistry", 50));

        Set<SubjectGrade> alinaGrades = new HashSet<>();
        alexGrades.add(new SubjectGrade("Mathematics", 90));
        alexGrades.add(new SubjectGrade("Physics", 70));
        alexGrades.add(new SubjectGrade("History", 78));
        alexGrades.add(new SubjectGrade("Literature", 88));
        alexGrades.add(new SubjectGrade("Chemistry", 89));

        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> map = new TreeMap<>();
        map.put(new AverageStudentGrade("Alex", calcAverage(alexGrades)),alexGrades);
        map.put(new AverageStudentGrade("James", calcAverage(jamesGrades)),jamesGrades);
        map.put(new AverageStudentGrade("Antony", calcAverage(antonyGrades)),antonyGrades);
        map.put(new AverageStudentGrade("Victoria", calcAverage(victoriaGrades)),victoriaGrades);
        map.put(new AverageStudentGrade("Alina", calcAverage(alinaGrades)),alinaGrades);
        
        return map;
    }

    private static float calcAverage(Set<SubjectGrade> grades){
        float sum = 0f;
        for(SubjectGrade sg: grades){
            sum += sg.getGrade();
        }
        return sum / grades.size();
    }
}
