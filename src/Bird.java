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

    public static int score = -2;

    public Bird(){
        addChild(b);
        setPosition(new Vector2(200,200));
        setScale(new Vector2(70,50));
        setAnimation();

        squareCollider.setVisible(false);
        addChild(squareCollider);

    }

    @Override
    public void onCollision(Component c) {
        super.onCollision(c);
        if(start==false){
            destroy();
        }
        start = false;

    }

    private void setAnimation(){
        String[] paths = new String[]{
                "/sprites/redbird-downflap.png",
                "/sprites/redbird-midflap.png",
                "/sprites/redbird-upflap.png"};
        sprite.loadAnimation(paths);
        sprite.setTimer(30);
        sprite.setAngle(45);
        addChild(sprite);
    }

    @Override
    public void update() {
        super.update();
        sprite.setAngle(b.getVelocity().getY()*20);
        if(Input.isKeyPressed(Keys.SPACE)){
            b.addForce(Vector2.up,80);
        }

    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
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
