import JavaGameEngine.Components.Collider.SquareCollider;
import JavaGameEngine.Components.GameObject;
import JavaGameEngine.Components.Physics.PhysicsBody;
import JavaGameEngine.Components.Sprite.Sprite;
import JavaGameEngine.msc.Vector2;

public class Ground extends GameObject {

    Sprite groundSprite = new Sprite();
    PhysicsBody physicsBody = new PhysicsBody();
    SquareCollider squareCollider = new SquareCollider();
    public Ground(){
        groundSprite.loadAnimation(new String[]{"/sprites/base.png"});
        groundSprite.setTimer(30);
        addChild(groundSprite);

        physicsBody.setUseGravity(false);
        addChild(physicsBody);
        squareCollider.setVisible(true);
        addChild(squareCollider);

    }

    @Override
    public void update() {
        super.update();
        setScale(new Vector2(Main.GAMEWORLD.getWidth()*2,300));
        setPosition(new Vector2(300,Main.GAMEWORLD.getHeight()));
    }
}
