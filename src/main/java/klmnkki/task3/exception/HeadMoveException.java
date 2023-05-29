package klmnkki.task3.exception;

import klmnkki.task3.enums.Direction;
import klmnkki.task3.enums.Shape;

public class HeadMoveException extends Exception
{
    public HeadMoveException(Shape shape)
    {
        super("Cannot move Robot head of " + shape + " shape");
    }

    public HeadMoveException(Shape shape, Direction direction)
    {
        super("Cannot move Robot head of " + shape + " shape " + direction);
    }
}
