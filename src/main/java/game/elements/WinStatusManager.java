package game.elements;

import game.system.Players;

public class WinStatusManager {

    private final BoardModel boardModel;

    public WinStatusManager(BoardModel boardModel) {
        this.boardModel = boardModel;
    }

    boolean checkSmallBoardWin(int boardIndex, Players player) {
        char[][] smallBoard = this.boardModel.board[boardIndex];
        for (int i = 0; i < 3; i++) {
            if ((smallBoard[i][0] == player.toString().charAt(0) && smallBoard[i][1] == player.toString().charAt(0) && smallBoard[i][2] == player.toString().charAt(0)) ||
                    (smallBoard[0][i] == player.toString().charAt(0) && smallBoard[1][i] == player.toString().charAt(0) && smallBoard[2][i] == player.toString().charAt(0))) {
                return true;
            }
        }
        return (smallBoard[0][0] == player.toString().charAt(0) && smallBoard[1][1] == player.toString().charAt(0) && smallBoard[2][2] == player.toString().charAt(0)) ||
                (smallBoard[0][2] == player.toString().charAt(0) && smallBoard[1][1] == player.toString().charAt(0) && smallBoard[2][0] == player.toString().charAt(0));
    }

    public boolean checkBigBoardWin() {
        for (int i = 0; i < 3; i++) {
            if ((this.boardModel.bigBoard[i * 3] != ' ' && this.boardModel.bigBoard[i * 3] == this.boardModel.bigBoard[i * 3 + 1] && this.boardModel.bigBoard[i * 3] == this.boardModel.bigBoard[i * 3 + 2]) ||
                    (this.boardModel.bigBoard[i] != ' ' && this.boardModel.bigBoard[i] == this.boardModel.bigBoard[i + 3] && this.boardModel.bigBoard[i] == this.boardModel.bigBoard[i + 6])) {
                return true;
            }
        }
        return (this.boardModel.bigBoard[0] != ' ' && this.boardModel.bigBoard[0] == this.boardModel.bigBoard[4] && this.boardModel.bigBoard[0] == this.boardModel.bigBoard[8]) ||
                (this.boardModel.bigBoard[2] != ' ' && this.boardModel.bigBoard[2] == this.boardModel.bigBoard[4] && this.boardModel.bigBoard[2] == this.boardModel.bigBoard[6]);
    }
}
