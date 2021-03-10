import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CalculatorTest {
    private Calculator calculator;


    @Test
    public void testAdd() {
        calculator = new Calculator();
        Assertions.assertEquals(5, calculator.add(2, 2));
    }
}
