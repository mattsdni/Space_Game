import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by Matt on 5/8/2015.
 */
public class PlayerShip
{
    PApplet p;
    double health;
    float x,y;
    PImage ship;
    PImage thrusters[];
    int thrusterCycle;
    int laserCharge;

    PlayerShip(PApplet _p)
    {
        p=_p;
        ship = p.loadImage("/src/img/ship.png");
        thrusters = new PImage[3];
        thrusters[0] = p.loadImage("/src/img/thruster1.png");
        thrusters[1] = p.loadImage("/src/img/thruster2.png");
        thrusters[2] = p.loadImage("/src/img/thruster3.png");
        thrusterCycle = 0;
        laserCharge = 1000;
    }

    public void display()
    {
        x = p.mouseX < p.width * .4f ? p.mouseX - ship.width / 2 : p.width * .4f - ship.width / 2;
        y = p.mouseY - ship.height / 2;
        p.image(ship, x, y);
        if (p.frameCount%15==0)
        {
            thrusterCycle++;
            if (thrusterCycle>2)
                thrusterCycle = 0;
        }
        p.image(thrusters[thrusterCycle],x-p.width*.018f,y+p.height*.03f);
        p.image(thrusters[thrusterCycle],x-p.width*.018f,y+p.height*.073f);

        if (p.mousePressed)
        {
            if (p.mouseButton == p.LEFT)
                shoot();
        }

        chargeWeapons();
    }

    private void chargeWeapons()
    {
        if (!p.mousePressed)
        {
            if (laserCharge < 1000)
            {
                laserCharge += 1;
            }
        }
    }
    private void shoot()
    {
        if (laserCharge > 0)
        {
            laserCharge -= 5;
            p.fill(128,224,255,255);
            p.rect(x+ship.width,y+ship.height/2,p.width,5);
        }

    }

}
