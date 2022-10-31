import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.FileReader;

/**
 * Created by Ram on 7/6/2016.
 */
public class GamePanel extends JPanel implements KeyListener,Runnable,MouseListener{


    private static Image tempImage;
    public static  State currentState;
    public static boolean pause=false;

    public GamePanel()
    {

        super();
        this.setPreferredSize(new Dimension(400,700));
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.setFocusable(true);
        this.requestFocus(true);

    }

    public void addNotify()
    {
        super.addNotify();
        Resources.loadResources();

        GamePanel.currentState= new MenuState();
        tempImage= new BufferedImage(400,700,BufferedImage.TYPE_INT_RGB);
        Thread thread = new Thread(this,"gameLoopThread");
        thread.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        GamePanel.currentState.onKeyPresses(e);

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {


        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (pause)
                continue;



            Graphics imageGraphics=tempImage.getGraphics();
            Graphics panelGraphics=this.getGraphics();

           imageGraphics.clearRect(0,0,400,700);

            GamePanel.currentState.update(imageGraphics);
            imageGraphics.setFont(new Font(Font.MONOSPACED,Font.PLAIN,15));
            imageGraphics.setColor(Color.WHITE);
            imageGraphics.drawString("Developed by Rambabu", 30, 30);
            imageGraphics.dispose();

            panelGraphics.drawImage(tempImage, 0, 0, null);
            panelGraphics.dispose();


        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        GamePanel.currentState.onMousepressed(e);

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
