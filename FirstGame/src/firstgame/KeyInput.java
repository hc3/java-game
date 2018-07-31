/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Analista de Vendas
 */
public class KeyInput extends KeyAdapter {

    private final Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        handler.listObject.stream().forEach(el -> getKeyPressed(e.getKeyCode(), el, 5));
    }

    private void getKeyPressed(int key, GameObject tempObject, int value) {
        if (tempObject.getId() == ID.Player) {

            if (key == KeyEvent.VK_W) {
                tempObject.setVelY(value * -1);
            }
            if (key == KeyEvent.VK_S) {
                tempObject.setVelY(value);
            }
            if (key == KeyEvent.VK_D) {
                tempObject.setVelX(value);
            }
            if (key == KeyEvent.VK_A) {
                tempObject.setVelX(value * -1);
            }

        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        handler.listObject.stream().forEach(el -> getKeyReleased(key, el, 0));

        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }

    }

    private void getKeyReleased(int key, GameObject tempObject, int value) {
        if (tempObject.getId() == ID.Player) {

            if (key == KeyEvent.VK_W) {
                tempObject.setVelY(value);
            }
            if (key == KeyEvent.VK_S) {
                tempObject.setVelY(value);
            }
            if (key == KeyEvent.VK_D) {
                tempObject.setVelX(value);
            }
            if (key == KeyEvent.VK_A) {
                tempObject.setVelX(value);
            }

        }
    }

}
