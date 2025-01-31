package game.managers;

import game.models.BoardModel;
import game.models.FieldModel;
import game.models.Players;

public class WinStatusManager {

    private final BoardModel boardModel;

    public WinStatusManager(BoardModel boardModel) {
        this.boardModel = boardModel;
    }

    boolean checkSmallBoardWin(int boardIndex, Players player) {
        FieldModel[][] smallBoard = this.boardModel.subBoards[boardIndex].fields;
        for (int i = 0; i < 3; i++) {
            if ((smallBoard[i][0].occupiedBy == player && smallBoard[i][1].occupiedBy == player && smallBoard[i][2].occupiedBy == player) ||
                    (smallBoard[0][i].occupiedBy == player && smallBoard[1][i].occupiedBy == player && smallBoard[2][i].occupiedBy == player)) {
                return true;
            }
        }
        return (smallBoard[0][0].occupiedBy == player && smallBoard[1][1].occupiedBy == player && smallBoard[2][2].occupiedBy == player) ||
                (smallBoard[0][2].occupiedBy == player && smallBoard[1][1].occupiedBy == player && smallBoard[2][0].occupiedBy == player);
    }

    public boolean checkBigBoardWin() {
        for (int i = 0; i < 3; i++) {
            if ((this.boardModel.subBoards[i * 3].winner != Players.NONE && this.boardModel.subBoards[i * 3].winner == this.boardModel.subBoards[i * 3 + 1].winner && this.boardModel.subBoards[i * 3].winner == this.boardModel.subBoards[i * 3 + 2].winner) ||
                    (this.boardModel.subBoards[i].winner != Players.NONE && this.boardModel.subBoards[i].winner == this.boardModel.subBoards[i + 3].winner && this.boardModel.subBoards[i].winner == this.boardModel.subBoards[i + 6].winner)) {
                return true;
            }
        }
        return (this.boardModel.subBoards[0].winner != Players.NONE && this.boardModel.subBoards[0].winner == this.boardModel.subBoards[4].winner && this.boardModel.subBoards[0].winner == this.boardModel.subBoards[8].winner) ||
                (this.boardModel.subBoards[2].winner != Players.NONE && this.boardModel.subBoards[2].winner == this.boardModel.subBoards[4].winner && this.boardModel.subBoards[2].winner == this.boardModel.subBoards[6].winner);
    }
}
