package org.example;

public class Horse extends ChessPiece{

    public Horse(String color) {
        super(color);
    }
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
                if (Math.abs(toLine - line) == 2 && Math.abs(toColumn - column) == 1) {
                    return true;
                } else if (Math.abs(toLine - line) == 1 && Math.abs(toColumn - column) == 2) {
                    return true;
                } else return false;
            } else return false;
        } else return false;
    }

    public String getSymbol() {
        return "H";
    }
}
