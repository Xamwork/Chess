package org.example;

import java.util.SplittableRandom;

public class Rook extends ChessPiece{

    public Rook(String color) {
        super(color);
    }

    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
                if (toLine == line) {
                    if (toColumn > column) {
                        for (int i = column + 1; i < toColumn; i++) {
                            if (chessBoard.board[line][i] != null) {
                                return false;
                            }
                        }
                        return true;
                    } else if (toColumn < column) {
                        for (int i = column - 1; i > toColumn; i--) {
                            if (chessBoard.board[line][i] != null) {
                                return false;
                            }
                        }
                        return true;
                    } else return false;
                } else if (toColumn == column) {
                    if (toLine > line) {
                        for (int i = line + 1; i < toLine; i++) {
                            if (chessBoard.board[i][column] != null) {
                                return false;
                            }
                        }
                        return true;
                    } else if (toLine < line) {
                        for (int i = line - 1; i > toLine; i--) {
                            if (chessBoard.board[i][column] != null) {
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
        return "R";
    }
}
