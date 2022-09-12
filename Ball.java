import java.awt.*;
import javax.swing.*;

public class Ball {
    private static Image sprite;
    private static double x;
    private static double y;
    private static double speed_x;
    private static double speed_y;

    public static void Initialize(){
        sprite = (new ImageIcon("src/resources/ball.png").getImage());
        x = 200;
        y = 200;
        speed_x = 1.5;
        speed_y = 1.5;
    }

    public static void Update(){

        double last_good_x = x;
        double last_good_y = y;

        x += speed_x;
        y += speed_y;
        if (x > 800-12) {              //RIGHT WALL
            x = 800 - 12;
            speed_x*=-1;
            Sound.Play("wall");
        }
        else if(x < 0){                //LEFT WALL
            x = 0;
            speed_x *= -1;
            Sound.Play("wall");
        }
         if(y < 0){                   //CEILING
            y = 0;
            speed_y *= -1.25;
            speed_x *= 1.25;
            Sound.Play("wall");
        }

         if (CheckForBoxCollision((int)x,(int)y,12,12,(int)Paddle.getX(),(int)Paddle.getY(),64,12)) {
             y = Paddle.getY() - 12;
             speed_y *= -1;
             Sound.Play("wall");
         }

         //BRICKS
        for(int i = 0; i < Bricks.HEIGHT; i++){
            for(int j = 0; j < Bricks.WIDTH; j++){
                if (Bricks.getHealth(j,i) > 0) {
                    if (CheckForBoxCollision((int) x, (int) y, 12, 12, Bricks.getScreenX(j), Bricks.getScreenY(i), 48, 24))
                    {
                        Bricks.Hit(j,i);

                        x = last_good_x;
                        y = last_good_y;

                        int brick_x = Bricks.getScreenX(j);
                        int brick_y = Bricks.getScreenY(i);
                        if(y >= brick_y + 24 || y + 12 <= brick_y){
                            speed_y *= -1.1;
                        }
                        if(x >= brick_x + 48 || x + 12 <= brick_x){
                            speed_x *= -1.1;
                        }

                    }
                }
            }
        }

        if (speed_x < -6){
            speed_x = -6;
        }
        else if (speed_x > 6){
            speed_x = 6;
        }
        if (speed_y < -6){
            speed_y = -6;
        }
        else if (speed_y > 6){
            speed_y = 6;
        }

    }

    public static void Draw(Graphics graphics, JPanel panel){

        graphics.drawImage(sprite, (int)x, (int)y, panel);
    }

    private static boolean CheckForBoxCollision(int obj1_x, int obj1_y, int obj1_width, int obj1_height, int obj2_x, int obj2_y, int obj2_width, int obj2_height) {
        // ASSUME THEY DON'T OVERLAP
        boolean result = false;
        // CHECK FOR AN OVERLAP
        if (obj1_x < obj2_x + obj2_width &&
                obj1_x + obj1_width > obj2_x &&
                obj1_y < obj2_y + obj2_height &&
                obj1_y + obj1_height > obj2_y) { // WHEW!!
            result = true; // <-- COLLISION
        }
        // RETURN THE RESULTS
        return result;
    }


    public static double getY() {
        return y;
    }
}
