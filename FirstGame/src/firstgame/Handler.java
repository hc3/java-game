package firstgame;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;


public class Handler {
    
    List<GameObject> listObject= new LinkedList<GameObject>();
    
    public void tick() {
        int index = 0;     
        for(GameObject elemento: listObject) {
            GameObject tempObject = listObject.get(index);
            tempObject.tick();
            index++;
        }
    }
    
    public void render(Graphics g) {
        int index = 0; 
        for(GameObject elemento: listObject) {
            GameObject tempObject = listObject.get(index);
            tempObject.render(g);
            index++;
        }
    }
    public void addObject(GameObject object) {
        this.listObject.add(object);
    }
    
    public void removeObject(GameObject object) {
        this.listObject.remove(object);
    }
}
