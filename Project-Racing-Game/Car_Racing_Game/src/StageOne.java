import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ram on 7/6/2016.
 */
public class StageOne extends State {

    private int time = 100;
    private Car car = new Car();
    private RedCar redCar1 = new RedCar(-300, 14);
    private RedCar redCar2 = new RedCar(-615, 14);
    private RedCar redCar3 = new RedCar(-930, 14);
    private Barricade barricade = new Barricade(-600, 10);
    private FinalLine finalLine = new FinalLine(10, -6000);
    private Road road = new Road(10);
    private boolean finishStage = false;

    public List<RedCar> redCarList = new ArrayList<>();


    private int count = 0;

    @Override
    public void update(Graphics graphics) {

        if (count == 0) {
            redCarList.add(redCar1);
            redCarList.add(redCar2);
            redCarList.add(redCar3);
            Resources.welcomeTone.stop();
            Resources.carMoving.loop();
        }
        count++;

        //CODE TO REDUCE TIME
        if (count % 10 == 0 && !finishStage)
            time--;

        //CODE TO DRAW ROAD
        graphics.drawImage(Resources.roadImage, road.x, road.y, null);

        //CODE TO DRAW FINISH LINE
        graphics.drawImage(Resources.finishLineImage, finalLine.x, finalLine.y, null);

        //CODE TO DRAW CAR
        graphics.drawImage(Resources.carImage, car.x, car.y, null);

        //CODE TO DRAW BARRICADE
        if (!barricade.hidden)
            graphics.drawImage(Resources.baricadeImage, barricade.x, barricade.y, null);

        //CODE TO DRAW RED CARS
        for (int i = 0; i < redCarList.size(); i++) {
            redCarList.get(i).updatePos();
            if (redCarList.get(i).hidden == false)
                graphics.drawImage(Resources.redCarImage, redCarList.get(i).x, redCarList.get(i).y, null);
        }

        graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        graphics.drawString("STAGE - 1", 260, 30);

        //CODE TO SHOW TIME AND PLAY PAUSE BUTTON
        if (!finishStage) {
            graphics.drawString("TIME :" + time + "s", 260, 50);
           graphics.drawImage(Resources.playPause,355, 20, 40, 35,null);
        }

        //CODE TO CHECK WHEATHER CAR REACHED FINISH LINE OR NOT
        if (finalLine.checkIntersection(car)) {
            finishStage = true;
            Resources.carMoving.stop();
            Resources.finishTone.play();
            finalLine.yvel = 0;
            for (int i = 0; i < redCarList.size(); i++) {
                redCarList.get(i).hidden = true;
                redCarList.get(i).yvel = 0;

            }
            barricade.hidden = true;
            car.xVel = 0;
            car.yvel = -25;
            road.yvel = 0;
            barricade.yvel = 0;

        }

        //CODE TO CHECK INTERSECTION OF CAR WITH BARRICADE OR TIMES UP
        if (finishStage == false && barricade.checkIntersection(car) || time < 0) {
            Resources.carCrash.play();
            for (int i = 0; i < 1000; i++) {
                graphics.drawImage(Resources.crashBoomImage, car.x, car.y, null);
            }
            GamePanel.currentState = new GameOverState();
        }

        //CODE TO MOVE TO SECOND STAGE
        if (car.y < -1000)
            GamePanel.currentState = new WelcomeToStage2();

        //CODE TO HIDE RED CARS WHEN THEY HIT BARRICADE
        for (int i = 0; i < redCarList.size(); i++) {
            if (redCarList.get(i).checkIntersection(barricade))
                redCarList.get(i).hidden = true;
        }

        //CODE TO UPDATE POSITIONS OF EVERY ELEMENT
        road.updatePos();
        finalLine.updatePos();
        car.updatePos();
        barricade.updatePos();

        //CODE TO CHECK INTERSECTION OF CAR WITH RED CARS
        for (int i = 0; i < redCarList.size(); i++) {
            if ((redCarList.get(i).hidden == false && car.checkIntersection(redCarList.get(i)) && !finishStage)) {
                redCarList.get(i).hidden = true;
                Resources.carCrash.play();

                for (int j = 0; j < 5000; j++)
                    graphics.drawImage(Resources.crashBoomImage, car.x, car.y, null);

                time -= 5;
            }

        }
    }


    @Override
    public void onMousepressed(MouseEvent e) {
        Elements.pause(e);


    }

    @Override
    public void onKeyPresses(KeyEvent e) {
        Elements.carHandling(e, car);
    }
}
