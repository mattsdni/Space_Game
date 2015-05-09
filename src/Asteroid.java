import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by Matt on 5/8/2015.
 */
public class Asteroid
{
    PApplet p;
    PImage asteroid;
    int x,y;
    int laserColor;
    int health;

    Asteroid(PApplet _p)
    {
        p = _p;
        asteroid = p.loadImage("/src/img/asteroid.png");
        x = 300;
        y = 500;
        laserColor = p.color(128,224,255);
        health = 1000;
    }

    public void display()
    {
        if (health > 0)
            p.image(asteroid,x,y);
    }

    public void checkForLaser()
    {
        for (int i = x; i < x+asteroid.width; i++)
        {
            for (int j = y+10; j < y + asteroid.height-10; j++)
            {
                if (p.get(i, j) == laserColor)
                {
                    System.out.println(health);
                    //health--;
                    //broadcast hit location to something to handle sparks
                    p.stroke(255,0,0);
                    p.point(i,j);
                }
            }
        }

        if (pp_collision(asteroid, x, y, GUI.playerShip.ship, p.mouseX- GUI.playerShip.ship.width / 2,p.mouseY - GUI.playerShip.ship.height / 2))
        {
            System.out.println("collision");
        }
    }

    // A pixel width an alpha level below this value is
// considered transparent.
    final int ALPHALEVEL = 20;

    boolean pp_collision(PImage imgA, float aix, float aiy, PImage imgB, float bix, float biy) {
        int topA, botA, leftA, rightA;
        int topB, botB, leftB, rightB;
        int topO, botO, leftO, rightO;
        int ax, ay;
        int bx, by;
        int APx, APy, ASx, ASy;
        int BPx, BPy; //, BSx, BSy;

        topA   = (int) aiy;
        botA   = (int) aiy + imgA.height;
        leftA  = (int) aix;
        rightA = (int) aix + imgA.width;
        topB   = (int) biy;
        botB   = (int) biy + imgB.height;
        leftB  = (int) bix;
        rightB = (int) bix + imgB.width;

        if (botA <= topB  || botB <= topA || rightA <= leftB || rightB <= leftA)
            return false;

        // If we get here, we know that there is an overlap
        // So we work out where the sides of the overlap are
        leftO = (leftA < leftB) ? leftB : leftA;
        rightO = (rightA > rightB) ? rightB : rightA;
        botO = (botA > botB) ? botB : botA;
        topO = (topA < topB) ? topB : topA;


        // P is the top-left, S is the bottom-right of the overlap
        APx = leftO-leftA;
        APy = topO-topA;
        ASx = rightO-leftA;
        ASy = botO-topA-1;
        BPx = leftO-leftB;
        BPy = topO-topB;

        int widthO = rightO - leftO;
        boolean foundCollision = false;

        // Images to test
        imgA.loadPixels();
        imgB.loadPixels();

        // These are widths in BYTES. They are used inside the loop
        //  to avoid the need to do the slow multiplications
        int surfaceWidthA = imgA.width;
        int surfaceWidthB = imgB.width;

        boolean pixelAtransparent = true;
        boolean pixelBtransparent = true;

        // Get start pixel positions
        int pA = (APy * surfaceWidthA) + APx;
        int pB = (BPy * surfaceWidthB) + BPx;

        ax = APx;
        ay = APy;
        bx = BPx;
        by = BPy;
        for (ay = APy; ay < ASy; ay++) {
            bx = BPx;
            for (ax = APx; ax < ASx; ax++) {
                pixelAtransparent = p.alpha(imgA.pixels[pA]) < ALPHALEVEL;
                pixelBtransparent = p.alpha(imgB.pixels[pB]) < ALPHALEVEL;

                if (!pixelAtransparent && !pixelBtransparent) {
                    foundCollision = true;
                    break;
                }
                pA ++;
                pB ++;
                bx++;
            }
            if (foundCollision) break;
            pA = pA + surfaceWidthA - widthO;
            pB = pB + surfaceWidthB - widthO;
            by++;
        }
        return foundCollision;
    }




}
