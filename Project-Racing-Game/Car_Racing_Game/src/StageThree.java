import java.awt.*;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.*;

/**
 * Created by Ram on 7/21/2016.
 */
public class StageThree extends State {
    private Road road = new Road(12);
    private Car car = new Car();
    private FinalLine finalLine = new FinalLine(12, -8000);
    private newCar newCar1 = new newCar(-400, 15);
    private newCar newCar2 = new newCar(-1100, 15);
    private RedCar redCar1 = new RedCar(-750, 15);
    private RedCar redCar2 = new RedCar(-1450, 15);
    private Truck truck1 = new Truck(-1700, 15);
    private Barricade barricade = new Barricade(-800, 12);
    private int count = 0;
    private java.util.List<Elements> list = new ArrayList<>();
    private java.util.List<RedCar> redCarsArrayList = new ArrayList<>();
    private java.util.List<newCar> newCarArrayList = new ArrayList<>();
    private boolean finishStage = false;
    private int time = 100;

    @Override
    public void update(Graphics graphics) {

        if (count == 0) {
            Resources.welcomeTone.stop();
            Resources.mainMenuTone.stop();
            Resources.carMoving.loop();
        }
        list.clear();
        redCarsArrayList.clear();
        newCarArrayList.clear();
        redCarsArrayList.add(redCar1);
        redCarsArrayList.add(redCar2);
        newCarArrayList.add(newCar1);
        newCarArrayList.add(newCar2);
        list.addAll(redCarsArrayList);
        list.addAll(newCarArrayList);
        list.add(barricade);
        count++;

        //CODE TO REDUCE TIME
        if (count % 10 == 0 && !finishStage)
            time--;

        //CODE TO CHECK INTERSECTION OF CAR WITH BARRICADEOR TRUCK OR TIMES UP
        if (finishStage == false && (barricade.checkIntersection(car)  || time < 0)) {
            for (int i = 0; i < 1000; i++) {
                graphics.drawImage(Resources.crashBoomImage, car.x, car.y, null);
            }

            GamePanel.currentState = new GameOverState();
        }

        //CODE CHECK WHEATHER CAR REACHED FINISH LINE OR NOT
        if (finalLine.checkIntersection(car)) {
            finishStage = true;
            Resources.carMoving.stop();
            Resources.finishTone.play();
            finalLine.yvel = 0;
            for (int i = 0; i < list.size(); i++) {

                list.get(i).hidden = true;
                list.get(i).yvel = 0;

            }
            car.xVel = 0;
            car.yvel = -25;
            road.yvel = 0;

        }

        //CODE TO MOVE TO NEXT STATE
        if (car.y < -1000)
            GamePanel.currentState = new CompleteGame();

        //CODE TO CHECK INTERSECTION OF OTHER ELEMENTS WITH BARRICADES
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).checkIntersection(barricade) && !(list.get(i) instanceof Barricade))
                list.get(i).hidden = true;
        }
        graphics.drawImage(Resources.roadImage, road.x, road.y, null);
        graphics.drawImage(Resources.finishLineImage, finalLine.x, finalLine.y, null);
        graphics.drawImage(Resources.carImage, car.x, car.y, null);
        graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        graphics.drawString("STAGE - 3", 260, 30);

        //CODE TO DISPLAY TIME
        if (!finishStage) {
            graphics.drawString("TIME :" + time + "s", 260, 50);
            graphics.drawImage(Resources.playPause,355, 20, 40, 35,null);
        }

        //CODE TO RESTRICT TO BORN OTHER CARS IN REGION OF TRUCK
        for (int i = 0; i < list.size(); i++) {
            if (truck1.checkIntersection(list.get(i))) {
                if (list.get(i) instanceof Barricade)
                    truck1.hidden = true;
                else
                    truck1.hidden = true;
            }

        }

        //CODE  TO DISPLAY RED CARS
        for (int i = 0; i < redCarsArrayList.size(); i++)
            if (!redCarsArrayList.get(i).hidden)
                graphics.drawImage(Resources.redCarImage, redCarsArrayList.get(i).x, redCarsArrayList.get(i).y, null);

        //CODE TO DISPLAY WHITE CARS
        for (int i = 0; i < newCarArrayList.size(); i++)
            if (!newCarArrayList.get(i).hidden)
                graphics.drawImage(Resources.newCarImage, newCarArrayList.get(i).x, newCarArrayList.get(i).y, null);

        //CODE TO DISPLAY BARRICADE
        if (!barricade.hidden)
            graphics.drawImage(Resources.baricadeImage, barricade.x, barricade.y, null);

        //CODE TO DISPLAY TRUCK
        if (!truck1.hidden)
            graphics.drawImage(Resources.truckImage, truck1.x, truck1.y, null);

        //CODE TO PLAY SOUND OF TRUCK
        if (truck1.y==-190&&!truck1.hidden)
            Resources.mainMenuTone.loop();
        else if (truck1.y==890||truck1.hidden)
            Resources.truckTone.stop();

        //CODE TO CHECK INTERSECTION OF CAR WITH OTHER ELEMENTS
        for (int i = 0; i < list.size(); i++)
        {
            if (!list.get(i).hidden && list.get(i).checkIntersection(car)) {
                if (!finishStage && list.get(i) instanceof Barricade) {
                    GamePanel.currentState = new GameOverState();
                }
                 else {
                    time -= 5;
                    list.get(i).hidden = true;
                }
                Resources.carCrash.play();
                for (int j = 0; j < 1000; j++) {
                    graphics.drawImage(Resources.crashBoomImage, car.x, car.y, null);
                }
            }
        }

        //CODE TO CHECK INTERSECTION OF CAR WITH TRUCK
        if (!finishStage&&!truck1.hidden&&car.checkIntersection(truck1)) {
            Resources.carCrash.play();
            for (int j = 0; j < 1000; j++) {
                graphics.drawImage(Resources.crashBoomImage, car.x, car.y, null);
            }
            GamePanel.currentState = new GameOverState();

        }


        //CODE TO UPDATE POSITION OF EVERY ELEMENT
        road.updatePos();
        car.updatePos();
        truck1.updatePos();
        finalLine.updatePos();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).updatePos();
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
