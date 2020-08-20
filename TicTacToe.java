import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        /* gameboard should look something like this
        0 | 0 | 0
        - + - + -
        X | X | X
        - + - + -
        0 | 0 | 0
        */
        char[][] gameBoard = {
            {' ', '|', ' ', '|', ' '}, 
            {'-', '+', '-', '+', '-'}, 
            {' ', '|', ' ', '|', ' '}, 
            {'-', '+', '-', '+', '-'}, 
            {' ', '|', ' ', '|', ' '},
        };

        printGameBoard(gameBoard);

        Scanner scan = new Scanner(System.in);
        System.out.println("What is your move? (1-9)");
        int position = scan.nextInt();

        placePiece(gameBoard, position, "player");
        
        Random rand = new Random();
        int compPosition = rand.nextInt(9) + 1;
        placePiece(gameBoard, compPosition, "comp");

        printGameBoard(gameBoard);
    }

    public static void placePiece(char[][] gameBoard, int position, String user) {
        char piece = user.equals("player") ? 'X' : '0';
        switch(position) {
            case 1:
                gameBoard[0][0] = piece;
                break;
            case 2:
                gameBoard[0][2] = piece;
                break;
            case 3:
                gameBoard[0][4] = piece;
                break;
            case 4:
                gameBoard[2][0] = piece;
                break;
            case 5:
                gameBoard[2][2] = piece;
                break;
            case 6:
                gameBoard[2][4] = piece;
                break;
            case 7:
                gameBoard[4][0] = piece;
                break;
            case 8:
                gameBoard[4][2] = piece;
                break;
            case 9:
                gameBoard[4][4] = piece;
                break;
            default:
                break;
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        for(char[] row : gameBoard) {
            for(char c : row) {
                System.out.print(c);
            }
            System.out.println(' ');
        }
    }
}
