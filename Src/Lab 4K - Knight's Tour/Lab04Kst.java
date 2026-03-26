// Lab04Kst.java
// The Knight's Tour Program
// This is the student, starting version of Lab04K.

import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Lab04Kst {
    public static void main(String args[]) {
        heading();
        Knight knight = new Knight();
        knight.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        knight.setSize(822,848);
        knight.setVisible(true);
        knight.solveTour();
        knight.displayMoves();
    }

    public static void heading() {
        System.out.println("*************************");
        System.out.println("Lab for Unit 4, Lesson K");
        System.out.println("110 Point Version");
        System.out.println("By: John Smith");   // Substitute your own name here.
        System.out.println("*************************\n");
    }
}


class Knight extends Frame{
    private int[][] board;    // stores the sequence of knight moves
    private int startRow;    // row location where the knight starts
    private int startCol;    // col location where the knight starts
    private int currentRow;    // current row position of the knight
    private int currentCol;    // current col position of the knight
    private int moves;        // number of cells visited by the knight

    // access matrix to determine best possible move
    private int[][] ACCESS = {{2, 3, 4, 4, 4, 4, 3, 2},
                                    {3, 4, 6, 6, 6, 6, 4, 3},
                                    {4, 6, 8, 8, 8, 8, 6, 4},
                                    {4, 6, 8, 8, 8, 8, 6, 4},
                                    {4, 6, 8, 8, 8, 8, 6, 4},
                                    {4, 6, 8, 8, 8, 8, 6, 4},
                                    {3, 4, 6, 6, 6, 6, 4, 3},
                                    {2, 3, 4, 4, 4, 4, 3, 2}};

    public Knight() {
        super("Knight's Tour");
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
        startRow = startCol = -1;
        while (startRow < 0 || startRow > 7) {
            String rowInput = JOptionPane.showInputDialog("Enter starting row. {0-7}");
            startRow = Integer.parseInt(rowInput);
        }
        while (startCol < 0 || startCol > 7) {
            String colInput = JOptionPane.showInputDialog("Enter starting column. {0-7}");
            startCol = Integer.parseInt(colInput);
        }
    }

    /**
     * This method displays the chess board after
     * the Knight's Tour is concluded.
     */
    public void displayMoves() {
        JOptionPane.showMessageDialog(null, "\nThe knight made " + moves + " moves.");
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
            //Lower Access values by one
            for (int[] move : moves) {
                int lowerAccessRow = currentRow + move[0];
                int lowerAccessColumn = currentCol + move[1];
                if (inBoard(lowerAccessRow, lowerAccessColumn)) {
                    ACCESS[lowerAccessRow][lowerAccessColumn]--;
                }

            }
            return true;
        }
        return false;
    }

    /**
     * This is the primary method that drives the Knight's Tour solution.
     */
    public void solveTour() {
        Graphics g = getGraphics();
        Graphics2D g2D = (Graphics2D) g;
        g2D.translate(11,34);

        boolean moved = false;
        boolean done = false;
        board[startRow][startCol] = 1;

        delay(1000);
        while (!done) {
            eraseKnight(g);
            moved = getMove();
            if (moved) {
                moves++;
                board[currentRow][currentCol] = moves;
                drawKnight(g);
                delay(100);
            } else
                done = true;
        }
    }
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.translate(11,34);

        //Draw Board
        for (int r = 100; r < 800; r += 100) {
            g.drawLine(r, 0, r, 800);
        }
        for (int c = 100; c < 800; c += 100) {
            g.drawLine(0, c, 800, c);
        }
        //Draw Knight
        drawKnight(g);
    }
    private void drawKnight(Graphics g) {
        g.fillOval(currentCol * 100 + 10, currentRow * 100 + 10, 80, 80);
    }
    private void eraseKnight(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(currentCol * 100 + 5, currentRow * 100 + 5, 90, 90);
        //Write move number on current cell
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.black);
        g.drawString(Integer.toString(board[currentRow][currentCol]), currentCol * 100 + 30, currentRow * 100 + 50);
    }
    private void delay(int ms) {
        double startDelay = System.currentTimeMillis();
        while (System.currentTimeMillis() - startDelay < ms);
    }
}