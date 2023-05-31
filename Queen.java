public class Queen {
    Integer col, row;
    ChessBoard board;
    Queen neighbour;
    public Queen(Integer col, ChessBoard board, 
                 Queen neighbour) {
        this.col = col;
        this.row = 0;
        this.board = board;
        this.neighbour = neighbour;
    }
    public String toString(){
        return "Queen#" + this.col;
    }
    public Boolean move() { // going up 
        if(this.row + 1 < this.board.getSide()) {
            this.row += 1;
            return this.findSolution();
        }
        if(!(this.neighbour == null)){
            if(!this.neighbour.move())
                return false;
        }
        this.row = 0;
        return this.findSolution();
    }
    public Boolean canAttack(Integer row, Integer col) {
        if(this.row == row)
            return true;
        if(this.col + this.row == col + row || 
            this.col - this.row == col - row)
            return true;
        if(!(this.neighbour == null))
            return this.neighbour.canAttack(row, col);
        return false;
    }
    public Boolean findSolution() {
        if(!(this.neighbour == null)){
            while(this.neighbour.canAttack(this.row, this.col)) {
                if(!this.move())
                    return false;
            }
        }
        return true;
    }
}
