import JavaGameEngine.Components.GameObject;
import JavaGameEngine.Components.Sprite.Sprite;
import JavaGameEngine.msc.Vector2;

public class Background extends GameObject {
    Sprite sprite = new Sprite();
    Sprite sprite2 = new Sprite();
    private float speed = 0.5f;

    public Background(){
        setEnabled(true);
        sprite.loadAnimation(new String[]{"/sprites/background-day.png"});
        sprite2.loadAnimation(new String[]{"/sprites/background-day.png"});
        sprite2.setLocalPosition(new Vector2(Main.GAMEWORLD.getWidth(),0));
        addChild(sprite);
        addChild(sprite2);
    }
    boolean first = true;
    @Override
    public void update() {
        super.update();
        if(sprite.getLocalPosition().getX()<-Main.GAMEWORLD.getWidth()*2){
            sprite.setLocalPosition(new Vector2(Main.GAMEWORLD.getWidth()*2,0));
        }
        if(sprite2.getLocalPosition().getX()<-Main.GAMEWORLD.getWidth()*2){
            sprite2.setLocalPosition(new Vector2(Main.GAMEWORLD.getWidth()*2,0));
        }

        if((first) && (Main.GAMEWORLD.getWidth() > 0)){
            first=false;
            sprite2.setLocalPosition(new Vector2(Main.GAMEWORLD.getWidth()*2,0));
        }
        sprite.setLocalPosition(sprite.getLocalPosition().add(Vector2.left.multiply(speed)));
        sprite2.setLocalPosition(sprite2.getLocalPosition().add(Vector2.left.multiply(speed)));

        setScale(new Vector2(Main.GAMEWORLD.getWidth()*2,Main.GAMEWORLD.getHeight()*2));
    }
}
