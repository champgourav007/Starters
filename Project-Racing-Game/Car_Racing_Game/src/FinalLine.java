/**
 * Created by Ram on 7/13/2016.
 */
public class FinalLine extends Elements {
    public FinalLine(int vel,int origin)
    {
        this.x=0;
        this.y=origin;
        this.width=400;
        this.height=30;
        this.yvel=vel;
    }

    @Override
    public void checkBound() {

    }
}
