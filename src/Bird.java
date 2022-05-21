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

        setLayer(100);
        addChild(b);
        setPosition(new Vector2(200,400));
        setScale(new Vector2(70,50));
        setAnimation();
        b.setUseGravity(false);

        addChild(squareCollider);

    }

    @Override
    public void onCollision(Component c) {
        super.onCollision(c);
        if(start==false){
            setPosition(new Vector2(200,400)); //set the player to first pos
            score = 0; //sets score to 0
            Main.pipes1.destroy();
            Main.pipes2.destroy();
            Main.mainScreen.setEnabled(true);
            b.setUseGravity(false);
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
        sprite.setTimer(20); //set how fast animation should play
        addChild(sprite); // add sprite to gameobject
    }

    @Override
    public void update() {
        super.update();

        sprite.setAngle(b.getVelocity().getY()*20); // set bird angle from our y velocity

        //check for space and if it is pressed we add a force up
        if(Input.isKeyPressed(Keys.SPACE)&&b.isUseGravity()){
            b.addForce(Vector2.up,80);
        }
    }
    @Override
    public void draw(Graphics g) {
        super.draw(g); // draw bird and its components
        Graphics g3 = g;
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("minecraft",0,50));

        //g2.drawString("This is gona be awesome",70,20);
        g2.drawString(String.valueOf(score),(Main.GAMEWORLD.getWidth()/2)-(g2.getFont().getSize()/2),50);

    }
}
