package org.example;

public class Queen extends ChessPiece{

    public Queen(String color) {
        super(color);
    }

    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        }

        if (toLine == line || toColumn == column) {
            if (toLine == line) {
                int startColumn = Math.min(column, toColumn);
                int endColumn = Math.max(column, toColumn);

                for (int i = startColumn + 1; i < endColumn; i++) {
                    if (chessBoard.board[line][i] != null) {
                        return false;
                    }
                }
            } else {
                int startLine = Math.min(line, toLine);
                int endLine = Math.max(line, toLine);

                for (int i = startLine + 1; i < endLine; i++) {
                    if (chessBoard.board[i][column] != null) {
                        return false;
                    }
                }
            }

            return true;
        } else if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {
            int startLine = Math.min(line, toLine);
            int startColumn = Math.min(column, toColumn);
            int endLine = Math.max(line, toLine);
            int endColumn = Math.max(column, toColumn);

            if (toLine > line && toColumn > column) {
                for (int i = 1; i < toLine - line; i++) {
                    if (chessBoard.board[line + i][column + i] != null) {
                        return false;
                    }
                }
            } else if (toLine > line && toColumn < column) {
                for (int i = 1; i < toLine - line; i++) {
                    if (chessBoard.board[line + i][column - i] != null) {
                        return false;
                    }
                }
            }

            return true;
        }

        return false;
    }
    @Override
    public String getSymbol() {
        return "Q";
    }
}
