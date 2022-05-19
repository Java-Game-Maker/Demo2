import JavaGameEngine.Components.Collider.SquareCollider;
import JavaGameEngine.Components.GameObject;
import JavaGameEngine.Components.Physics.PhysicsBody;
import JavaGameEngine.Components.Sprite.Sprite;
import JavaGameEngine.msc.Vector2;

import java.awt.*;
import java.util.Random;

public class Pipes extends GameObject {
    Pipe pipe1 = new Pipe(); // up pipe
    Pipe pipe2 = new Pipe(); // down pipe
    float speed = 1; // speed of pipes
    boolean score = false;

    public Pipes(Vector2 pos){


        pipe1.sprite.setAngle(180);//set pip sprite to be upsidedown
        pipe1.setLocalPosition(new Vector2(0,-300)); // set pos to 300 (600-300)
        pipe2.setLocalPosition(new Vector2(0,600)); // set pos to 1200 (600+600)

        setPosition(new Vector2(pos.getX(),600)); // set parent to 600

        //add pipes
        addChild(pipe1);
        addChild(pipe2);


    }
    public void reload(){
        Random ran = new Random();

        float gap = pipe1.getScale().getY()+200; //gap between pipes
        int y = ran.nextInt(300)-300; // pipe1 y cord -300-300

        pipe1.setLocalPosition(new Vector2(0,y));
        pipe2.setLocalPosition(new Vector2(0,y+gap)); //set pipe2 y to pip1+gap

        setPosition(new Vector2(Main.GAMEWORLD.getWidth()+100,600));//reset pips pos before player
        score = false; //can check for score
    }

    @Override
    public void update() {
        super.update();
        //if pipes outside frame reload
        if(getPosition().getX()<-500){
            reload();
        }
        //if pipes are at birdpos and score is false (it hasn't been taken yet)
        if(getPosition().getX()<=200 && !score){
            Bird.score++; //add to bird score
            score = true; // score has been taken
        }
        movePosition(getPosition().add(Vector2.left.multiply(speed))); //move pipes left with a speed
        speed += 0.0001f; // increase speed every update
    }

    @Override
    public void draw(Graphics g) {
        //super.draw(g);
        drawChildren(g); // only draws our pip children
    }

    static class Pipe extends GameObject {
        Sprite sprite = new Sprite();
        SquareCollider squareCollider = new SquareCollider();
        public Pipe(){

            PhysicsBody b = new PhysicsBody();
            b.setUseGravity(false); // dont use gravity
            addChild(b);

            setLocalScale(new Vector2(-20,600)); //set scale (local)

            sprite.loadAnimation(new String[]{"/sprites/pipe-green.png"}); // set sprite
            addChild(sprite); // add sprite

            addChild(squareCollider); // add collder
        }
    }
}
