import JavaGameEngine.Components.GameObject;
import JavaGameEngine.Components.Sprite.Sprite;
import JavaGameEngine.msc.Vector2;

public class Background extends GameObject {
    Sprite sprite = new Sprite();

    public Background(){
        setEnabled(false);
        sprite.loadAnimation(new String[]{"/sprites/background-day.png"});
        addChild(sprite);
    }

    @Override
    public void update() {
        super.update();
        setScale(new Vector2(Main.GAMEWORLD.getWidth()*2,Main.GAMEWORLD.getHeight()*2));
    }
}
