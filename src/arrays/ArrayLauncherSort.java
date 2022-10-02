package arrays;

import java.util.Scanner;

public class ArrayLauncherSort {
    public  static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myArray = new int[8];
        System.out.println("Please, enter 8 int elements:");
        for(int j = 0; j < myArray.length; j++) {
            System.out.println("Next element:");
            myArray[j] = scanner.nextInt();
        }
        int[] array = sortArray(myArray);
        for(int i = 0; i < myArray.length; i++) {
            System.out.println("Element #"+i+": "+myArray[i]);
        }
    }

    public static int[] sortArray (int[] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
