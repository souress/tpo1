package klmnkki.task3.bot;

import klmnkki.task3.enums.Direction;
import klmnkki.task3.exception.HeadMoveException;
import klmnkki.task3.exception.IllegalStateException;

public interface IBotPart
{
    String move(String how, Direction direction) throws HeadMoveException;
    String attach(Bot robot) throws IllegalStateException;
    String detach(Bot robot) throws IllegalStateException;
}
