import JavaGameEngine.Backend.ComponentHandler;
import JavaGameEngine.Backend.UpdateThread;
import JavaGameEngine.Components.Physics.PhysicsWorld;
import JavaGameEngine.JavaGameEngine;
import JavaGameEngine.msc.Vector2;

import javax.swing.*;

public class Main extends JavaGameEngine {


    public static MainScreen mainScreen = new MainScreen();
    public static Pipes pipes1;
    public static Pipes pipes2;
    public static Bird bird = new Bird();
    public static Ground ground = new Ground();
    public static void main(String[] args){
        UpdateThread.camera.setPosition(new Vector2(0,0));//Sets the camera to 0

        init(); // Init the world

        //Creating a new frame
        JFrame frame = new JFrame("Flappy bird");
        frame.setSize(600,1080);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        PhysicsWorld.setGravityAcceleration(PhysicsWorld.getGravityAcceleration().multiply(2));//Make the graviy 2x


        //Add all the objects
        ComponentHandler.addObject(new Background());
        ComponentHandler.addObject(ground);
        ComponentHandler.addObject(bird);
        ComponentHandler.addObject(mainScreen);

        start(); //start the game
    }

}
