
import java.awt.*;
import javax.swing.*;

public class Bricks {
    private static Image[] sprite;
    public static final int WIDTH = 12;
    public static final int HEIGHT = 6;

    private static int[][] brick;


        public static void Initialize() {
                sprite = new Image[3];
                sprite[0] = (new ImageIcon("src/resources/brick1.png")).getImage();
                sprite[1] = (new ImageIcon("src/resources/brick2.png")).getImage();
                sprite[2] = (new ImageIcon("src/resources/brick3.png")).getImage();
                brick = new int[][] {   {3,3,3,3,3,3,3,3,3,3,3,3 },
                        {3,3,3,3,3,3,3,3,3,3,3,3},
                        {2,2,2,2,2,2,2,2,2,2,2,2 },
                        {2,2,2,2,2,2,2,2,2,2,2,2},
                        {1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1}  };
        }

        public static void Draw(Graphics graphics, JPanel panel){
            for (int y = 0; y < HEIGHT; y++){
                for (int x = 0; x < WIDTH; x++){
                    if (brick[y][x] >0 ){
                        graphics.drawImage(sprite[brick[y][x]-1], 112 + x * 48, 56 + y * 24, 48, 24, panel);
                    }
                }
            }
        }


        public static void Hit(int x, int y){
            brick[y][x]--;
            if (brick[y][x] == 0){
                GameManager.addToScore(1000);
                Sound.Play("brick_break");
            }
            else {
                GameManager.addToScore(100);
                Sound.Play("brick_hit");
            }
        }

        public static int getScreenX(int x){
            return 112 + x * 48;
        }

        public static int getScreenY(int y) {
            return 56 + y * 24;
        }

        public static int getHealth(int x, int y){
            return brick[y][x];
        }

}
