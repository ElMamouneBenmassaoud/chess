package g58112.chess.model;

import g58112.chess.model.pieces.Bishop;
import g58112.chess.model.pieces.King;
import g58112.chess.model.pieces.Knight;
import g58112.chess.model.pieces.Pawn;
import g58112.chess.model.pieces.Piece;
import g58112.chess.model.pieces.Queen;
import g58112.chess.model.pieces.Rook;
import java.util.ArrayList;
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
            if (isValidMove(oldPos, newPos)) {
                board.setPiece(getPiece(oldPos), newPos);
                board.dropPiece(oldPos);
                
                King oppositeKing;
                if (currentPlayer.getColor() == Color.WHITE) oppositeKing = blackKing;
                else oppositeKing = whiteKing;
                
                if (getCapturePositions(currentPlayer).contains(board.getPiecePosition(oppositeKing))) {
                    if (!getValidMoves(getOppositePlayer()).isEmpty()) {
                        state = GameState.CHECK;
                    }
                    else {
                        state = GameState.CHECK_MATE;
                    }
                }
                else {
                    if (getValidMoves(getOppositePlayer()).isEmpty()) {
                        state = GameState.STALE_MATE;
                    }
                    else state = GameState.PLAY;
                }
                    
                currentPlayer = getOppositePlayer();
            }
            else throw new IllegalArgumentException("La position jouée n'est pas valide, car le joueur est en position d'échec");
        }
    }

    @Override
    public boolean isGameOver() {
        return (state == GameState.CHECK_MATE || state == GameState.STALE_MATE);
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
    
     /**
     * this method returns the list of valid moves
     * for the given player 
     *
     * @param player the given player
     * @return the list of valid moves for the player
     */
    private List<Position> getValidMoves(Player player) {
        List<Position> validPositions = new ArrayList();
        
        for (Position position : board.getPositionOccupiedBy(player)) {
            Piece piece = board.getPiece(position);
            for (Position newPos : piece.getPossibleMoves(position, board)) {
                if (!validPositions.contains(newPos) && isValidMove(position, newPos)) validPositions.add(newPos);
            }
        }
        
        return validPositions;
    }
    
    /**
     * this method returns the list of positions on which
     * the given player can capture an opponent's piece
     *
     * @param player the given player
     * @return the list of capture positions for the player
     */
    private List<Position> getCapturePositions(Player player) {
        List<Position> capturePositions = new ArrayList();
        
        for (Position position : board.getPositionOccupiedBy(player)) {
            Piece piece = board.getPiece(position);
            for (Position capturePosition : piece.getCapturePositions(position, board)) {
                if (!capturePositions.contains(capturePosition)) capturePositions.add(capturePosition);
            }
        }
        
        return capturePositions;
    }
    
    @Override
    public boolean isValidMove(Position oldPos, Position newPos) {
        boolean isValidMove = true;
        
        if (board.isFree(oldPos)) throw new IllegalArgumentException("La position de départ ne contient aucune pièce");
        if (!board.getPiece(oldPos).getPossibleMoves(oldPos, board).contains(newPos)) throw new IllegalArgumentException("Le déplacement joué n'est pas valide pour cette pièce");
        
        Player movingPlayer;
        Player oppositePlayer;
        if (board.getPiece(oldPos).getColor() == Color.WHITE) {
            movingPlayer = white;
            oppositePlayer = black;
        }
        else {
            movingPlayer = black;
            oppositePlayer = white;
        }
  
        Piece movedPiece = board.getPiece(oldPos);
        Piece replacedPiece = board.getPiece(newPos);
        
        King currentKing;
        if (movingPlayer.getColor() == Color.WHITE) currentKing = whiteKing;
        else currentKing = blackKing;
        
        if (replacedPiece != null) board.dropPiece(newPos);
        board.setPiece(movedPiece, newPos);
        if (getCapturePositions(oppositePlayer).contains(board.getPiecePosition(currentKing))) isValidMove = false;

        board.setPiece(movedPiece, oldPos);
        board.setPiece(replacedPiece, newPos);
        
        return isValidMove;
    }
}
