package game.models;

public class SubBoardModel {
    public final FieldModel[][] fields = new FieldModel[3][3];
    public BoardStatus boardStatus;
    public Players winner;

    public SubBoardModel() {
        this.boardStatus = BoardStatus.ACTIVE;
        this.winner = Players.NONE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.fields[i][j] = new FieldModel();
            }
        }
    }
}
