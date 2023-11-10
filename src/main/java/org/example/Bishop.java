package org.example;

public class Bishop extends ChessPiece{

    public Bishop(String color) {
        super(color);
    }

    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
                if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {
                    if (toLine > line && toColumn > column) {
                        for (int i = 1; i < toLine - line; i++) {
                            if (chessBoard.board[line + i][column + i] != null) {
                                return false;
                            }
                        }
                        return true;
                    } else if (toLine > line && toColumn < column) {
                        for (int i = 1; i < toLine - line; i++) {
                            if (chessBoard.board[line + i][column - i] != null) {
                                return false;
                            }
                        }
                        return true;
                    } else if (toLine < line && toColumn > column) {
                        for (int i = 1; i < line - toLine; i++) {
                            if (chessBoard.board[line - i][column + i] != null) {
                                return false;
                            }
                        }
                        return true;
                    } else if (toLine < line && toColumn < column) {
                        for (int i = 1; i < line - toLine; i++) {
                            if (chessBoard.board[line - i][column - i] != null) {
                                return false;
                            }
                        }
                        return true;
                    } else return false;
                } else return false;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
