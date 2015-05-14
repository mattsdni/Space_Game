import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;

/**
 * Created by Matt on 5/11/2015.
 */
public class MainMenuState implements IState
{
    PApplet p;
    StarField starField;
    Button playButton;

    MainMenuState(PApplet _p)
    {
        p = _p;
    }

    public void Update()
    {
        starField.move();
        playButton.update();
        if (playButton.pressed())
        {
            //TODO: fix this
            GUI.gGameMode.Push("gameplay", new GamePlayState(p));
        }
    }

    public void Render()
    {
        p.background(30, 5, 35);
        p.fill(200, 200, 200, 100);
        starField.display();
        p.fill(200);
        p.textAlign(PConstants.CENTER);
        p.textSize((int) (96 * (p.width / 2160.0)));
        p.text("Space Game!!1!!1!", p.width/2,p.height*.3f);
        playButton.display();

    }

    public void OnEnter()
    {
        starField = new StarField(p, 100);
        PFont font = p.createFont("/src/data/8bitOperatorPlus-Bold.ttf", 96);
        p.textFont(font);
        p.textSize((int) (96 * (p.width / 2160.0)));
        playButton = new Button(p, p.width/2, p.height/2, (int)(p.width*.15f), (int)(p.height*.08f), "Play", (int)(64*(p.width/2160.0)), p.color(200), p.color(255));
    }

    public void OnExit()
    {

    }
}
