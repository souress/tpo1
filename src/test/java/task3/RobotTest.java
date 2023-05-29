package task3;

import klmnkki.task3.bot.Bot;
import klmnkki.task3.exception.IllegalStateException;
import klmnkki.task3.enums.Place;
import klmnkki.task3.enums.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RobotTest
{
    private Bot testBot;

    @Test
    void sitWhenAlreadySitting()
    {
        // Arrange
        testBot = new Bot("testBot");
        testBot.setState(State.SITTING);
        String expectedMessage = "Cannot change state from " + testBot.getState() + " to " + State.SITTING;

        // Act
        Exception exception = Assertions.assertThrows(IllegalStateException.class, () -> testBot.sit(Place.CORNER));

        // Assert
        Assertions.assertEquals(exception.getMessage(), expectedMessage);
    }

    @Test
    void getUpWhenAlreadyStaying()
    {
        // Arrange
        testBot = new Bot("testBot");
        testBot.setState(State.STAYING);
        String expectedMessage = "Cannot change state from " + testBot.getState() + " to " + State.STAYING;

        // Act
        Exception exception = Assertions.assertThrows(IllegalStateException.class, () -> testBot.getUp(Place.CORNER, ""));

        // Assert
        Assertions.assertEquals(exception.getMessage(), expectedMessage);
    }

    @Test
    void comeToPersonWhileSitting()
    {
        // Arrange
        testBot = new Bot("testBot");
        testBot.setState(State.SITTING);
        String expectedMessage = "Cannot walk while sitting. State: " + testBot.getState();

        // Act
        Exception exception = Assertions.assertThrows(IllegalStateException.class, () -> testBot.comeToPerson(null, null, null));

        // Assert
        Assertions.assertEquals(exception.getMessage(), expectedMessage);
    }

    @Test
    void goToWhileSitting()
    {
        // Arrange
        testBot = new Bot("testBot");
        testBot.setState(State.SITTING);
        String expectedMessage = "Cannot walk while sitting. State: " + testBot.getState();

        // Act
        Exception exception = Assertions.assertThrows(IllegalStateException.class, () -> testBot.goTo(null, null, null));

        // Assert
        Assertions.assertEquals(exception.getMessage(), expectedMessage);
    }
}
