package firstgame;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;


public class Handler {
    
    List<GameObject> listObject = new LinkedList<>();
    
    public void tick() {     
        //listObject.stream().map((elemento) -> elemento).forEachOrdered((tempObject) -> tempObject.tick());
        //listObject.stream().forEach(el -> el.tick());
        for(int i = 0; i < listObject.size(); i++) {
            GameObject tempObject = listObject.get(i);
            
            tempObject.tick();
        }
    }
    
    public void render(Graphics g) {
        listObject.stream().map((elemento) -> elemento).forEachOrdered((tempObject) -> tempObject.render(g));
    }
    public void addObject(GameObject object) {
        this.listObject.add(object);
    }
    
    public void removeObject(GameObject object) {
        this.listObject.remove(object);
    }
}
