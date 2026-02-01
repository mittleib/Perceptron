import java.util.Scanner;

public class MatrixMath {
    public double[][] createMatrix() {
        Scanner input = new Scanner(System.in);
        int numberOfRows;
        int numberOfColumns;
        double[][] matrix;
        System.out.print("Enter number of rows: ");
        numberOfRows = input.nextInt();
        System.out.print("Enter number of columns: ");
        numberOfColumns = input.nextInt();
        matrix = new double[numberOfRows][numberOfColumns];
        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            System.out.print("In form {1 2 3}, enter row " + (rowIndex + 1) + ": ");
            for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                matrix[rowIndex][columnIndex] = input.nextDouble();
            }
        }
        input.close();
        return matrix;
    }

    // Takes a matrix and converts it to a print-ready String object
    public String printMatrix(double[][] matrixToPrint) {
        String matrixString = "";
        if (matrixToPrint != null) {
            int numberOfGivenRows = matrixToPrint.length;
            int numberOfGivenColumns = matrixToPrint[0].length;
            if (numberOfGivenRows != 0 && numberOfGivenColumns != 0) {
                for (int rowIndex = 0; rowIndex < matrixToPrint.length; rowIndex++) {
                    matrixString += "\n";
                    for (int columnIndex = 0; columnIndex < matrixToPrint[0].length; columnIndex++) {
                        matrixString += matrixToPrint[rowIndex][columnIndex] + "\t";
                    }
                }
            }
        }
        return matrixString;
    }

    // Takes two matrices and makes a new one from Gaussian Elimination
    public double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {

    }

    public void reduceMatrix(double[][] matrix) {

    }

    private void interchangeRows(double[][] matrix, int row1, int row2) {

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MatrixMath computer = new MatrixMath();
        System.out.println("This is a program to calculate matrix math.");

        double[][] matrix1 = computer.createMatrix();
        System.out.println(computer.printMatrix(matrix1));

        double[][] matrix2 = computer.createMatrix();
        System.out.println(computer.printMatrix(matrix2));

        double[][] matrix3 = computer.multiplyMatrices(matrix1, matrix2);
        System.out.println(computer.printMatrix(matrix3));


        input.close();
    }
}