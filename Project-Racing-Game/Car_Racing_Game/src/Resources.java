import javax.imageio.ImageIO;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Ram on 7/6/2016.
 */
    public class Resources {
    public static Image carImage;
    public static Image redCarImage;
    public static Image roadImage;
    public static Image truckImage;
    public static Image baricadeImage;
    public static Image newCarImage;
    public static Image crashBoomImage;
    public static Image finishLineImage;
    public static Image congImage;
    public static Image playPause;

    public static Image welcomeStageImage;
    public static Image welcomeToGameImage;
    public static AudioClip carCrash;
    public static AudioClip carMoving;
    public static AudioClip mainMenuTone;
    public static AudioClip welcomeTone;
    public static AudioClip gameOverTone;
    public static AudioClip finishTone;
    public static AudioClip truckTone;

    private Resources()
    {

    }

    public static void loadResources() {
        try {

            carImage = ImageIO.read(Resources.class.getResource("Images/car.png"));
            playPause = ImageIO.read(Resources.class.getResource("Images/playpause.jpg"));
            welcomeStageImage = ImageIO.read(Resources.class.getResource("Images/welcome.jpg"));
            congImage = ImageIO.read(Resources.class.getResource("Images/com.jpg"));
            finishLineImage = ImageIO.read(Resources.class.getResource("Images/end.jpg"));
            baricadeImage = ImageIO.read(Resources.class.getResource("Images/baar.jpg"));
            newCarImage = ImageIO.read(Resources.class.getResource("Images/newCar.png"));
            crashBoomImage = ImageIO.read(Resources.class.getResource("Images/crash.png"));
            truckImage = ImageIO.read(Resources.class.getResource("Images/truck.png"));
            redCarImage = ImageIO.read(Resources.class.getResource("Images/redCar.png"));
            roadImage = ImageIO.read(Resources.class.getResource("Images/road1.jpg"));
            welcomeToGameImage = ImageIO.read(Resources.class.getResource("Images/start.jpg"));
            carCrash= Applet.newAudioClip(Resources.class.getResource("AudioClips/carcrash.wav"));
            carMoving= Applet.newAudioClip(Resources.class.getResource("AudioClips/carmoving.wav"));
            mainMenuTone= Applet.newAudioClip(Resources.class.getResource("AudioClips/mainmenutone.wav"));
            welcomeTone= Applet.newAudioClip(Resources.class.getResource("AudioClips/welcometone.wav"));
            gameOverTone= Applet.newAudioClip(Resources.class.getResource("AudioClips/gameover.wav"));
            finishTone= Applet.newAudioClip(Resources.class.getResource("AudioClips/finish.wav"));
            truckTone= Applet.newAudioClip(Resources.class.getResource("AudioClips/truckAudio.wav"));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
