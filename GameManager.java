import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameManager implements MouseListener {

    private static boolean running;
    private static Image sprite;
    private static int lives;
    private static int score;


    public static void Initialize(){
        running = true;
        sprite = (new ImageIcon("src/resources/game_over.png").getImage());
        lives = 3;
        score = 0;
    }

    public static void Update(){

        GfxCanvas.canvas.setTitle("Breakout! Lives: "+ lives + ", Score: "+ score);

        if(checkForVictory()){
            if (running) {
                Sound.Play("win");
            }

            running = false;
        }
        if(checkForFailure()){
            if (running){
                Sound.Play("explosion");
            }
            if (lives == 0){
                running = false;
            }
            else {
                lives--;
                Ball.Initialize();
            }
        }
    }



    public static void Draw(Graphics graphics, JPanel panel){
        if (!running){
            graphics.drawImage(sprite, 400 - 240, 300, panel);
        }
    }


    public static boolean isRunning() {
        return running;
    }

    public static boolean checkForFailure(){
        return Ball.getY() > 600;
    }

    public static boolean checkForVictory(){
        boolean result = false;
        int total_health = 0;
        for (int y = 0; y < Bricks.HEIGHT; y++){
            for (int x = 0; x < Bricks.WIDTH; x++){
                total_health += Bricks.getHealth(x,y);
            }
        }
        if (total_health == 0){
            result = true;
        }
        return result;
    }


    public static void addToScore(int points){
        score += points;
    }

    public void mouseClicked(MouseEvent e) {
        if (!isRunning()){
            Ball.Initialize();
            Paddle.Initialize();
            Bricks.Initialize();
            GameManager.Initialize();
        }
    }


    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
