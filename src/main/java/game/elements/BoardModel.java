package game.elements;

import game.system.BoardStatus;

public class BoardModel {
    public final char[][][] board = new char[9][3][3];
    public final char[] bigBoard = new char[9];
    public final BoardStatus[] boardStatus = new BoardStatus[9];
}
