package game.models;

public enum Players {
    X, O, NONE;

    @Override
    public String toString() {
        return switch (this) {
            case X -> "X";
            case O -> "O";
            default -> " ";
        };
    }
}
