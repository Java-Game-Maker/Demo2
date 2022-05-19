import JavaGameEngine.Backend.ComponentHandler;
import JavaGameEngine.Backend.UpdateThread;
import JavaGameEngine.Components.Physics.PhysicsWorld;
import JavaGameEngine.JavaGameEngine;
import JavaGameEngine.msc.Vector2;

import javax.swing.*;

public class Main extends JavaGameEngine {



    public static void main(String[] args){

        init(); // Init the world

        //Creating a new frame
        JFrame frame = new JFrame("Flappy bird");
        frame.setSize(600,1080);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        PhysicsWorld.setGravityAcceleration(PhysicsWorld.getGravityAcceleration().multiply(2));//Make the graviy 2x

        UpdateThread.camera.setPosition(new Vector2(0,0));//Sets the camera to 0

        //Add all the objects
        ComponentHandler.addObject(new Pipes(new Vector2(600,600)));
        ComponentHandler.addObject(new Pipes(new Vector2(1000,600)));
        ComponentHandler.addObject(new Ground());
        ComponentHandler.addObject(new Bird());

        start(); //start the game
    }

}
