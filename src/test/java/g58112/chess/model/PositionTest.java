/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58112.chess.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g58112
 */
public class PositionTest {
    

    /**
     * Test of next method, of class Position.
     */
    @Test
    public void testNext_nord() {
        System.out.println("next");
        Position position = new Position(1,1);
        Position expResult = new Position(2,1);
        Position result = position.next(Direction.N);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of next method, of class Position.
     */
    @Test
    public void testNext_sud() {
        System.out.println("next");
        Position position = new Position(5,5);
        Position expResult = new Position(4,5);
        Position result = position.next(Direction.S);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of next method, of class Position.
     */
    @Test
    public void testNext_nordWest() {
        System.out.println("next");
        Position position = new Position(7,4);
        Position expResult = new Position(8,3);
        Position result = position.next(Direction.NW);
        assertEquals(expResult, result);
    }
    
    
}
