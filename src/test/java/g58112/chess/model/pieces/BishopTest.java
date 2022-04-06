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
public class BishopTest {
    
    Board board;
    
    public BishopTest() {
    }

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    /**
     * Test of getPossibleMoves method, of class Bishop.
     */
    @Test
    public void initialBishopPos() {
        Position position = new Position(0, 5);
        Piece piece = new Bishop(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(1, 4),
                new Position(2, 3),
                new Position(3, 2),
                new Position(4, 1),
                new Position(5, 0),
                new Position(1, 6),
                new Position(2, 7)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    /**
     * Test of getPossibleMoves method, of class Bishop.
     */
    @Test
    public void bishopMiddlePos() {
        Position position = new Position(3, 3);
        Piece piece = new Bishop(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(0, 0),
                new Position(1, 1),
                new Position(2, 2),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7),
                new Position(4, 2),
                new Position(5, 1),
                new Position(6, 0),
                new Position(2, 4),
                new Position(1, 5),
                new Position(0, 6)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    /**
     * Test of getPossibleMoves method, of class Bishop.
     */
    @Test
    public void bishopRightCornerPos() {
        Position position = new Position(7, 7);
        Piece piece = new Bishop(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(0, 0),
                new Position(1, 1),
                new Position(2, 2),
                new Position(3, 3),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    /**
     * Test of getPossibleMoves method, of class Bishop.
     */
    @Test
    public void bishopMiddlePosWithPieces() {
        Position position = new Position(3, 3);
        Piece piece = new Bishop(Color.BLACK);
        board.setPiece(piece, position);
        Position position2 = new Position(1, 1);
        Piece piece2 = new Queen(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(6, 6);
        Piece piece3 = new Pawn(Color.WHITE);
        board.setPiece(piece3, position3);
        Position position4 = new Position(3, 1);
        Piece piece4 = new Pawn(Color.BLACK);
        board.setPiece(piece4, position4);
        Position position5 = new Position(3, 7);
        Piece piece5 = new Knight(Color.WHITE);
        board.setPiece(piece5, position5);
        Position position6 = new Position(2, 3);
        Piece piece6 = new Pawn(Color.BLACK);
        board.setPiece(piece6, position6);
        Position position7 = new Position(6, 3);
        Piece piece7 = new Pawn(Color.WHITE);
        board.setPiece(piece7, position7);
        Position position8 = new Position(1, 5);
        Piece piece8 = new Knight(Color.BLACK);
        board.setPiece(piece8, position8);
        Position position9 = new Position(6, 0);
        Piece piece9 = new Pawn(Color.WHITE);
        board.setPiece(piece9, position9);
        
        List<Position> expected = List.of(
                new Position(2, 2),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(2, 4),
                new Position(4, 2),
                new Position(5, 1),
                new Position(6, 0)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    /**
     * Test of getCapturePositions method, of class Bishop.
     */
    @Test
    public void bishopMiddlePosWithPieces_getCapture() {
        Position position = new Position(3, 3);
        Piece piece = new Bishop(Color.BLACK);
        board.setPiece(piece, position);
        Position position2 = new Position(1, 1);
        Piece piece2 = new Queen(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(6, 6);
        Piece piece3 = new Pawn(Color.WHITE);
        board.setPiece(piece3, position3);
        Position position4 = new Position(3, 1);
        Piece piece4 = new Pawn(Color.BLACK);
        board.setPiece(piece4, position4);
        Position position5 = new Position(3, 7);
        Piece piece5 = new Knight(Color.WHITE);
        board.setPiece(piece5, position5);
        Position position6 = new Position(2, 3);
        Piece piece6 = new Pawn(Color.BLACK);
        board.setPiece(piece6, position6);
        Position position7 = new Position(6, 3);
        Piece piece7 = new Pawn(Color.WHITE);
        board.setPiece(piece7, position7);
        Position position8 = new Position(1, 5);
        Piece piece8 = new Knight(Color.BLACK);
        board.setPiece(piece8, position8);
        Position position9 = new Position(6, 0);
        Piece piece9 = new Pawn(Color.WHITE);
        board.setPiece(piece9, position9);
        
        List<Position> expected = List.of(
                new Position(6, 6),
                new Position(6, 0)
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
