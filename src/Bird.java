import JavaGameEngine.Backend.ComponentHandler;
import JavaGameEngine.Backend.Input.Input;
import JavaGameEngine.Backend.Input.Keys;
import JavaGameEngine.Backend.UpdateThread;
import JavaGameEngine.Components.Collider.SquareCollider;
import JavaGameEngine.Components.Component;
import JavaGameEngine.Components.GameObject;
import JavaGameEngine.Components.Physics.PhysicsBody;
import JavaGameEngine.Components.Sprite.Sprite;
import JavaGameEngine.msc.Vector2;

import java.awt.*;

public class Bird extends GameObject {
    Sprite sprite = new Sprite();
    PhysicsBody b = new PhysicsBody();
    SquareCollider squareCollider = new SquareCollider();
    boolean start = true;

    public static int score = 0;

    public Bird(){

        addChild(b);
        setPosition(new Vector2(200,200));
        setScale(new Vector2(70,50));
        setAnimation();

        addChild(squareCollider);

    }

    @Override
    public void onCollision(Component c) {
        super.onCollision(c);
        if(start==false){
            setPosition(new Vector2(200,200)); //set the player to first pos
            score = 0; //sets score to 0
        }
        start = false;

    }

    private void setAnimation(){
        //List of spirtes to use in my animation
        String[] paths = new String[]{
                "/sprites/redbird-downflap.png",
                "/sprites/redbird-midflap.png",
                "/sprites/redbird-upflap.png"};
        //load animation
        sprite.loadAnimation(paths);
        sprite.setTimer(30); //set how fast animation should play
        addChild(sprite); // add sprite to gameobject
    }

    @Override
    public void update() {
        super.update();

        sprite.setAngle(b.getVelocity().getY()*20); // set bird angle from our y velocity

        //check for space and if it is pressed we add a force up
        if(Input.isKeyPressed(Keys.SPACE)){
            b.addForce(Vector2.up,80);
        }

    }

    @Override
    public void draw(Graphics g) {
        super.draw(g); // draw bird and its components
        // draw score with font
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh =
                new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        g2d.setFont(new Font("minecraft", Font.PLAIN, 50));

        g2d.drawString(Integer.toString(score), Main.GAMEWORLD.getWidth()/2, 50);
    }
}
