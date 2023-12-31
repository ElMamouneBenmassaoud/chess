/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
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
public class KnightTest {
    
    Board board;
    
    public KnightTest() {
    }

    @BeforeEach
    public void setUp() {
        board = new Board();
    }
    
    /**
     * Test of getPossibleMoves method, of class Knight.
     */
    @Test
    public void initialKnightPos() {
        System.out.println("getPossibleMoves");
        Position position = new Position(0, 2);
        Piece piece = new Knight(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 1),
                new Position(2, 3),
                new Position(1, 0),
                new Position(1, 4)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    /**
     * Test of getPossibleMoves method, of class Knight.
     */
    @Test
    public void KnightLeftEdgePos() {
        System.out.println("getPossibleMoves");
        Position position = new Position(2, 0);
        Piece piece = new Knight(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(0, 1),
                new Position(3, 2),
                new Position(1, 2),
                new Position(4, 1)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    /**
     * Test of getPossibleMoves method, of class Knight.
     */
    @Test
    public void knightMiddlePos() {
        System.out.println("getPossibleMoves");
        Position position = new Position(3, 3);
        Piece piece = new Knight(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 1),
                new Position(1, 2),
                new Position(2, 5),
                new Position(4, 5),
                new Position(5, 4),
                new Position(5, 2),
                new Position(4, 1),
                new Position(1, 4)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    /**
     * Test of getPossibleMoves method, of class Knight.
     */
    @Test
    public void knightRightCornerPos() {
        System.out.println("getPossibleMoves");
        Position position = new Position(7, 7);
        Piece piece = new Knight(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(6, 5);
        Piece piece2 = new Knight(Color.WHITE);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(5, 6)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    /**
     * Test of getPossibleMoves method, of class Knight.
     */
    @Test
    public void knightCantMove() {
        System.out.println("getPossibleMoves");
        Position position = new Position(0, 0);
        Piece piece = new Knight(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(1, 2);
        Piece piece2 = new Knight(Color.WHITE);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2, 1);
        Piece piece3 = new Knight(Color.WHITE);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of();
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    /**
     * Test of getPossibleMoves method, of class Knight.
     */
    @Test
    public void knightMiddlePos_eat() {
        System.out.println("getPossibleMoves");
        Position position = new Position(3, 3);
        Piece piece = new Knight(Color.WHITE);
        board.setPiece(piece, position);
        
        Position position2 = new Position(2, 1);
        Piece piece2 = new Knight(Color.BLACK);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(2, 1),
                new Position(1, 2),
                new Position(2, 5),
                new Position(4, 5),
                new Position(5, 4),
                new Position(5, 2),
                new Position(4, 1),
                new Position(1, 4)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    /**
     * Test of getPossibleMoves method, of class Knight.
     */
    @Test
    public void initialKnightPos_getCapture() {
        System.out.println("getPossibleMoves");
        Position position = new Position(0, 2);
        Piece piece = new Knight(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of();
        List<Position> positions = piece.getCapturePositions(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    /**
     * Test of getPossibleMoves method, of class Knight.
     */
    @Test
    public void KnightLeftEdgePos_getCapture() {
        System.out.println("getPossibleMoves");
        Position position = new Position(2, 0);
        Piece piece = new Knight(Color.WHITE);
        board.setPiece(piece, position);
        Position position2 = new Position(3, 2);
        Piece piece2 = new Knight(Color.BLACK);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(3, 2)
        );
        List<Position> positions = piece.getCapturePositions(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    /**
     * Test of getPossibleMoves method, of class Knight.
     */
    @Test
    public void knightMiddlePos_getCapture() {
        System.out.println("getPossibleMoves");
        Position position = new Position(3, 3);
        Piece piece = new Knight(Color.WHITE);
        board.setPiece(piece, position);
        Position position4 = new Position(4, 1);
        Piece piece4 = new Knight(Color.WHITE);
        board.setPiece(piece4, position4);
        Position position2 = new Position(5, 2);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece2, position2);
        Position position3 = new Position(2, 5);
        Piece piece3 = new Knight(Color.BLACK);
        board.setPiece(piece3, position3);
        Position position5 = new Position(4, 2);
        Piece piece5 = new Knight(Color.BLACK);
        board.setPiece(piece5, position5);

        List<Position> expected = List.of(
                new Position(5, 2),
                new Position(2, 5)
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
