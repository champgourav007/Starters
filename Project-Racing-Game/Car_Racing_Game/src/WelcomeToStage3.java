import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Ram on 7/13/2016.
 */
public class WelcomeToStage3 extends State{
    private  int count=0;
    @Override
    public void update(Graphics graphics) {
        if (count==0)
        {
            Resources.finishTone.stop();
            Resources.welcomeTone.loop();
        }
        graphics.drawImage(Resources.welcomeStageImage,0,0,400,700,null);
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font(Font.MONOSPACED,Font.BOLD,40));

        if (count>3)
            graphics.drawString("W",105,250);

        if(count>6)
            graphics.drawString("E", 140, 250);

        if (count>9)
            graphics.drawString("L", 170, 250);

        if (count>12)
            graphics.drawString("C", 195, 250);

        if (count>15)
            graphics.drawString("O", 225, 250);

        if (count>18)
            graphics.drawString("M", 260, 250);

        if (count>21)
            graphics.drawString("E", 295, 250);

        if (count>24)
            graphics.drawString("T", 180, 300);

        if (count>27)
            graphics.drawString("O", 205, 300);

        if (count>30)
            graphics.drawString("S", 95, 350);

        if (count>33)
            graphics.drawString("T", 125, 350);

        if (count>36)
            graphics.drawString("A", 155, 350);

        if (count>39)
            graphics.drawString("G", 190, 350);

        if (count>42)
            graphics.drawString("E", 225, 350);

        if (count>45)
            graphics.drawString("-", 270, 350);

        if (count>48)
            graphics.drawString("3", 295, 350);

        if(count>51&&count%6==0) {
            graphics.drawString("PLAY?", 155, 400);
        }

        count++;


    }

    @Override
    public void onMousepressed(MouseEvent e) {
        Rectangle r = new Rectangle(155,365,130,40);
        if (r.contains(e.getX(),e.getY()))
        {
            GamePanel.currentState= new StageThree();
        }


    }

    @Override
    public void onKeyPresses(KeyEvent e) {

    }
}
