/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58112.chess.model;

/**
 *
 * @author g58112
 */
public class Move {
    
    private Position oldPos;
    private Position newPos;

    public Move(Position oldPos, Position newPos) {
        this.oldPos = oldPos;
        this.newPos = newPos;
    }

    public Position getOldPos() {
        return oldPos;
    }

    public Position getNewPos() {
        return newPos;
    }

    @Override
    public String toString() {
        return getOldPos() + "-" + getNewPos();
    }
    
    
}
