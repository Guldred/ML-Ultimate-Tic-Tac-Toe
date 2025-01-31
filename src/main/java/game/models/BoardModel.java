package game.models;

public class BoardModel {
    public final SubBoardModel[] subBoards = new SubBoardModel[9];

    public BoardModel() {
        for (int i = 0; i < 9; i++) {
            this.subBoards[i] = new SubBoardModel();
        }
    }
}
