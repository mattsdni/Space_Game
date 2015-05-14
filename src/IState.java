/**
 * Created by Matt on 5/11/2015.
 */
public interface IState
{
    public void Update();

    public void Render();

    public void OnEnter();

    public void OnExit();

}
