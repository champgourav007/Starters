import java.util.Random;

/**
 * Created by Ram on 7/6/2016.
 */
public class Road extends Elements{
    public Road(int vel)
    {
        this.x=0;
        this.y=-9000;
        this.yvel=vel;

    }

    public void checkBound()
    {
        if (this.y>-10)
            this.y=-9300;

    }

}
