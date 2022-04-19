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
    
    /**
     * Test of the Lion Mat.
     */
    @Test
    public void testLionMat() {
        System.out.println("testLionMat");
        Game instance = new Game();
        instance.start();
        
        instance.movePiecePosition(new Position(1, 6), new Position(3, 6));
        instance.movePiecePosition(new Position(6, 4), new Position(4, 4));
        instance.movePiecePosition(new Position(1, 5), new Position(2, 5));
        instance.movePiecePosition(new Position(7, 3), new Position(3, 7));
        
        GameState expGameState = GameState.CHECK_MATE;
        GameState result = instance.getState();
        assertEquals(expGameState, result);
    }
    
    /**
     * Test of the Check state.
     */
    @Test
    public void testCheckState() {
        System.out.println("testCheckState");
        Game instance = new Game();
        instance.start();
        
        instance.movePiecePosition(new Position(1, 4), new Position(3, 4));
        instance.movePiecePosition(new Position(6, 4), new Position(4, 4));
        instance.movePiecePosition(new Position(0, 5), new Position(3, 2));
        instance.movePiecePosition(new Position(6, 0), new Position(5, 0));
        instance.movePiecePosition(new Position(3, 2), new Position(6, 5));
        
        GameState expGameState = GameState.CHECK;
        GameState result = instance.getState();
        
        assertEquals(expGameState, result);
    }
    
    @Test
    public void testStaleMateState() {
        System.out.println("testStaleMate");
        Game instance = new Game();
        instance.start();
        
        instance.movePiecePosition(new Position(1, 4), new Position(3, 4));
        instance.movePiecePosition(new Position(6, 4), new Position(4, 4));
        instance.movePiecePosition(new Position(0, 6), new Position(2, 5));
        instance.movePiecePosition(new Position(7, 1), new Position(5, 2));
        instance.movePiecePosition(new Position(0, 1), new Position(2, 2));
        instance.movePiecePosition(new Position(7, 6), new Position(5, 5));
        instance.movePiecePosition(new Position(0, 5), new Position(4, 1));
        instance.movePiecePosition(new Position(7, 5), new Position(3, 1));
        instance.movePiecePosition(new Position(0, 4), new Position(1, 4));
        instance.movePiecePosition(new Position(7, 4), new Position(7, 5));
        instance.movePiecePosition(new Position(0, 7), new Position(0, 4));
        instance.movePiecePosition(new Position(7, 5), new Position(7, 4));
        instance.movePiecePosition(new Position(1, 4), new Position(0, 5));
        instance.movePiecePosition(new Position(7, 4), new Position(7, 5));
        instance.movePiecePosition(new Position(0, 5), new Position(0, 6));
        instance.movePiecePosition(new Position(7, 5), new Position(7, 4));
        instance.movePiecePosition(new Position(0, 4), new Position(0, 5));
        instance.movePiecePosition(new Position(7, 4), new Position(6, 4));
        instance.movePiecePosition(new Position(0, 5), new Position(0, 4));
        instance.movePiecePosition(new Position(7, 7), new Position(7, 4));
        instance.movePiecePosition(new Position(0, 4), new Position(0, 5));
        instance.movePiecePosition(new Position(6, 4), new Position(7, 5));
        instance.movePiecePosition(new Position(0, 5), new Position(0, 4));
        instance.movePiecePosition(new Position(7, 5), new Position(7, 6));
        instance.movePiecePosition(new Position(0, 4), new Position(0, 5));
        instance.movePiecePosition(new Position(7, 4), new Position(7, 5));
        instance.movePiecePosition(new Position(1, 3), new Position(2, 3));
        instance.movePiecePosition(new Position(6, 3), new Position(5, 3));
        instance.movePiecePosition(new Position(0, 2), new Position(4, 6));
        instance.movePiecePosition(new Position(3, 1), new Position(2, 2));
        instance.movePiecePosition(new Position(1, 1), new Position(2, 2));
        instance.movePiecePosition(new Position(7, 3), new Position(6, 4));
        instance.movePiecePosition(new Position(0, 5), new Position(0, 4));
        instance.movePiecePosition(new Position(5, 2), new Position(7, 3));
        instance.movePiecePosition(new Position(2, 3), new Position(3, 3));
        instance.movePiecePosition(new Position(6, 7), new Position(5, 7));
        instance.movePiecePosition(new Position(4, 6), new Position(0, 2));
        instance.movePiecePosition(new Position(6, 0), new Position(5, 0));
        instance.movePiecePosition(new Position(4, 1), new Position(2, 3));
        instance.movePiecePosition(new Position(7, 2), new Position(3, 6));
        instance.movePiecePosition(new Position(1, 7), new Position(2, 7));
        instance.movePiecePosition(new Position(3, 6), new Position(6, 3));
        instance.movePiecePosition(new Position(1, 0), new Position(3, 0));
        instance.movePiecePosition(new Position(5, 0), new Position(4, 0));
        instance.movePiecePosition(new Position(2, 5), new Position(3, 7));
        instance.movePiecePosition(new Position(7, 3), new Position(5, 2));
        instance.movePiecePosition(new Position(3, 7), new Position(4, 5));
        instance.movePiecePosition(new Position(6, 3), new Position(4, 5));
        instance.movePiecePosition(new Position(3, 4), new Position(4, 5));
        instance.movePiecePosition(new Position(6, 4), new Position(6, 3));
        instance.movePiecePosition(new Position(1, 6), new Position(3, 6));
        instance.movePiecePosition(new Position(4, 4), new Position(3, 3));
        instance.movePiecePosition(new Position(2, 2), new Position(3, 3));
        instance.movePiecePosition(new Position(5, 2), new Position(3, 3));
        instance.movePiecePosition(new Position(0, 2), new Position(1, 1));
        instance.movePiecePosition(new Position(6, 2), new Position(4, 2));
        instance.movePiecePosition(new Position(1, 1), new Position(3, 3));
        instance.movePiecePosition(new Position(4, 2), new Position(3, 3));
        instance.movePiecePosition(new Position(2, 3), new Position(4, 1));
        instance.movePiecePosition(new Position(6, 3), new Position(6, 2));
        instance.movePiecePosition(new Position(0, 3), new Position(3, 3));
        instance.movePiecePosition(new Position(5, 3), new Position(4, 3));
        instance.movePiecePosition(new Position(0, 4), new Position(1, 4));
        instance.movePiecePosition(new Position(7, 0), new Position(7, 3));
        instance.movePiecePosition(new Position(0, 0), new Position(0, 4));
        instance.movePiecePosition(new Position(7, 3), new Position(5, 3));
        instance.movePiecePosition(new Position(1, 4), new Position(6, 4));
        instance.movePiecePosition(new Position(6, 2), new Position(1, 2));
        instance.movePiecePosition(new Position(6, 4), new Position(6, 1));
        instance.movePiecePosition(new Position(5, 5), new Position(3, 4));
        instance.movePiecePosition(new Position(0, 4), new Position(1, 4));
        instance.movePiecePosition(new Position(1, 2), new Position(0, 2));
        instance.movePiecePosition(new Position(0, 6), new Position(1, 6));
        instance.movePiecePosition(new Position(0, 2), new Position(7, 2));
        instance.movePiecePosition(new Position(6, 1), new Position(6, 4));
        instance.movePiecePosition(new Position(7, 2), new Position(7, 3));
        instance.movePiecePosition(new Position(3, 3), new Position(6, 0));
        instance.movePiecePosition(new Position(3, 4), new Position(5, 5));
        instance.movePiecePosition(new Position(6, 4), new Position(6, 2));
        instance.movePiecePosition(new Position(4, 3), new Position(3, 3));
        instance.movePiecePosition(new Position(1, 4), new Position(6, 4));
        instance.movePiecePosition(new Position(3, 3), new Position(2, 3));
        instance.movePiecePosition(new Position(6, 4), new Position(6, 5));
        instance.movePiecePosition(new Position(7, 5), new Position(6, 5));
        instance.movePiecePosition(new Position(6, 2), new Position(6, 5));
        instance.movePiecePosition(new Position(2, 3), new Position(1, 3));
        instance.movePiecePosition(new Position(6, 5), new Position(6, 6));
        instance.movePiecePosition(new Position(7, 6), new Position(7, 7));
        instance.movePiecePosition(new Position(4, 1), new Position(1, 4));
        instance.movePiecePosition(new Position(1, 3), new Position(0, 3));
        instance.movePiecePosition(new Position(1, 4), new Position(0, 3));
        instance.movePiecePosition(new Position(5, 3), new Position(0, 3));
        instance.movePiecePosition(new Position(6, 6), new Position(5, 6));
        instance.movePiecePosition(new Position(7, 3), new Position(4, 3));
        instance.movePiecePosition(new Position(1, 6), new Position(2, 6));
        instance.movePiecePosition(new Position(0, 3), new Position(2, 3));
        instance.movePiecePosition(new Position(2, 6), new Position(3, 7));
        instance.movePiecePosition(new Position(2, 3), new Position(2, 7));
        instance.movePiecePosition(new Position(3, 7), new Position(2, 7));
        instance.movePiecePosition(new Position(4, 3), new Position(0, 7));
        instance.movePiecePosition(new Position(2, 7), new Position(2, 6));
        instance.movePiecePosition(new Position(5, 5), new Position(4, 7));
        instance.movePiecePosition(new Position(3, 6), new Position(4, 7));
        instance.movePiecePosition(new Position(0, 7), new Position(2, 5));
        instance.movePiecePosition(new Position(2, 6), new Position(1, 7));
        instance.movePiecePosition(new Position(2, 5), new Position(1, 6));
        instance.movePiecePosition(new Position(1, 7), new Position(1, 6));
        
        GameState expGameState = GameState.STALE_MATE;
        GameState result = instance.getState();
        
        assertEquals(expGameState, result);
    }

    private void assertEqualsIgnoringOrder(List<Position> expected, List<Position> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(expected.containsAll(actual));

    }
}
