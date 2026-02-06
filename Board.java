package com.fondeur;
import java.util.Scanner;
    /*
     * An interactive program that allows two humans to play against each other.
     * Player X always goes first, and moves for the 3x3 format are entered using an integer regarding the row first, then the column.
     * Entered coordinates use one-based indexing (ex: player enters row=1 and column=1, this corresponds to the space in the top-left corner of the board)
     * After 9 moves, if there is no winner, the game ends in a draw.
     * 
     * @author Brandon Fondeur
     */
public class Board 
{
    private int moveNumber;
    private char[][] board;
    
    /*
     * Default Constructor
     * Initializes the board to a 3x3 array of characters
     * and initializes the moveNumber to 0
     */
    public Board() 
    {
        moveNumber = 0;
        board = new char[3][3];
        for(int i = 0; i < 3; i++)
        {
            for(int z = 0; z < 3; z++)
            {
                board[i][z] = ' ';
            }
        }
    }
    /*
     * Prints the board in a neat, consistent format
     * 
     */
    public void display()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int z = 0; z < 3; z++)
            {
                if(z == 2)
                {
                    System.out.print(board[i][z]);
                }
                else
                {
                    System.out.print(board[i][z] + "|"); 
                }
            }
            if(i != 2)
            {
                System.out.println("\n_____");
            }
        }
    }
    /*
     * Updates the board with a new character, given a row and column to place the character
     * @param int row   Row on the Board to enter character
     * @param int col   Column on the Board to enter character
     * @return a boolean that states whether or not the move made is legal
     */
    public boolean makeMove(int row, int col)
    {
        boolean output = false;
        if(row < 3 && col < 3)
        {
            if(board[row][col] == ' ')
            {
                board[row][col] = currentPlayer();
                moveNumber += 1;
                return output = true;
                
            }
            else
            {
                return output;
            }
        }
        else
        {
            return output;
        }
    }
    /*
     * Returns the character corresponding to the current player
     * @return a char that indicates the current player
     */
    public char currentPlayer()
    {
        if(moveNumber%2 == 0)
        {
            return 'X';
        }
        else
        {
            return 'O';
        }
    }
    /*
     * Validates whether or not a player has won the game.
     * A player wins the game if three of their characters appear in-a-row, either horizontally, vertically or diagonally.
     * @return a char that indicates the player that won (X or O), or in the event of a draw, a '-'
     */
    public char checkWin()
    {
        for(int i = 0; i<3; i++)
        {
            if(board[i][0] != ' ')
            {
                if(board[i][0] == board[i][1] && board[i][0] == board[i][2])
                {
                    return board[i][0];
                }
            }
            if(board[0][i] != ' ')
            {
                if(board[0][i] == board[1][i] && board[0][i] == board[2][i])
                {
                    return board[0][i];
                }
            }
        }
        if(board[0][0] != ' ')
        {
            if(board[0][0] == board[1][1] && board[0][0] == board[2][2])
            {
                return board[0][0];
            }
        }
        if(board[0][2] != ' ')
        {
            if(board[0][2] == board[1][1] && board[0][2] == board[2][0])
            {
                return board[0][2];
            }
        }
        return '-';
    }
    /*
     * Returns the current moveNumber
     * @return an int that indicates the current move number.
     */
    public int getMoveNumber()
    {
        return moveNumber;
    }
    /*
     * An interactive program that allows two humans to play against each other.
     * Player X always goes first, and moves for the 3x3 format are entered using an integer regarding the row first, then the column.
     * After 9 moves, if there is no winner, the game ends in a draw.
     */
    public static void main(String[] args) {
        Board gameBoard = new Board();
        Scanner scan = new Scanner(System.in);
        boolean gameOver = false;
        System.out.println("Welcome to TicTacToe!\n");
        while(gameOver == false)
        {
            System.out.println("\nPlease enter the row you would like to enter " + gameBoard.currentPlayer());
            int x = scan.nextInt() - 1;
            scan.nextLine();
            System.out.println("Please enter the column you would like to enter " + gameBoard.currentPlayer());
            int y = scan.nextInt() - 1;
            scan.nextLine();
            boolean moveValid = gameBoard.makeMove(x,y);
            while(moveValid == false)
            {
                System.out.println("Incorrect coordinates, please reenter.");
                System.out.println("\nPlease enter the row you would like to enter " + gameBoard.currentPlayer());
                x = scan.nextInt() - 1;
                scan.nextLine();
                System.out.println("Please enter the column you would like to enter " + gameBoard.currentPlayer());
                y = scan.nextInt() - 1;
                scan.nextLine();
                moveValid = gameBoard.makeMove(x,y);
            }
            gameBoard.display();
            if(gameBoard.getMoveNumber() >= 9)
            {
                gameOver = true;
            }
            if(gameBoard.checkWin() == 'X' || gameBoard.checkWin() == 'O')
            {
                gameOver = true;
            }
        }
        if(gameBoard.checkWin() == '-')
        {
            System.out.println("\nDRAW!");
        }
        else
        {
            System.out.println("\n" + gameBoard.checkWin() + " WINS!!!!!");
        }
        System.out.println("\nThank you for playing!");
        
        
    }
}