package task1;

import klmnkki.task1.SinFunction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinTests
{
    @ParameterizedTest(name="{arguments}")
    @CsvFileSource(resources="/sinTable.csv", numLinesToSkip=1)
    void seriesParametrizedTest(double x, int n, double expected, double delta)
    {
        double result = SinFunction.mySin(x, n);
        assertEquals(expected, result, delta);
    }
}
