import java.awt.*;
import java.util.Random;

/**
 * Created by Ram on 7/13/2016.
 */
public class Barricade extends Elements {
    private Random random = new Random();

    public Barricade(int origin,int vel)
    {
        this.setX();
        this.y=origin;
        this.yvel=vel;
        this.width=200;
        this.height=40;
    }

    public void checkBound()
    {
        if (this.y>800)
        {
            this.y=-400;
            this.setX();
            this.hidden=false;
        }
    }

    private void setX()
    {
        int r= random.nextInt(2);
        if (r==0)
            this.x=0;
        else
            this.x=200;
    }


}
