import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Matt on 5/11/2015.
 */
public class StateMachine
{
    //Map<String, IState> mStates = new HashMap<String, IState>();
    Stack<IState> mStack = new Stack<IState>();

    public void Update()
    {
        mStack.peek().Update();
    }

    public void Render()
    {
        mStack.peek().Render();
    }

    public void Push(String stateName, IState state)
    {
        mStack.push(state);
        //mCurrentState = mStates.get(stateName);
        mStack.peek().OnEnter();
    }

//    public void Push(String stateName)
//    {
//        IState state = mStates.get(stateName);
//        mStack.push(state);
//        state.OnEnter();
//    }

    public void Pop()
    {
        mStack.peek().OnExit();
        mStack.pop();
    }
}
