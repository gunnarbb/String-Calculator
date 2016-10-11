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

  @Test
  public void testTwoNegativeNumbers(){

    Boolean threwEx = false;
    try {
          Calculator.add("-4,-3");
    }
    catch(IllegalArgumentException ex) {
          threwEx = true;
    }
    assertEquals(true,threwEx);
  }

  @Test
  public void testMultipleNegativeNumbers(){

    Boolean threwEx = false;
    try {
          Calculator.add("-4,-3,\n4,-7");
    }
    catch(IllegalArgumentException ex) {
          threwEx = true;
    }
    assertEquals(true,threwEx);
  }

  @Test
  public void testBigNumber(){
    assertEquals(0,Calculator.add("1001"));
  }

  @Test
  public void testBigNumbers(){
    assertEquals(5,Calculator.add("1001,100324,9999,3\n2"));
  }

  @Test
  public void testDelimeter() {
       assertEquals(13, Calculator.add("//[*]\n1*10*2"));
   }

   @Test
   public void testDelemieterWithNegatives() {
     Boolean threwEx = false;
     try {
        Calculator.add("//[*]\n1*-10*-2");
     }
     catch(IllegalArgumentException ex) {
           threwEx = true;
     }
     assertEquals(true,threwEx);
    }
}
