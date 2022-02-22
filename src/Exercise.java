import java.util.Random;
import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Enter the size of array");
        int size = scan.nextInt();

        int[][] arr = new int[size][size];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                arr[i][j] = rand.nextInt(50);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] < 10)
                    System.out.print(arr[i][j] + "  ");
                else
                    System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        diagonalLength(arr);
        oddUnderMainDiagonal(arr);
        compDiagBigger(arr);
        sumOfSide(arr);
        transposition(arr);
    }

    static void diagonalLength(int[][] arr) {

        System.out.println("\nExercise1");
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i][i] % 2 == 0)
                sum += arr[i][i];
        }
        System.out.print("Sum = " + sum);
    }

    static void oddUnderMainDiagonal(int[][] arr) {

        System.out.println("\n\nExercise2");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[i][j] % 2 != 0)
                    System.out.print(arr[i][j] + " ");
            }
        }
    }

    static void compDiagBigger(int[][] arr) {

        System.out.println("\n\nExercise3");
        int comp1 = 1, comp2 = 1;

        for (int i = 0; i < arr.length; i++) {
            comp1 *= arr[i][i];
        }

        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            comp2 *= arr[i][j];
        }

        if (comp1 > comp2)
            System.out.print("Composition of elements of firs diagonal is bigger");
        else
            System.out.print("Composition of elements of second diagonal is bigger");
    }

    static void sumOfSide(int[][] arr) {

        System.out.println("\n\nExercise4");
        int sum = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 2 - i; j >= 0; j--) {
                if (arr[i][j] % 2 != 0)
                    sum += arr[i][j];
            }
        }
        System.out.println("Sum = " + sum);

    }

    static void transposition(int[][] arr) {

        System.out.println("\n\nExercise5");

        int[][] newArr = new int[arr[0].length][arr.length];

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                newArr[i][j] = arr[j][i];
            }
        }

        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[0].length; j++) {
                System.out.print(newArr[i][j]+" ");
            }
            System.out.println();
        }

    }

}
