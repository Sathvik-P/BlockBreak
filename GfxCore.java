import java.awt.*;
import javax.swing.*;

public class GfxCore extends JPanel{

    public GfxCore(){
        setPreferredSize(new Dimension(800,600));

    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        setBackground(Color.LIGHT_GRAY);

        //ALL UPDATE AND DRAWING CODE GOES HERE:
        Ball.Update();
        Paddle.Update();
        GameManager.Update();

        Ball.Draw(graphics, this);
        Paddle.Draw(graphics,this);
        Bricks.Draw(graphics, this);
        GameManager.Draw(graphics, this);

        //LOOP
        try {
            Thread.sleep(16L);
        }
        catch (InterruptedException e){

        }
        repaint();

    }

}


