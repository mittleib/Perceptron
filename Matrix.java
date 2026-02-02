import java.util.Scanner;

public class Matrix {
    private int numberOfRows;
    private int numberOfColumns;
    private double[][] matrix;

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int number) {
        numberOfRows = number;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public void setNumberOfColumns(int number) {
        numberOfColumns = number;
    }

    public void createMatrix() {
        Scanner input = new Scanner(System.in);
        matrix = new double[numberOfRows][numberOfColumns];
        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            System.out.print("In form 1 2 3 enter row " + (rowIndex + 1) + ": ");
            for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                matrix[rowIndex][columnIndex] = input.nextDouble();
            }
        }
        input.close();
    }

    // Tests whether the matrix is safe to work with
    private boolean matrixIsSafe() {
        if (matrix == null)
            return false;
        else if (numberOfRows == 0 || numberOfColumns == 0)
            return false;
        else
            return true;
    }

    // Returns a print-ready String version of the matrix
    public String toString() {
        String matrixString = "";
        if (matrixIsSafe()) {
            for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
                matrixString += "\n";
                for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                    matrixString += matrix[rowIndex][columnIndex] + "\t";
                }
            }
        }
        return matrixString;
    }

    // Takes two matrices
    public double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] product = new double[1][1];
        return product;
    }

    // Reduces the matrix to reduced row echelon form using Guassian Elimination
    public void reduce() {
        boolean matrixIsZero = false;
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                double value = matrix[row][column];
                // Interchange with first non-zero row (if possible)
                while (value == 0 && !matrixIsZero) {
                    int rowCheck = 0;
                    int newRow = row; // default value, should change
                    while (newRow == row && rowCheck < numberOfRows) {
                        if (rowCheck != row) {
                            if (matrix[rowCheck][column] != 0) {
                                newRow = rowCheck;
                            }
                        }
                        rowCheck++;
                    }
                    if (newRow != row)
                        interchangeRows(row,newRow);
                    else if (column < numberOfColumns - 1) // if we aren't on the last column
                        column++;
                    else
                        matrixIsZero = true; // all matrix values are zero
                    value = matrix[row][column];
                }
                for ()
            }
        }
    }

    public void interchangeRows(int firstRow, int secondRow) {
        if (numberOfRows > firstRow && numberOfRows > secondRow) {
            double[] temporaryRow = matrix[firstRow].clone();
            matrix[firstRow] = matrix[secondRow].clone();
            matrix[secondRow] = temporaryRow;
        }
        else
            System.out.println("Error: can't interchange, exceeds row limit.");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("This is a program to calculate matrix math.");

        Matrix matrix1 = new Matrix();
        System.out.print("Enter number of rows: ");
        matrix1.setNumberOfRows(input.nextInt());
        System.out.print("Enter number of columns: ");
        matrix1.setNumberOfColumns(input.nextInt());
        matrix1.createMatrix();

        System.out.println(matrix1.toString());
        matrix1.interchangeRows(0, 1);
        System.out.println(matrix1.toString());

        //double[][] matrix2 = computer.createMatrix();
        //System.out.println(computer.printMatrix(matrix2));

        //double[][] matrix3 = computer.multiplyMatrices(matrix1, matrix2);
        //System.out.println(computer.printMatrix(matrix3));


        input.close();
    }
}