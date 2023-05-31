import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Inform the side of the board: ");
        Scanner scanner = new Scanner(System.in);
        Integer side = scanner.nextInt();
        scanner.close();
        if(side == 2 || side == 3)
            System.out.println("There is no solution for that!");
        else {
            ChessBoard board = new ChessBoard(side);
            board.solve();
            board.show();
        }
    }
}
