import JavaGameEngine.Components.Collider.SquareCollider;
import JavaGameEngine.Components.GameObject;
import JavaGameEngine.Components.Physics.PhysicsBody;
import JavaGameEngine.Components.Sprite.Sprite;
import JavaGameEngine.msc.Vector2;

import java.awt.*;
import java.util.Random;

public class Pipe extends GameObject {
    Pip pip1 = new Pip();
    Pip pip2 = new Pip();
    float speed = 1;

    public Pipe(Vector2 pos){


        pip1.sprite.setAngle(180);

        setPosition(new Vector2(pos.getX(),600));

        addChild(pip1);
        addChild(pip2);


    }
    boolean score = false;
    public void reload(){
        Random ran = new Random();
        float gap = pip1.getScale().getY()+200;
        int y = ran.nextInt(300)-300;
        pip1.setLocalPosition(new Vector2(0,y));
        pip2.setLocalPosition(new Vector2(0,y+gap));
        System.out.println("reload");
        setPosition(new Vector2(Main.GAMEWORLD.getWidth()+100,600));
        score = false;
    }

    @Override
    public void update() {
        super.update();
        if(getPosition().getX()<-500){
            reload();
        }
        if(getPosition().getX()<=200 && !score){
            Bird.score++;
            score = true;
        }
        movePosition(getPosition().add(Vector2.left.multiply(speed)));
        speed += 0.0001f;
    }

    @Override
    public void draw(Graphics g) {
        //super.draw(g);
        drawChildren(g);
    }

    static class Pip extends GameObject {
        Sprite sprite = new Sprite();
        SquareCollider squareCollider = new SquareCollider();
        public Pip(){
           // setPosition(new Vector2(200,500));
            PhysicsBody b = new PhysicsBody();
            b.setUseGravity(false);
            addChild(b);
            setLocalScale(new Vector2(-20,600));
            sprite.loadAnimation(new String[]{"/sprites/pipe-green.png"});
            addChild(sprite);

            squareCollider.setVisible(true);
            addChild(squareCollider);
        }
    }
}
