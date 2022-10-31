import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Ram on 7/13/2016.
 */
public class CompleteGame extends State{
    private int count=0;

    @Override
    public void update(Graphics graphics) {
        graphics.setFont(new Font("SansSerif",Font.PLAIN,40));
        if (count==0) {
            Resources.finishTone.stop();
            Resources.mainMenuTone.loop();
            count++;
        }



        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,400,700);
        graphics.drawImage(Resources.congImage,0,100,400,400,null);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("SansSerif",Font.PLAIN,35));
        graphics.drawString("PLAY AGAIN?",90,550);
        graphics.setFont(new Font("SansSerif",Font.PLAIN,30));
        graphics.drawString("YES",105,600);
        graphics.drawString("NO",220,600);




    }

    @Override
    public void onMousepressed(MouseEvent e) {
        Rectangle r = new Rectangle(105,570,60,40);
        Rectangle r1 = new Rectangle(220,570,50,40);
        if (r.contains(e.getX(),e.getY()))
        {
            GamePanel.currentState= new MenuState();
        }
        if (r1.contains(e.getX(),e.getY()))
            System.exit(0);


    }

    @Override
    public void onKeyPresses(KeyEvent e) {

    }
}
