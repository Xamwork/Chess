package org.example;

public class King extends ChessPiece{

    public King(String color) {
        super(color);
    }

    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
                if (Math.abs(toLine - line) == 1 && Math.abs(toColumn - column) == 1) {
                    return true;
                } else if (Math.abs(toLine - line) == 1 && toColumn == column) {
                    return true;
                } else if (Math.abs(toColumn - column) == 1 && toLine == line) {
                    return true;
                } else return false;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < board.board.length; i++) {
            for (int j = 0; j < board.board.length; j++) {
                if (board.board[i][j] != null) {
                    if (!board.board[i][j].getColor().equals(this.getColor())) {
                        if (board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
