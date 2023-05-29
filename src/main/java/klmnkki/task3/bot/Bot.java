package klmnkki.task3.bot;

import klmnkki.task3.Person;
import klmnkki.task3.enums.Place;
import klmnkki.task3.enums.Shape;
import klmnkki.task3.enums.State;
import klmnkki.task3.exception.IllegalStateException;

public class Bot implements IBot
{
    private Head head;

    private final String name;
    private State state;
    public Bot(Shape headShape, String name)
    {
        head = new Head(headShape);
        this.name = name;
        state = State.SITTING;
    }

    public Bot(String name)
    {
        this.name = name;
    }

    @Override
    public String sit(Place where) throws IllegalStateException
    {
        if (state == State.SITTING)
        {
            throw new IllegalStateException(state, State.SITTING);
        }
        state = State.SITTING;
        return "Robot sits " + where;
    }

    @Override
    public String getUp(Place from, String how) throws IllegalStateException
    {
        if (state == State.STAYING)
        {
            throw new IllegalStateException(state, State.STAYING);
        }
        state = State.STAYING;
        return "Robot gets up " + how + " from " + from;
    }

    @Override
    public String comeToPerson(Place from, Place through, Person to) throws IllegalStateException
    {
        if (state == State.SITTING)
        {
            throw new IllegalStateException(state, "Cannot walk while sitting. ");
        }
        return "Robot goes from " + from + " through " + through + " to " + to.getName();
    }

    @Override
    public String goTo(Place from, Place through, Place where) throws IllegalStateException
    {
        if (state == State.SITTING)
        {
            throw new IllegalStateException(state, "Cannot walk while sitting. ");
        }
        return "Robot goes from "  + from + " through " + through + " at " + where;
    }

    @Override
    public String lookAt(Person person, String how)
    {
        return "Robot looks at " + person.getName() + " " + how;
    }

    public Head getHead()
    {
        return head;
    }

    public void setHead(Head head)
    {
        this.head = head;
    }

    public void setState(State state)
    {
        this.state = state;
    }

    public State getState()
    {
        return state;
    }

    public String getName()
    {
        return name;
    }
}