package firstgame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private Random r;
    private Handler handler;
    private HUD hud;

    public Game() {
        handler = new Handler();
        
        this.addKeyListener(new KeyInput(handler));
        
        new Window(WIDTH, HEIGHT, "hellow world title", this);

        hud = new HUD();
        
        r = new Random();
        
        handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
        
        for(int i = 0; i < 5; i++) {
            handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT) , ID.BasicEnemy));
        }

    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus();
        Long lasTime = System.nanoTime();
        Double amountOfTicks = 60.0;
        Double ns = 1000000000 / amountOfTicks;
        Double delta = 0.0;
        Long timer = System.currentTimeMillis();
        Integer frames = 0;

        while (running) {
            Long now = System.nanoTime();
            delta += (now - lasTime) / ns;
            lasTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
        hud.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);
        
        hud.render(g);

        g.dispose();
        bs.show();
    }
    
    public static int clamp(int var, int min, int max) {
        if(var >= max) {
            return var = max;
        } else if(var <= min) {
            return var = min;
        } else {
            return var;
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}
