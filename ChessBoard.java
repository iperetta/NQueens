import java.util.ArrayList;

public class ChessBoard {
    private Integer side;
    private ArrayList<Queen> population;
    public ChessBoard(Integer side) {
        this.side = side;
        this.population = new ArrayList<Queen>(side);
        for(int i = 0; i < this.side; i++) {
            this.population.add(new Queen(i, this, 
                (i == 0) ? null : this.population.get(i-1)));
        }
    }
    public Integer getSide() {
        return side;
    }
    
    public void solve() {
        for(int i = 1; i < this.side; i++)
            this.population.get(i).findSolution();
    }

    // For the user --------------------------------------------------
    private boolean isThereAQueen(int i, int j) {
        for(int a = 0; a < this.side; a++) {
            if(this.population.get(a).row == this.side-i-1
                && this.population.get(a).col == j) 
                return true;
        }
        return false;
    }

    public void show() {
        // System.out.println("-----------------------------------");
        for(int i = 0; i < this.side; i++) {
            if((this.side - i) < 10) System.out.print(" ");
            System.out.print((this.side - i) + " |");
            for(int j = 0; j < this.side; j++) {
                if(this.isThereAQueen(i,j))
                    System.out.print(" ♛ |");
                else
                    System.out.print("   |");
            }
            System.out.println("");
            // System.out.println("\n-----------------------------------");
        }
        System.out.print("    ");
        for(int i = 0; i < this.side; i++)
            System.out.print(" " + (char)(97+i) + "  ");
        System.out.println("");
    }
}