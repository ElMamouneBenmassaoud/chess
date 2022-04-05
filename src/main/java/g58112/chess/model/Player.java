package g58112.chess.model;

import java.util.Objects;

/**
 * this class represent a player and his color
 *
 * @author g58112
 */
public class Player {

    private Color color;

    /**
     * The constructor will initialize a new player of given color
     *
     * @param color colorplayer's
     */
    public Player(Color color) {
        this.color = color;
    }

    /**
     * the color of the player that matches the color of his pieces.
     *
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.color);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.color != other.color) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Player{" + "color=" + color + '}';
    }
}
