package g58112.chess.model;

import g58112.chess.model.pieces.Pawn;
import g58112.chess.model.pieces.Piece;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mamou
 */
public class GameTest {

    public GameTest() {
    }

    /**
     * Test of getPiece method, of class Game.
     */
    @Test
    public void testGetPiece() {
        System.out.println("getPiece");
        Position pos = new Position(1, 5);
        Game game = new Game();
        game.start();
        Piece expResult = new Pawn(Color.WHITE);
        Piece result = game.getPiece(pos);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentPlayer method, of class Game.
     */
    @Test
    public void testGetCurrentPlayer() {
        System.out.println("getCurrentPlayer");
        Game instance = new Game();
        instance.start();
        Player expResult = new Player(Color.WHITE);
        Player result = instance.getCurrentPlayer();
        assertEquals(expResult, result);

    }

    /**
     * Test of getOppositePlayer method, of class Game.
     */
    @Test
    public void testGetOppositePlayer() {
        System.out.println("getOppositePlayer");
        Game instance = new Game();
        instance.start();
        Player expResult = new Player(Color.BLACK);
        Player result = instance.getOppositePlayer();
        assertEquals(expResult, result);
    }

    /**
     * Test of isCurrentPlayerPosition method, of class Game.
     */
    @Test
    public void testIsCurrentPlayerPosition() {
        System.out.println("isCurrentPlayerPosition");
        Position pos = new Position(6, 3);
        Game instance = new Game();
        instance.start();
        boolean expResult = false;
        boolean result = instance.isCurrentPlayerPosition(pos);
        assertEquals(expResult, result);
    }

    /**
     * Test of isGameOver method, of class Game.
     */
    @Test
    public void testIsGameOver() {
        System.out.println("isGameOver");
        Game instance = new Game();
        instance.start();
        boolean expResult = false;
        boolean result = instance.isGameOver();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPossibleMoves method, of class Game.
     */
    @Test
    public void testGetPossibleMoves() {
        System.out.println("getPossibleMoves");
        Position position = new Position(1, 6);
        Game instance = new Game();
        instance.start();
        List<Position> expResult = List.of(
                new Position(2, 6),
                new Position(3, 6)
        );
        List<Position> result = instance.getPossibleMoves(position);
        assertEqualsIgnoringOrder(expResult, result);

    }

    private void assertEqualsIgnoringOrder(List<Position> expected, List<Position> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(expected.containsAll(actual));

    }

}
