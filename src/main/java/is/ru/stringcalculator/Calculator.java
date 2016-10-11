package is.ru.stringcalculator;

public class Calculator{

  public static int add(String text){

    if (text.equals("")) {
      return 0;
    }
      text = replace(text,"\n",",");
      return sumOfMultipleNumbers(splitNumbers(text,","));
    }

    public static String replace(String text, String replace, String replacement){
      return text.replace(replace,replacement);
    }

    public static String[] splitNumbers(String text, String separators){
      return text.split(separators);
    }

  public static int sumOfMultipleNumbers(String [] numbers){
    int total = 0;
    String negatives = "";
    for(String number : numbers){
       if (toInt(number) < 0){
         negatives += number + ",";
         }
         total += toInt(number);
    }
    if (!negatives.equals("")) {
      throw new IllegalArgumentException("Negatives not allowed: " + negatives);
    }
    return total;
}
  public static int toInt(String text){
    return Integer.parseInt(text);
  }
}
