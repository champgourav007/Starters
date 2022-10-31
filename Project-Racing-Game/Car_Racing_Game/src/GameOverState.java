import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Ram on 7/6/2016.
 */
public class GameOverState extends State {
    private Object[] options = {"PLAY AGAIN",
            "EXIT",};
    private int n;
    @Override
    public void update(Graphics graphics)
    {


        Resources.carMoving.stop();
        Resources.gameOverTone.loop();

        n = JOptionPane.showOptionDialog(Demo.frame,
                "GAME OVER!!",
                "THE CAR GAME",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,null,
                options,
                options[1]);

        if (n==0)
            GamePanel.currentState= new MenuState();
        else
            System.exit(0);
    }

    @Override
    public void onMousepressed(MouseEvent e) {


    }

    @Override
    public void onKeyPresses(KeyEvent e) {

    }
}
