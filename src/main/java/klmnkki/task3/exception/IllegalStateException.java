package klmnkki.task3.exception;

import klmnkki.task3.enums.State;

public class IllegalStateException extends Exception
{
    public IllegalStateException(State previousState, State nextState)
    {
        super("Cannot change state from " + previousState + " to " + nextState);
    }

    public IllegalStateException(State state, String message)
    {
        super(message + "State: " + state);
    }

    public IllegalStateException(String message)
    {
        super(message);
    }
}
