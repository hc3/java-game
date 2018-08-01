package firstgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class BasicEnemy extends GameObject {
    
    private Handler handler;

    public BasicEnemy(Integer x, Integer y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        velX = 5;
        velY = 5;
    }

    public void tick() {
       x += velX;
       y += velY;
       
       if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1; // parece com o lance do barrado de sistemas digitais;
       if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
       
       handler.addObject(new Trail(x, y, ID.Trail, 16, 16, 0.05f, Color.red, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }
    
}
