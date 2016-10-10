package is.ru.stringcalculator;

public class Calculator{

  public static int add(String text){

    if (text.equals("")) {
      return 0;
    }
    else if (text.contains(",")){
      return sumOfMultipleNumbers(splitNumbers(text));
    }
    return 1;
  }

  public static String[] splitNumbers(String text){
    return text.split(",");
  }

  public static int sumOfMultipleNumbers(String [] numbers){
    int total = 0;
       for(String number : numbers){
       total += toInt(number);
   }
   return total;
}

  public static int toInt(String text){
    return Integer.parseInt(text);
  }
}
