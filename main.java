import javax.swing.*;
public class main {
    public static void main(String[] args){
        Ball.Initialize();
        Paddle.Initialize();
        Bricks.Initialize();
        GameManager.Initialize();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() { GfxCanvas canvas = new GfxCanvas(); }});

    }
}
