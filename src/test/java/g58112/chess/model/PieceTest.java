package g58112.chess.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author srexhep
 */
public class PieceTest {

    Board board;

    public PieceTest() {
    }

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testGetPossibleMovesP() {
        Position position = new Position(1, 1);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 1),
                new Position(3, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    /**
     * ******* A vous d'écrire les autres cas. Veuillez faire attention à avoir
     * un plan de test complet (comme précisé dans l'énoncé)
     ***********
     */
    //initial position du pion
    @Test
    public void testGetPossibleMovesForwardOppositePawnInitial1() {
        //pion adverse en face de moi et trouver un nom au test !!!!!!!
        Position position = new Position(1, 5);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        Position position2 = new Position(2, 5);
        Piece piece2 = new Piece(Color.BLACK);
        board.setPiece(piece2, position2);
        List<Position> expected = List.of();
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesForwardOppositePawnInitial2() {
        //pion en face de moi mais avec une case libre qui se trouve entre nous et trouver un nom au test !!!!!!!
        Position position = new Position(1, 1);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        Position position2 = new Position(3, 1);
        Piece piece2 = new Piece(Color.BLACK);
        board.setPiece(piece2, position2);
        List<Position> expected = List.of(
                new Position(2, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesDiagonalsOppositePawnInitial() {
        //pion adverses en diagonal des 2 cotés et revoir le nom au test !!!!!!!
        Position position = new Position(1, 4);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        Position position2 = new Position(2, 3);
        Piece piece2 = new Piece(Color.BLACK);
        board.setPiece(piece2, position2);

        Position position3 = new Position(2, 5);
        Piece piece3 = new Piece(Color.BLACK);
        board.setPiece(piece3, position3);
        List<Position> expected = List.of(
                new Position(2, 3),
                new Position(2, 5),
                new Position(2, 4),
                new Position(3, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    

    @Test
    public void testGetPossibleMovesForwardPawnInitialOfSamePlayer() {
        //pion de meme couleur en face de moi et revoir le nom au test !!!!!!!
        Position position = new Position(1, 3);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        Position position2 = new Position(2, 3);
        Piece piece2 = new Piece(Color.WHITE);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesForwardPawnInitialOfSamePlayer2() {
        //pion de meme couleur en face de moi mais avec une case libre qui se trouve entre nous et trouver un nom au test !!!!!!!
        Position position = new Position(1, 6);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        Position position2 = new Position(3, 6);
        Piece piece2 = new Piece(Color.WHITE);
        board.setPiece(piece2, position2);
        List<Position> expected = List.of(
                new Position(2, 6)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesDiagonalsPawnInitialOfSamePlayer() {
        //pion adverses en diagonal des 2 cotés et revoir le nom au test !!!!!!!
        Position position = new Position(1, 3);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        Position position2 = new Position(2, 2);
        Piece piece2 = new Piece(Color.WHITE);
        board.setPiece(piece2, position2);

        Position position3 = new Position(2, 4);
        Piece piece3 = new Piece(Color.WHITE);
        board.setPiece(piece3, position3);
        
        List<Position> expected = List.of(
                new Position(2, 3),
                new Position(3, 3)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    //position du pion au milieu du board
    @Test
    public void testGetPossibleMovesForwardOppositePawn1() {
        //pion adverse en face de moi et trouver un nom au test !!!!!!!
        Position position = new Position(2, 1);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        Position position2 = new Position(3, 1);
        Piece piece2 = new Piece(Color.BLACK);
        board.setPiece(piece2, position2);
        List<Position> expected = List.of();
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesForwardOppositePawn2() {
        //pion en face de moi mais avec une case libre qui se trouve entre nous et trouver un nom au test !!!!!!!
        Position position = new Position(2, 1);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        Position position2 = new Position(4, 2);
        Piece piece2 = new Piece(Color.BLACK);
        board.setPiece(piece2, position2);
        List<Position> expected = List.of(
                new Position(3, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesDiagonalsOppositePawn() {
        //pion adverses en diagonal des 2 cotés et revoir le nom au test !!!!!!!
        Position position = new Position(2, 2);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        Position position2 = new Position(3, 1);
        Piece piece2 = new Piece(Color.BLACK);
        board.setPiece(piece2, position2);

        Position position3 = new Position(3, 3);
        Piece piece3 = new Piece(Color.BLACK);
        board.setPiece(piece3, position3);
        List<Position> expected = List.of(
                new Position(3, 3),
                new Position(3, 1),
                new Position(3, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    

    @Test
    public void testGetPossibleMovesForwardPawnOfSamePlayer() {
        //pion de meme couleur en face de moi et revoir le nom au test !!!!!!!
        Position position = new Position(2, 4);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        Position position2 = new Position(3, 4);
        Piece piece2 = new Piece(Color.WHITE);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesForwardPawnOfSamePlayer2() {
        //pion de meme couleur en face de moi mais avec une case libre qui se trouve entre nous et trouver un nom au test !!!!!!!
        Position position = new Position(2, 4);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        Position position2 = new Position(4, 4);
        Piece piece2 = new Piece(Color.WHITE);
        board.setPiece(piece2, position2);
        List<Position> expected = List.of(
                new Position(3, 4)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesDiagonalsPawnOfSamePlayer() {
        //pion adverses en diagonal des 2 cotés et revoir le nom au test !!!!!!!
        Position position = new Position(2, 6);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        Position position2 = new Position(3, 5);
        Piece piece2 = new Piece(Color.WHITE);
        board.setPiece(piece2, position2);

        Position position3 = new Position(3, 7);
        Piece piece3 = new Piece(Color.WHITE);
        board.setPiece(piece3, position3);
        
        List<Position> expected = List.of(
                new Position(3, 6)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    @Test
    public void testGetPossibleMovesEdgePawn() {
        //pion se trouve a l'extremite et revoir le nom au test !!!!!!!
        Position position = new Position(7, 0);
        Piece piece = new Piece(Color.WHITE);
        board.setPiece(piece, position);

        
        List<Position> expected = List.of();
        List<Position> positions = piece.getPossibleMoves(position, board);

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
