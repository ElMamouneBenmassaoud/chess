package g58112.chess.model;

/**
 * Class that represents the color of a player, space, or game piece
 *
 * @author 58112
 */
public enum Color {
    /**
     * White color
     */
    WHITE,
    /**
     * Black color
     */
    BLACK;

    /**
     * This method returns an opposite color of a given color
     *
     * @return This method returns an opposite color of a given color
     */
    public Color opposite() {
        if (this == WHITE) {
            return BLACK;
        }
        return WHITE;
    }
}
