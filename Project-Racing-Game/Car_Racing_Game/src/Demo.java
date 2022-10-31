import javax.swing.*;

/**
 * Created by Ram on 7/6/2016.
 */
public class Demo {
    public static JFrame frame;

    public static void main(String[] args) {
        frame =  new JFrame("RoaD RaceR");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        GamePanel panel = new GamePanel();
        frame.setContentPane(panel);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);


    }
}
