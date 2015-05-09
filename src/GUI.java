/**
 * Created by Matt on 5/7/2015.
 */
import ddf.minim.*;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class GUI extends PApplet
{
    public static void main(String args[])
    {
        PApplet.main(new String[]{"GUI"});
    }

    StarField starField;
    static PlayerShip playerShip;

    PImage nebula;

    PFont font;
    String dir;

    Asteroid asteroid;

    AudioPlayer player;
    Minim minim;

    public void setup()
    {
        size((int)(displayHeight*1.5),(int)(displayHeight*1.5/1.8), P2D);
        //size(1080,600, P2D);
        frame.setTitle("Space Game Test");
        starField = new StarField(this, 100);
        playerShip = new PlayerShip(this);
        nebula = loadImage("/src/img/nebula.jpg");
        noStroke();
        dir = System.getProperty("user.dir");
        font = createFont(dir + "/src/data/arialbd.ttf", 48);
        textSize((int)(36*(width/640.0)));
        asteroid = new Asteroid(this);
        minim = new Minim(this);
        player = minim.loadFile("/src/sound/music.mp3", 2048);
        player.play();
       // noCursor();
    }

    public void draw()
    {
        background(30, 5, 35);
        //image(nebula,0,0);
        fill(200,200,200,100);

        starField.display();
        starField.move();
        playerShip.display();
        asteroid.display();
        asteroid.checkForLaser();
        text("Laser Charge: " +playerShip.laserCharge, 800,100);
    }

}
