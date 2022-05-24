import JavaGameEngine.Backend.ComponentHandler;
import JavaGameEngine.Backend.Input.Input;
import JavaGameEngine.Backend.Input.Keys;
import JavaGameEngine.Components.GameObject;
import JavaGameEngine.UI.Button;
import JavaGameEngine.msc.Vector2;

import java.awt.*;

public class MainScreen extends GameObject {

    String text1 = "Get ready";
    Button start = new Button("Start"){
        @Override
        public void onPress() {
            startGame();
        }
    };

    public void startGame(){
        System.out.println("aw");
        Main.bird.b.setUseGravity(true);
        setEnabled(false);
        Main.pipes1 = new Pipes(new Vector2(600,600));
        Main.pipes2 = new Pipes(new Vector2(1000,600));
        Main.ground.destroy();
        Main.ground = new Ground();
        instantiate(Main.pipes1);
        instantiate(Main.pipes2);
        instantiate(Main.ground);
    }

    public MainScreen(){
        addChild(start);
    }

    @Override
    public void update() {
        super.update();
        if(Input.isKeyDown(Keys.SPACE)){
            startGame();
        }
    }

    @Override
    public void draw(Graphics g) {
        if(isEnabled()){
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setFont(new Font("minectaft",0,30));

            //g2.drawString("This is gona be awesome",70,20);
            g2.drawString(text1,(Main.GAMEWORLD.getWidth()/2)-(g2.getFont().getSize()*2),100);
            start.setLocalPosition(new Vector2(Main.GAMEWORLD.getWidth()/2-(this.start.getScale().getX()*1.5f),200));
            drawChildren(g);
        }
    }
}
