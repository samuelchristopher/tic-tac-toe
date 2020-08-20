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
