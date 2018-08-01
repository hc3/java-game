package firstgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.List;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();
    Handler handler;

    public Player(Integer x, Integer y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {

        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 37);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);
        
        handler.addObject(new Trail(x, y, ID.Trail, 32, 32, 0.05f, Color.white, handler));

        collision();
    }

    private void collision() {
        handler.listObject.stream().forEach(el -> colide(el));
    }

    private void colide(GameObject el) {
        if (el.getId() == ID.BasicEnemy && getBounds().intersects(el.getBounds())) {
            HUD.HEALT -= 2;
        }
    }

    @Override
    public void render(Graphics g) {
        /*
        Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(Color.green);
        g2d.draw(getBounds());
         */
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

}
