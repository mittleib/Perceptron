import java.util.Scanner;

public class Matrix {
    private final String RESET = "\u001B[0m";
    private final String RED_BACKGROUND = "\u001B[41m";

    private int numberOfRows;
    private int numberOfColumns;
    private double[][] matrix;

    public Matrix() {
        numberOfRows = 0;
        numberOfColumns = 0;
        createMatrix();
    }

    public Matrix(int totalRows, int totalColumns) {
        numberOfRows = totalRows;
        numberOfColumns = totalColumns;
        createMatrix();
    }

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

    private void createMatrix() {
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
    @Override
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
        boolean matrixIsDone = false;
        int row = 0;
        int column = 0;
        while (!matrixIsDone) {
            // Define "value"
            double value = matrix[row][column];

            // Step 1: Interchange row with first non-zero row if "value" == 0
            while (value == 0 && !matrixIsDone) {
                int rowCheck = row + 1;
                int newRow = row; // default value, should change
                while (newRow == row && rowCheck < numberOfRows) {
                    if (matrix[rowCheck][column] != 0) {
                        newRow = rowCheck;
                    }
                    rowCheck++;
                }
                if (newRow != row)
                    interchangeRows(row,newRow);
                else if (column < numberOfColumns - 1) // if we aren't on the last column
                    column++;
                else
                    matrixIsDone = true;
                value = matrix[row][column];
            }
            if (!matrixIsDone) {
                // Step 2: Multiply row values by same coefficient to make "value" 1
                if (value != 1 && value != 0) {
                    double coefficient = 1 / value;
                    for (int columnCheck = column; columnCheck < numberOfColumns; columnCheck++) {
                        matrix[row][columnCheck] = matrix[row][columnCheck] * coefficient;
                    }
                }

                // Step 3: Make cooresponding values of other rows 0 around "value"
                //         by subtracting multiples of this row's values to other rows' values
                for (int rowCheck = 0; rowCheck < numberOfRows; rowCheck++) {
                    if (rowCheck != row) {
                        double coefficient = matrix[rowCheck][column] / matrix[row][column];
                        for (int columnCheck = column; columnCheck < numberOfColumns; columnCheck++) {
                            double thisRowValue = matrix[row][columnCheck];
                            double otherRowValue = matrix[rowCheck][columnCheck];
                            matrix[rowCheck][columnCheck] = otherRowValue - coefficient * thisRowValue;
                        }
                    }
                }

                row++;
                column++;
                if (row >= numberOfRows || column >= numberOfColumns)
                    matrixIsDone = true;
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

    public void solve() {
        // Solutions:
        // {1,1,0,6,0} 1x1 + 1x2 + 0x3 + 6x4 + 0x5
        // {0,0,1,2,0} 0x1 + 0x2 + 1x3 + 2x4 + 0x5
        // {0,0,0,1,1} 0x1 + 0x2 + 0x3 + 1x4 + 1x5
        // {0,0,0,0,0} 0x1 + 0x2 + 0x3 + 0x4 + 0x5
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("This is a program to calculate matrix math.");

        //Matrix matrix1 = new Matrix(4, 6);
        
        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = input.nextInt();
        Matrix matrix1 = new Matrix(rows, columns);
        
        matrix1.reduce();
        System.out.println(matrix1.toString());

        //double[][] matrix2 = computer.createMatrix();
        //System.out.println(computer.printMatrix(matrix2));

        //double[][] matrix3 = computer.multiplyMatrices(matrix1, matrix2);
        //System.out.println(computer.printMatrix(matrix3));


        input.close();
    }
}