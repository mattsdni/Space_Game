import processing.core.PApplet;

import java.util.Random;

/**
 * Created by Matt on 5/8/2015.
 */
public class Star
{
    float x,y,w,h;
    PApplet p;

    Star(PApplet _p)
    {
        p = _p;
        x = p.random(0,p.width);
        y = p.random(0,p.height);
        w = p.random(p.width * .03f, p.width*.09f);
        h = w*.05f;
    }

    public void display()
    {
        p.rect(x,y,w,h);
    }

}
