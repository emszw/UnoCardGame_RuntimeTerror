/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import UnoCardGame.*;
/**
 *
 * @author Kimio Nishino
 */
public class StartGame {
    public static void main(String[] args) {
       UnoCardGame game = new UnoCardGame();
       game.initializeGame(args);
       game.play();
    }
}
