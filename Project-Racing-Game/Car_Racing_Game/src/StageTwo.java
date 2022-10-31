import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ram on 7/14/2016.
 */
public class StageTwo extends State {
    private Road road = new Road(11);
    private Car car = new Car();
    private FinalLine finalLine = new FinalLine(12,-8000);
    private newCar newCar1 = new newCar(-400,15);
    private newCar newCar2 = new newCar(-900,15);
    private newCar newCar3 = new newCar(-1400,15);
    private RedCar redCar1 = new RedCar(-650,15);
    private RedCar redCar2= new RedCar(-1150,15);
    private Barricade barricade = new Barricade(-800,11);
    private int count=0;
    private List<Elements> list = new ArrayList<>();
    private List<RedCar> redCarsArrayList = new ArrayList<>();
    private List<newCar> newCarArrayList = new ArrayList<>();
    private boolean finishStage=false;
    private int time=100;




    @Override
    public void update(Graphics graphics) {


        if (count==0)
        {

            Resources.welcomeTone.stop();
            Resources.mainMenuTone.stop();
            Resources.carMoving.loop();

        }
        redCarsArrayList.clear();
        newCarArrayList.clear();;
        list.clear();
        redCarsArrayList.add(redCar1);
        redCarsArrayList.add(redCar2);
        newCarArrayList.add(newCar1);
        newCarArrayList.add(newCar2);
        newCarArrayList.add(newCar3);
        list.addAll(redCarsArrayList);
        list.addAll(newCarArrayList);

        list.add(barricade);
        count++;

        //CODE TO REDUCE TIME
        if (count%10==0&&!finishStage)
            time--;

        //CODE TO CHECK INTERSECTION OF CAR WITH BARRICADE OR TIMES UP
        if (finishStage==false&&barricade.checkIntersection(car)||time<0) {
            for (int i=0;i < 1000;i++)
            {
                graphics.drawImage(Resources.crashBoomImage, car.x, car.y, null);
            }
            GamePanel.currentState = new GameOverState();
        }

        //CODE TO CHECK WHEATHER CAR REACHES FINISH LINE OR NOT
        if (finalLine.checkIntersection(car))
        {
            finishStage=true;
            Resources.carMoving.stop();
            Resources.finishTone.play();
            finalLine.yvel=0;
            for (int i = 0 ; i <list.size();i++)
            {

                list.get(i).hidden = true;
                list.get(i).yvel = 0;

            }
            car.xVel=0;
            car.yvel=-25;
            road.yvel=0;

        }

        // CODE TO MOVE TO NEXT STAGE
        if (car.y<-1000)
            GamePanel.currentState= new WelcomeToStage3();

        //CODE TO CHECK INTERSECTION OF OTHER CARS WITH BARRICADES
        for (int i=0;i<list.size();i++)
        {
            if (list.get(i).checkIntersection(barricade)&&!(list.get(i) instanceof  Barricade))
                list.get(i).hidden=true;
        }
        //CODE TO DRAW THESE ELEMENTS
        graphics.drawImage(Resources.roadImage,road.x,road.y,null);
        graphics.drawImage(Resources.finishLineImage,finalLine.x,finalLine.y,null);
        graphics.drawImage(Resources.carImage,car.x,car.y,null);
        graphics.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
        graphics.drawString("STAGE - 2",260,30);

        //CODE TO DISPLAY TIME AND PLAY PAUSE BUTTON
        if (!finishStage) {
            graphics.drawString("TIME :" + time + "s", 260, 50);
            graphics.drawImage(Resources.playPause,355, 20, 40, 35,null);
        }

        //CODE TO DISPLAY RED CARS
        for (int i = 0 ; i<redCarsArrayList.size();i++)
            if (!redCarsArrayList.get(i).hidden)
            graphics.drawImage(Resources.redCarImage, redCarsArrayList.get(i).x, redCarsArrayList.get(i).y,null);

        //CODE TO DISPLAY WHITE CARS
        for (int i = 0 ;i<newCarArrayList.size();i++)
            if (!newCarArrayList.get(i).hidden)
            graphics.drawImage(Resources.newCarImage, newCarArrayList.get(i).x, newCarArrayList.get(i).y,null);

        //CODE TO DISPLAY BARRICADE
        graphics.drawImage(Resources.baricadeImage, barricade.x, barricade.y,null);

        //CODE TO CHECK INTERSECTION OF CAR WITH OTHER ELEMENTS
        for (int i=0;i<list.size();i++)
        {
            if (car.checkIntersection(list.get(i))&&!list.get(i).hidden)
            {
                time-=5;

                if (!finishStage&&list.get(i) instanceof Barricade)
                    GamePanel.currentState=new GameOverState();
                else {
                    Resources.carCrash.play();
                    list.get(i).hidden = true;
                }
                for (int j=0;j < 1000;j++)
                {
                    graphics.drawImage(Resources.crashBoomImage, car.x, car.y, null);
                }
            }
        }



        //CODE TO UPDATE POSITIONS OF EVERY ELEMENTS
        road.updatePos();
        car.updatePos();
        finalLine.updatePos();
       for (int i = 0 ; i <list.size();i++)
       {
           list.get(i).updatePos();
       }

    }

    @Override
    public void onMousepressed(MouseEvent e) {
        Elements.pause(e);

    }

    @Override
    public void onKeyPresses(KeyEvent e) {
        Elements.carHandling(e,car);

}
}
