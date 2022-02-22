import java.util.Scanner;

public class Tic_Tak_Toe {

    public static void main(String[] args) {

        int[] matrix = new int[9];
        printMatrix(matrix);
        int count = -1;
        boolean finish = false;

        while (!finish) {

            count++;
            int n = motion(matrix, count);
            printMatrix(matrix);

            if (count >= 4) {
                finish = game(matrix, n);
            }

            if (count >= 8) {
                if (conclusion(matrix)) {
                    System.out.println("\nDrawn game!");
                    break;
                }
            }
        }
        if (finish)
            System.out.println("\nThe winner is " + (count % 2 != 0 ? "X" : "O"));
    }

    static void printMatrix(int[] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            if (i % 3 == 0)
                System.out.println();
            if (matrix[i] == 1)
                System.out.print("X ");
            else if (matrix[i] == 2)
                System.out.print("O ");
            else
                System.out.print(i + " ");
        }
    }

    static int motion(int[] matrix, int count) {

        Scanner scan = new Scanner(System.in);
        int motion;

        if (count % 2 != 0) {
            System.out.println("\nX motion");
            motion = scan.nextInt();
            matrix[motion] = 1;
        } else {
            System.out.println("\nO motion");
            motion = scan.nextInt();
            matrix[motion] = 2;
        }

        return motion;
    }

    static boolean game(int[] matrix, int n) {

        int row = n - n % 3;//row
        if (matrix[row] == matrix[row + 1] && matrix[row] == matrix[row + 2]) return true;

        int col = n % 3;//column
        if (matrix[col] == matrix[col + 1] && matrix[col] == matrix[col + 2]) return true;

        if (n % 2 != 0) return false;//number is on edge

        if (n % 4 == 0) { //main diagonal
            if (matrix[0] == matrix[4] && matrix[0] == matrix[8])
                return true;
            if (n != 4) return false;//centre
        }
        return matrix[2] == matrix[4] && matrix[2] == matrix[6];//side diagonal
    }

    static boolean conclusion(int[] matrix) {

        for (int a : matrix)
            if (a == 0)
                return false;
        return true;
    }

}

