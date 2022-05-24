import JavaGameEngine.Backend.ComponentHandler;
import JavaGameEngine.Backend.Input.Input;
import JavaGameEngine.Backend.Input.Keys;
import JavaGameEngine.Components.GameObject;
import JavaGameEngine.JavaGameEngine;
import JavaGameEngine.msc.Vector2;

public class Test extends JavaGameEngine {

    public static void main(String[] args){
        init();
        //ComponentHandler.addObject(new Player());
        start();
    }
    static class Player extends GameObject {
        public Player(){

        }

        @Override
        public void update() {
            super.update();
            if(Input.isKeyDown(Keys.D)){
                movePosition(getPosition().add(Vector2.right));
            }
        }
    }

}
