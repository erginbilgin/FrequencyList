package tr.com.erginbilgin;

import java.util.Scanner;

/**
 * Calculating appearance frequency of integers in a list.
 * Written for interview process.
 *
 * @author  Ergin Bilgin
 * @version 1.0
 * @since   2018-10-08
 */

public class Main {

    /**
     * This is the main method which makes use of getArray
     * and frequencyOfArray methods.
     * @param args Unused.
     */
    public static void main(String[] args) {
        try {
            int[] array = getArray();
            frequencyOfArray(array);
        } catch (NumberFormatException exception) {
            System.out.println("NumberFormatException: " + exception.getMessage());
            System.out.println("Input is not a valid list.");
        }
    }


    /**
     * This method is used to read user input
     * and parse it into an integer array.
     * Input is split using delimiter ", ".
     * @return Returns an array of integers.
     */
    public static int[] getArray(){
        System.out.println("Enter list in format: '4, 2, 1, 5':");
        Scanner scanner = new Scanner(System.in);
        String array = scanner.nextLine();

        String[] integersAsText = array.split(", ");

        int[] integerArray = new int[integersAsText.length];

        for (int i = 0; i < integersAsText.length; i++){
            integerArray[i] = Integer.parseInt(integersAsText[i]);
        }

        return integerArray;
    }

    /**
     * This method is used to process an array
     * to find appearance frequencies.
     * @param array This is the input array.
     */
    public static void frequencyOfArray(int[] array){
        int maximum = arrayMax(array);
        int minimum = arrayMin(array);

        int[] numbers = new int[(maximum-minimum)+1];

        for (int i = minimum; i <= maximum; i++){
            numbers[i-minimum] = i;
        }

        int[] frequency = new int[(maximum-minimum)+1];

        for (int i = minimum; i <= maximum; i++){
            int count = 0;

            for (int j = 0; j < array.length; j++){
                if (array[j] == i){
                    count++;
                }
            }
            frequency[i-minimum] = count;
        }

        printArray("Frequency", frequency);
        printArray("Number", numbers);
        printGraph(numbers, frequency);

    }

    /**
     * This method is used to print integer arrays
     * in a representable format.
     * @param title This is the title for array.
     * @param array This is the array to print.
     */
    public static void printArray(String title, int[] array){
        int length = array.length;
        System.out.printf("%-10s:", title);
        for (int i = 0; i < length-1; i++){
            System.out.printf("%4d,",array[i]);
        }
        System.out.printf("%4d%n", array[length-1]);
    }

    /**
     * This method is used to print a graph
     * representation of frequency list.
     * @param numbers This is the numbers array.
     * @param frequency This is the frequency array.
     */
    public static void printGraph(int[] numbers, int[] frequency){
        int length = numbers.length;
        int maxFrequency = arrayMax(frequency);

        for (int i = maxFrequency; i > 0; i--){
            for (int j = 0; j < length; j++){
                if(frequency[j] >= i){
                    System.out.printf("%3s", "*");
                } else {
                    System.out.printf("%3s", " ");
                }
            }
            System.out.printf("%n");
        }

        for (int i = 0; i < length; i++){
            System.out.printf("%3d",numbers[i]);
        }
        System.out.printf("%n");
    }
    
    /**
     * This method is used to find minimum
     * in an array of integers.
     * @param array This is the input array.
     * @return Returns minimum integer in array.
     */
    public static int arrayMin(int[] array){
        int arrayMin = array[0];
        for (int i = 0; i < array.length; i++){

            if (array[i] < arrayMin){
                arrayMin = array[i];
            }
        }
        return arrayMin;
    }

    /**
     * This method is used to find maximum
     * in an array of integers.
     * @param array This is the input array.
     * @return Returns maximum integer in array.
     */
    public static int arrayMax(int[] array){
        int arrayMax = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] > arrayMax){
                arrayMax = array[i];
            }
        }
        return arrayMax;
    }
}
