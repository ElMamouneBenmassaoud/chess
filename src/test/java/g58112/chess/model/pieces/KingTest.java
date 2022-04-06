package g58112.chess.model.pieces;

import g58112.chess.model.Board;
import g58112.chess.model.Color;
import g58112.chess.model.Position;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author mamou
 */
public class KingTest {
    
    Board board;
    
    public KingTest() {
    }

    @BeforeEach
    public void setUp() {
        board = new Board();
    }
    
    /**
     * Test of getPossibleMoves method, of class King.
     */
    @Test
    public void initialKingPos() {
        System.out.println("getPossibleMoves");
        Position position = new Position(0, 4);
        Piece piece = new King(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(0, 3),
                new Position(1, 3),
                new Position(1, 5),
                new Position(0, 5),
                new Position(1, 4)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    /**
     * Test of getPossibleMoves method, of class King.
     */
    @Test
    public void KingLeftEdgePos() {
        System.out.println("getPossibleMoves");
        Position position = new Position(2, 0);
        Piece piece = new King(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(3, 0),
                new Position(1, 0),
                new Position(2, 1),
                new Position(3, 1),
                new Position(1, 1)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    /**
     * Test of getPossibleMoves method, of class King.
     */
    @Test
    public void kingMiddlePos() {
        System.out.println("getPossibleMoves");
        Position position = new Position(2, 4);
        Piece piece = new King(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(1, 3),
                new Position(1, 4),
                new Position(1, 5),
                new Position(2, 3),
                new Position(3, 3),
                new Position(3, 5),
                new Position(3, 4),
                new Position(2, 5)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    /**
     * Test of getPossibleMoves method, of class King.
     */
    @Test
    public void kingRightCornerPos() {
        System.out.println("getPossibleMoves");
        Position position = new Position(7, 7);
        Piece piece = new King(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(7, 6);
        Piece piece2 = new Knight(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(6, 6);
        Piece piece3 = new Pawn(Color.BLACK);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
                new Position(6, 6),
                new Position(6, 7)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    /**
     * Test of getPossibleMoves method, of class King.
     */
    @Test
    public void kingMiddlePos_eat() {
        System.out.println("getPossibleMoves");
        Position position = new Position(2, 4);
        Piece piece = new King(Color.WHITE);
        board.setPiece(piece, position);
        
        Position position2 = new Position(2, 5);
        Piece piece2 = new Knight(Color.BLACK);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(1, 3),
                new Position(1, 4),
                new Position(1, 5),
                new Position(2, 3),
                new Position(3, 3),
                new Position(3, 5),
                new Position(3, 4),
                new Position(2, 5)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    /**
     * Test of getPossibleMoves method, of class King.
     */
    @Test
    public void initialKingPos_getCapture() {
        System.out.println("getPossibleMoves");
        Position position = new Position(0, 4);
        Piece piece = new King(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of();
        List<Position> positions = piece.getCapturePositions(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    /**
     * Test of getPossibleMoves method, of class King.
     */
    @Test
    public void KingLeftEdgePos_getCapture() {
        System.out.println("getPossibleMoves");
        Position position = new Position(2, 0);
        Piece piece = new King(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(3, 1);
        Piece piece2 = new Knight(Color.BLACK);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(3, 1)
        );
        List<Position> positions = piece.getCapturePositions(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    /**
     * Test of getPossibleMoves method, of class King.
     */
    @Test
    public void kingMiddlePos_getCapture() {
        System.out.println("getPossibleMoves");
        Position position = new Position(2, 4);
        Piece piece = new King(Color.WHITE);
        board.setPiece(piece, position);
        Position position4 = new Position(2, 3);
        Piece piece4 = new Knight(Color.WHITE);
        board.setPiece(piece4, position4);
        Position position2 = new Position(3, 3);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(1, 5);
        Piece piece3 = new Knight(Color.BLACK);
        board.setPiece(piece3, position3);
        Position position5 = new Position(1, 2);
        Piece piece5 = new Knight(Color.BLACK);
        board.setPiece(piece5, position5);

        List<Position> expected = List.of(
                new Position(3, 3),
                new Position(1, 5)
        );
        List<Position> positions = piece.getCapturePositions(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    /*
     *      Permet de tester si deux listes de positions sont identiques à l'ordre
     *      des éléments prêts. Cette méthode est appelée
     *      par les méthodes de test.
     */
    private void assertEqualsIgnoringOrder(List<Position> expected, List<Position> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(expected.containsAll(actual));

    }
}
