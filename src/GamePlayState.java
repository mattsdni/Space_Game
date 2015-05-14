import processing.core.PApplet;
import processing.core.PFont;

/**
 * Created by Matt on 5/13/2015.
 */
public class GamePlayState implements IState
{
    PApplet p;
    StarField starField;
    PlayerShip playerShip;
    Asteroid asteroid;

    GamePlayState(PApplet _p)
    {
        p = _p;
    }

    public void Update()
    {
        starField.move();
    }

    public void Render()
    {
        p.background(30, 5, 35);
        p.fill(200, 200, 200, 100);
        starField.display();
        playerShip.display();
        asteroid.display();
        asteroid.checkForLaser();
        p.text("Laser Charge: " + playerShip.laserCharge, 800, 100);


    }

    public void OnEnter()
    {
        starField = new StarField(p, 100);
        playerShip = new PlayerShip(p);
        asteroid = new Asteroid(p);
        PFont font = p.createFont("/src/data/8bitOperatorPlus-Bold.ttf", 96);
        p.textFont(font);
        p.textSize((int) (96 * (p.width / 2160.0)));
    }

    public void OnExit()
    {

    }
}
