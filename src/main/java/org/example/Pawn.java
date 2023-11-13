package org.example;

public class Pawn extends ChessPiece{

    public Pawn(String color) {
        super(color);
    }
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
                if (Math.abs(toLine - line)==1 && Math.abs(toColumn - column)==1) {
                    if (chessBoard.board[toLine][toColumn] != null) {
                        if (!chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
                            return true;
                        } else return false;
                    } else return false;
                }
                if (this.getColor().equals("White")) {
                    if (line == 1) {
                        if (toLine - line == 1 || toLine - line == 2) {
                            if (toColumn == column) {
                                if (toLine - line == 2) {
                                    if (chessBoard.board[line + 1][column] == null) {
                                        return true;
                                    } else return false;
                                } else return true;
                            } else return false;
                        } else return false;
                    } else {
                        if (toLine - line == 1) {
                            if (toColumn == column) {
                                return true;
                            } else return false;
                        } else return false;
                    }
                } else {
                    if (line == 6) {
                        if (line - toLine == 1 || line - toLine == 2) {
                            if (toColumn == column) {
                                if (line - toLine == 2) {
                                    if (chessBoard.board[line - 1][column] == null) {
                                        return true;
                                    } else return false;
                                } else return true;
                            } else return false;
                        } else return false;
                    } else {
                        if (line - toLine == 1) {
                            if (toColumn == column) {
                                return true;
                            } else return false;
                        } else return false;
                    }
                }
            }  else return false;
        } else return false;
        }

    public String getSymbol() {
        return "P";
    }
}
