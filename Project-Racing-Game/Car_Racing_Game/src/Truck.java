/**
 * Created by Ram on 7/13/2016.
 */
public class Truck extends Elements {

    public Truck(int origin,int vel)
    {
        this.setXRandom(0,300);
        this.y=origin;
        this.yvel=vel;
        this.width=90;
        this.height=150;
        this.hidden=false;
    }

    public void checkBound()
    {
        if (this.y>1000)
        {
            this.setXRandom(0,300);
            this.y=-1500;
            this.hidden=false;
        }
    }
}
