import javax.swing.*;

public class GfxCanvas extends JFrame{

    public static GfxCore core;
    public static GfxCanvas canvas;

    public GfxCanvas(){
        core = new GfxCore();
        getContentPane().add(core);

        pack();
        setTitle("Hello, World");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addMouseListener(new GameManager());

        canvas = this;
    }

}
