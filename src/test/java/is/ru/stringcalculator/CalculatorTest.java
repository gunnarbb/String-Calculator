package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
  @Test
  public void testEmptyString(){
    assertEquals(0,Calculator.add(""));
  }

  @Test
  public void testOneNumber(){
    assertEquals(1,Calculator.add("1"));
  }

  @Test
  public void testTwoNumbers(){
    assertEquals(3,Calculator.add("1,2"));
  }

  @Test
  public void testMultipleNumbers(){
    assertEquals(12,Calculator.add("3,4,5"));
  }

  @Test
  public void testTwoNumbersNewLine(){
    assertEquals(3,Calculator.add("1\n2"));
  }

  @Test
  public void testMultipleNumberWithNewLineAndCommas(){
    assertEquals(8,Calculator.add("2\n2,2\n2"));
  }

  @Test
  public void testNegativeNumber(){

    Boolean threwEx = false;
      try {
            Calculator.add("-1");
      }
      catch(IllegalArgumentException ex) {
            threwEx = true;
      }
      assertEquals(true,threwEx);
  }

}
