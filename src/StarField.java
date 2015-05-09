import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by Matt on 5/8/2015.
 */
public class StarField
{
    PApplet p;
    Star stars[];
    int numStars;
    PImage star;

    StarField(PApplet _p, int n)
    {
        p = _p;
        numStars = n;
        stars = new Star[numStars];
        star = p.loadImage("/src/img/star.png");
        for (int i = 0; i < numStars; i++)
        {
            stars[i] = new Star(p);
        }
    }

    public void display()
    {
        for (int i = 0; i < numStars; i++)
        {
            p.noStroke();
            stars[i].display();
            //p.image(star, stars[i].x, stars[i].y);
        }

    }

    public void move()
    {
        for (int i = 0; i < numStars; i++)
        {
            stars[i].x-=10*(stars[i].w*.008f);
            if (stars[i].x<0-stars[i].w)
            {
                stars[i].x = p.width;
                stars[i].y = p.random(0,p.height);
            }
        }
    }

}
