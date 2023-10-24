package edu.hw1;

public final class Task8 {

    private static final String INPUTERROR = "Введена некорректная доска!";
    private static final int LENGTH = 8;
    private static final int  UPPERBORDER = 7;
    private static final int  DOWNBORDER = 0;
    private static final int[][]  HORSEMOVEMENTS = {
            {1, 2},
            {2, 1},
            {1, -2},
            {2, -1},
            {-1, 2},
            {-2, 1},
            {-1, -2},
            {-2, -1},
    };

    private Task8() {
    }

    public static Boolean checkBoard(Integer[][] board) {
        if  ((board == null) || (board.length != LENGTH)) {
            return true;
        } else {
            for (int i = 0; i < LENGTH; i++) {
                if (board[i].length != LENGTH) {
                    return true;
                }
                for (int j = 0; j < LENGTH; j++) {
                    if ((board[i][j] == null) || !((board[i][j].equals(1)) || (board[i][j].equals(0)))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Boolean checkEnvironment(Integer xPosition, Integer yPosition, Integer[][] board) {
        for (int i = 0; i < LENGTH; i++) {
            int currentX = xPosition + HORSEMOVEMENTS[i][0];
            int currentY = yPosition + HORSEMOVEMENTS[i][1];
            if ((currentX >= DOWNBORDER) && (currentX <= UPPERBORDER)
                    && (currentY >= DOWNBORDER) && (currentY <= UPPERBORDER)) {
                if (board[currentX][currentY].equals(1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Boolean knightBoardCapture(Integer[][] enterBoard) {
        if (checkBoard(enterBoard)) {
            throw  new IllegalArgumentException(INPUTERROR);
        }
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                if (enterBoard[i][j].equals(1)) {
                    if (checkEnvironment(i, j, enterBoard)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
