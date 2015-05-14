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


    AudioPlayer player;
    Minim minim;
    AudioOutput out;

    static StateMachine gGameMode;


    public void setup()
    {
        size((int)(displayHeight*1.5),(int)(displayHeight*1.5/1.8), P2D);
        //size(1080,600, P2D);
        frame.setTitle("Space Game Test");
        //nebula = loadImage("/src/img/nebula.jpg");

        minim = new Minim(this);
        player = minim.loadFile("/src/sound/level1.mp3", 4096);
        out = minim.getLineOut();
        //player.play();

        gGameMode = new StateMachine();

        gGameMode.Push("mainmenu", new MainMenuState(this));
        //gGameMode.Push("gameplay", new GamePlayState(this));

       // noCursor();
    }

    public void draw()
    {
        if(gGameMode.mStack.isEmpty())
        {
            System.exit(0);
        }
        gGameMode.Update();
        gGameMode.Render();
    }

    public void keyPressed()
    {
        if(keyCode==ESC || key == ESC)
        {
            key = 0;
            keyCode = 0;
            gGameMode.Pop();
        }
    }

    public void keyReleased()
    {
        if(keyCode==ESC || key == ESC)
        {
            key = 0;
            keyCode = 0;
        }
    }

    public void keyTyped()
    {
        if(keyCode==ESC || key == ESC)
        {
            key = 0;
            keyCode = 0;
        }
    }


}
