package klmnkki.task3.bot;

import klmnkki.task3.enums.Direction;
import klmnkki.task3.enums.Shape;
import klmnkki.task3.exception.HeadMoveException;
import klmnkki.task3.exception.IllegalStateException;

public class Head implements IBotPart
{
    private final Shape shape;

    private boolean isAttached;

    public Head(Shape shape)
    {
        this.shape = shape;
    }

    @Override
    public String move(String how, Direction direction) throws HeadMoveException
    {
        if (shape == Shape.WITHOUT_NECK)
        {
            throw new HeadMoveException(shape);
        }
        if (shape == Shape.SQUARE && (direction == Direction.UP || direction == Direction.DOWN))
        {
            throw new HeadMoveException(shape, direction);
        }
        return shape + " head moves " + how + " " + direction;
    }

    @Override
    public String attach(Bot robot) throws IllegalStateException
    {
        if (isAttached)
        {
            if (robot.getHead().equals(this))
            {
                throw new IllegalStateException("Head is already attached to this robot");
            }
            else
            {
                throw new IllegalStateException("Head is already attached to another robot");
            }
        }
        isAttached = true;
        return "Attached head to robot with name " + robot.getName();
    }

    @Override
    public String detach(Bot robot) throws IllegalStateException
    {
        if (!isAttached)
        {
            throw new IllegalStateException("Head is already detached");
        }
        isAttached = false;
        return "Detached head from robot with name " + robot.getName();
    }

    public Shape getShape()
    {
        return shape;
    }

    public boolean isAttached()
    {
        return isAttached;
    }
}

