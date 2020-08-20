import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> compPositions = new ArrayList<Integer>();

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

        while (checkWinner()) {
            Scanner scan = new Scanner(System.in);
            System.out.println("What is your move? (1-9)");
            int position = scan.nextInt();
    
            placePiece(gameBoard, position, "player");
            
            Random rand = new Random();
            int compPosition = rand.nextInt(9) + 1;
            placePiece(gameBoard, compPosition, "comp");
    
            printGameBoard(gameBoard);
        }

    }

    public static boolean checkWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List firstCol = Arrays.asList(1, 4, 7);
        List secondCol = Arrays.asList(2, 5, 8);
        List thirdCol = Arrays.asList(3, 6, 9);
        List leftDiag = Arrays.asList(1, 5, 9);
        List rightDiag = Arrays.asList(3, 5, 7);

        List<List> wins = new ArrayList<List>();
        wins.add(topRow);
        wins.add(midRow);
        wins.add(bottomRow);
        wins.add(firstCol);
        wins.add(secondCol);
        wins.add(thirdCol);
        wins.add(leftDiag);
        wins.add(rightDiag);

        for (List l : wins) {
            if (playerPositions.containsAll(l)) {
                System.out.println("You win! :^)");
                return false;
            } else if (compPositions.containsAll(l)) {
                System.out.println("Computer wins :(");
                return false;
            } else if (playerPositions.size() + compPositions.size() == 9) {
                System.out.println("Its a draw!");
                return false;
            }
        }

        return true;
    }

    public static void placePiece(char[][] gameBoard, int position, String user) {
        char piece = user.equals("player") ? 'X' : '0';
        if (user.equals("player")) {
            playerPositions.add(position);
        } else {
            compPositions.add(position);
        }
        switch(position) {
            case 1:
                gameBoard[0][0] = gameBoard[0][0] == ' ' ? piece : gameBoard[0][0];
                break;
            case 2:
                gameBoard[0][2] = gameBoard[0][2] == ' ' ? piece : gameBoard[0][2];
                break;
            case 3:
                gameBoard[0][4] = gameBoard[0][4] == ' ' ? piece : gameBoard[0][4];
                break;
            case 4:
                gameBoard[2][0] = gameBoard[2][0] == ' ' ? piece : gameBoard[2][0];
                break;
            case 5:
                gameBoard[2][2] = gameBoard[2][2] == ' ' ? piece : gameBoard[2][2];
                break;
            case 6:
                gameBoard[2][4] = gameBoard[2][4] == ' ' ? piece : gameBoard[2][4];
                break;
            case 7:
                gameBoard[4][0] = gameBoard[4][0] == ' ' ? piece : gameBoard[4][0];
                break;
            case 8:
                gameBoard[4][2] = gameBoard[4][2] == ' ' ? piece : gameBoard[4][2];
                break;
            case 9:
                gameBoard[4][4] = gameBoard[4][4] == ' ' ? piece : gameBoard[4][4];
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
