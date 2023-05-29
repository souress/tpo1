package task3;


import klmnkki.task3.bot.Bot;
import klmnkki.task3.enums.Direction;
import klmnkki.task3.enums.Shape;
import klmnkki.task3.exception.HeadMoveException;
import klmnkki.task3.exception.IllegalStateException;
import klmnkki.task3.bot.Head;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;


public class HeadTest
{
    private Head testHead;
    private Bot testBot;

    @Test
    void moveHeadWithoutNeck()
    {
        // Arrange
        testHead = new Head(Shape.WITHOUT_NECK);
        String expectedMessage = "Cannot move Robot head of WITHOUT_NECK shape";

        // Act
        Exception exception = Assertions.assertThrows(HeadMoveException.class, () -> testHead.move("", Direction.UP));

        // Assert
        Assertions.assertEquals(exception.getMessage(), expectedMessage);
    }

    @ParameterizedTest
    @EnumSource(value=Direction.class, names={ "UP", "DOWN" })
    void moveHeadUpOrDownSquareHead(Direction direction)
    {
        // Arrange
        testHead = new Head(Shape.SQUARE);
        String expectedMessage = "Cannot move Robot head of SQUARE shape " + direction;

        // Act
        Exception exception = Assertions.assertThrows(HeadMoveException.class, () -> testHead.move("", direction));

        // Assert
        Assertions.assertEquals(exception.getMessage(), expectedMessage);
    }

    @Test
    void attachHeadRobotWithoutHead() throws IllegalStateException
    {
        // Arrange
        testHead = new Head(Shape.ROUND);
        testBot = new Bot("testBot");

        // Act
        String result = testHead.attach(testBot);

        // Assert
        Assertions.assertTrue(testHead.isAttached());
        Assertions.assertEquals(result, "Attached head to robot with name " + testBot.getName());
    }

    @Test
    void detachAlreadyDetachedHead()
    {
        // Arrange
        testHead = new Head(Shape.ROUND);
        testBot = new Bot("testBot");
        String expectedMessage = "Head is already detached";

        // Act
        Exception exception = Assertions.assertThrows(IllegalStateException.class, () -> testHead.detach(testBot));

        // Assert
        Assertions.assertEquals(exception.getMessage(), expectedMessage);
    }
}
