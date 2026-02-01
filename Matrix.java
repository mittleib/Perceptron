import java.util.Scanner;

public class Matrix {
    public double[][] createMatrix() {
        Scanner input = new Scanner(System.in);
        int numberOfRows;
        int numberOfColumns;
        double[][] matrix;
        System.out.print("Enter number of rows: ");
        numberOfRows = input.nextInt();
        System.out.print("\nEnter number of columns: ");
        numberOfColumns = input.nextInt();
        input.close();
        matrix = new double[numberOfRows][numberOfColumns];
        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            System.out.print("\nIn form {1 2 3}, enter row " + (rowIndex + 1) + ": ");
            for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                matrix[rowIndex][columnIndex] = input.nextDouble();
            }
        }
        return matrix;
    }

    public String printMatrix(double[][] matrixToPrint) {
        //for (in)
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This is a program to calculate matrix math.");
        System.out.println("1.23\t2\t1.343\t\t32\t1");
        System.out.println("1\t2.34\t0.0000\t535\t04\t3");
        input.close();
    }
}