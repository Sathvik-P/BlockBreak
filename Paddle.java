import java.awt.*;
import javax.swing.*;

public class Paddle {
    private static Image sprite;
    private static double x;
    private static double y;


    public static void Initialize(){
        sprite = (new ImageIcon("src/resources/paddle.png")).getImage();
        x = 400 - 32;
        y = 600 - 48;
    }

    public static void Update(){

        if (!GameManager.isRunning()){
            return;
        }

        int mouse_x = MouseInfo.getPointerInfo().getLocation().x -
                GfxCanvas.core.getLocationOnScreen().x - 32;
        x += (mouse_x - x) * 0.1;

        if (x < 0){
            x = 0;
        }
        else if (x > 800-64){
            x = 800 - 64;
        }
    }

    public static void Draw(Graphics graphics, JPanel panel){
        graphics.drawImage(sprite,(int)x,(int)y,panel);
    }

    public static double getX() {
        return x;
    }

    public static double getY() {
        return y;
    }
}


