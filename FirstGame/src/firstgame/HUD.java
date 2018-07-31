
package firstgame;

import java.awt.Color;
import java.awt.Graphics;


public class HUD {
    
    public static int HEALT = 100;
    
    public void tick() {
        //HEALT--;
        
        HEALT = Game.clamp(HEALT, 0, 100);
    }
    
    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.green);
        g.fillRect(15, 15, HEALT * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);        

    }
}
