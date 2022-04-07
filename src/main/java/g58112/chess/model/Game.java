package g58112.chess.model;

import g58112.chess.model.pieces.Bishop;
import g58112.chess.model.pieces.King;
import g58112.chess.model.pieces.Knight;
import g58112.chess.model.pieces.Pawn;
import g58112.chess.model.pieces.Piece;
import g58112.chess.model.pieces.Queen;
import g58112.chess.model.pieces.Rook;
import java.util.List;

/**
 * This one gathers the elements necessary for the game, and implements the
 * different stages of the game. It is the access point for the view and the
 * controller.
 *
 * @author mamou
 */
public class Game implements Model {

    private final Board board;
    private final Player white;
    private final Player black;
    private Player currentPlayer;
    
    private King whiteKing;
    private King blackKing;

    private GameState state;
    
    /**
     * It simply creates a new white player, a new black player and a new empty
     * board
     */
    public Game() {
        white = new Player(Color.WHITE);
        black = new Player(Color.BLACK);
        board = new Board();
    }

    @Override
    public void start() {
        for (int i = 0; i < 8; i++) {
            board.setPiece(new Pawn(Color.WHITE), new Position(board.getInitialPawnRow(Color.WHITE), i));
        }
        board.setPiece(new Rook(Color.WHITE), new Position(0,0));
        board.setPiece(new Rook(Color.WHITE), new Position(0,7));
        board.setPiece(new Knight(Color.WHITE), new Position(0,1));
        board.setPiece(new Knight(Color.WHITE), new Position(0,6));
        board.setPiece(new Bishop(Color.WHITE), new Position(0,2));
        board.setPiece(new Bishop(Color.WHITE), new Position(0,5));
        board.setPiece(new Queen(Color.WHITE), new Position(0,3));
        
        whiteKing = new King(Color.WHITE);
        board.setPiece(whiteKing, new Position(0,4));
        
        for (int j = 0; j < 8; j++) {
            board.setPiece(new Pawn(Color.BLACK), new Position(board.getInitialPawnRow(Color.BLACK), j));
        }
        board.setPiece(new Rook(Color.BLACK), new Position(7,0));
        board.setPiece(new Rook(Color.BLACK), new Position(7,7));
        board.setPiece(new Knight(Color.BLACK), new Position(7,1));
        board.setPiece(new Knight(Color.BLACK), new Position(7,6));
        board.setPiece(new Bishop(Color.BLACK), new Position(7,2));
        board.setPiece(new Bishop(Color.BLACK), new Position(7,5));
        board.setPiece(new Queen(Color.BLACK), new Position(7,3));
        
        blackKing = new King(Color.BLACK);
        board.setPiece(blackKing, new Position(7,4));
        
        currentPlayer = white;
        
        state = GameState.PLAY;
    }

    @Override
    public Piece getPiece(Position pos) {
        return board.getPiece(pos);
    }

    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public Player getOppositePlayer() {
        Player oppositePlayer = black;
        if (currentPlayer == black) {
            oppositePlayer = white;
        }
        return oppositePlayer;
    }

    @Override
    public boolean isCurrentPlayerPosition(Position pos) {
        boolean isCurrentPlayerPosition = false;
        if (board.getPiece(pos).getColor() == currentPlayer.getColor()) {
            isCurrentPlayerPosition = true;
        }
        return isCurrentPlayerPosition;
    }

    @Override
    public void movePiecePosition(Position oldPos, Position newPos) {
        if (!board.contains(oldPos) || !board.contains(newPos)) {
            throw new IllegalArgumentException("la position n'existe pas sur l'échequier");
        }

        if (board.isFree(oldPos)) {
            throw new IllegalArgumentException("La position de départ ne contient pas de pièce");
        }

        if (!isCurrentPlayerPosition(oldPos)) {
            throw new IllegalArgumentException("la pièce n'appartient pas au joueur actuel");
        }

        if (!getPossibleMoves(oldPos).contains(newPos)) {
            throw new IllegalArgumentException("La position jouée n'est pas valide");
        }

        if (!isGameOver()) {
            board.setPiece(getPiece(oldPos), newPos);
            board.dropPiece(oldPos);
            currentPlayer = getOppositePlayer();
        }
    }

    @Override
    public boolean isGameOver() {
        List<Position> currentPos = board.getPositionOccupiedBy(currentPlayer);
        int i = 0;
        while (i < currentPos.size() && getPossibleMoves(currentPos.get(i)).isEmpty()) {
            i++;
        }
        return i == currentPos.size();
    }

    @Override
    public List<Position> getPossibleMoves(Position position) {
        Piece piece = board.getPiece(position);
        return piece.getPossibleMoves(position, board);
    }

    @Override
    public GameState getState() {
        return state;
    }
}
