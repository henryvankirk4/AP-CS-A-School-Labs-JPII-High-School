// Lab04Kst.java
// The Knight's Tour Program
// This is the student, starting version of Lab04K.

import java.util.Scanner;


public class Lab04Kst {
    public static void main(String args[]) {
        heading();
        Knight knight = new Knight();
        knight.solveTour();
        knight.displayBoard();
    }

    public static void heading() {
        System.out.println("*************************");
        System.out.println("Lab for Unit 4, Lesson K");
        System.out.println("80 Point Version");
        System.out.println("By: John Smith");   // Substitute your own name here.
        System.out.println("*************************\n");
    }
}


class Knight {
    private int board[][];    // stores the sequence of knight moves
    private int startRow;    // row location where the knight starts
    private int startCol;    // col location where the knight starts
    private int currentRow;    // current row position of the knight
    private int currentCol;    // current col position of the knight
    private int moves;        // number of cells visited by the knight

    // access matrix to determine best possible move
    final private int ACCESS[][] = {{2, 3, 4, 4, 4, 4, 3, 2},
                                    {3, 4, 6, 6, 6, 6, 4, 3},
                                    {4, 6, 8, 8, 8, 8, 6, 4},
                                    {4, 6, 8, 8, 8, 8, 6, 4},
                                    {4, 6, 8, 8, 8, 8, 6, 4},
                                    {4, 6, 8, 8, 8, 8, 6, 4},
                                    {3, 4, 6, 6, 6, 6, 4, 3},
                                    {2, 3, 4, 4, 4, 4, 3, 2}};

    public Knight() {
        //Sets board to all zeros
        board = new int[8][8];
        for (int r = 0; r < 8; r++)
            for (int c = 0; c < 8; c++)
                board[r][c] = 0;
        getStart();
        currentRow = startRow;
        currentCol = startCol;
        moves = 1;
    }

    private void getStart() {
        Scanner input = new Scanner(System.in);
        startRow = startCol = -1;
        while (startRow < 0 || startRow > 7) {
            System.out.print("Enter starting row.     {0-7}  -->  ");
            startRow = input.nextInt();
        }
        while (startCol < 0 || startCol > 7) {
            System.out.print("Enter starting column.  {0-7}  -->  ");
            startCol = input.nextInt();
        }
    }

    /**
     * This method displays the chess board after
     * the Knight's Tour is concluded.
     */
    public void displayBoard() {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                System.out.printf(" %2d", board[r][c]);
            }
            System.out.println();
        }
        System.out.println("\nThe knight made " + moves + " moves.");

    }

    /**
     * This method returns <true> if the cell coordinate specified
     * by parameters <row> and <col> is inside the bounds of the
     * chess board.  Otherwise, it returns <false>.
     */
    private boolean inBoard(int row, int col) {
        return (row >= 0 &&
                row <= 7 &&
                col >= 0 &&
                col <= 7);
    }

    /**
     * Computes the next available knight's move.
     * If a move is possible, the method updates <currentRow>
     * and <currentCol> and then returns <true>.  If a move is
     * not possible, the method updates nothing and returns <false>.
     */
    private boolean getMove() { //Moves the knight and then returns true if moved, returns false if no more moves
        int[][] moves = {{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1}};
        int leastAccess = 10;
        int bestMove = -1;
        for (int i = 0; i < moves.length; i++) {
            int[] move = moves[i];

            int newRow = currentRow + move[0];
            int newCol = currentCol + move[1];


            if (inBoard(newRow, newCol) &&
                board[newRow][newCol] == 0 &&
                ACCESS[newRow][newCol] < leastAccess) {
                leastAccess = ACCESS[newRow][newCol];
                bestMove = i;
            }
        }
        //Check if it is a valid move, if so, make move and return true, if not, return false
        if (bestMove >= 0) {
            currentRow = currentRow + moves[bestMove][0];
            currentCol = currentCol + moves[bestMove][1];
            return true;
        }
        return false;
    }

    /**
     * This is the primary method that drives the Knight's Tour solution.
     */
    public void solveTour() {
        boolean moved = false;
        boolean done = false;
        board[startRow][startCol] = 1;

        while (!done) {
            moved = getMove();
            if (moved) {
                moves++;
                board[currentRow][currentCol] = moves;
            } else
                done = true;
        }
    }
}