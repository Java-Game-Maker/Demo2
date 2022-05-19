import JavaGameEngine.Backend.ComponentHandler;
import JavaGameEngine.Backend.UpdateThread;
import JavaGameEngine.Components.Physics.PhysicsBody;
import JavaGameEngine.Components.Physics.PhysicsWorld;
import JavaGameEngine.JavaGameEngine;
import JavaGameEngine.msc.Vector2;

import javax.swing.*;
import java.awt.*;

public class Main extends JavaGameEngine {

    public static void main(String[] args){
        init();
        JFrame frame = new JFrame("Flappy bird");
        frame.setSize(600,1080);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PhysicsWorld.setGravityAcceleration(PhysicsWorld.getGravityAcceleration().multiply(2));

        //GAMEWORLD.setBackground(new Color(102, 255, 153));
        UpdateThread.camera.setPosition(new Vector2(0,0));

        ComponentHandler.addObject(new Pipe(new Vector2(-500,600)));
        ComponentHandler.addObject(new Pipe(new Vector2(-100,600)));
        ComponentHandler.addObject(new Ground());
        ComponentHandler.addObject(new Bird());

        start();
    }

}
