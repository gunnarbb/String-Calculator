package is.ru.stringcalculator;

public class Calculator{

  public static int add(String text){

    if (text.equals("")) {
      return 0;
    }
      text = replace(text,"\n",",");
      text  = delimeters(text);
      return sumOfMultipleNumbers(splitNumbers(text,","));
  }

  public static String replace(String text, String replace, String replacement){
      return text.replace(replace,replacement);
  }

  public static String delimeters(String text){

    if(text.startsWith("//[")) {
      int startPos = 3;
      String endingPlace = "]";
			String theDelimeter = text.substring(startPos, text.indexOf(endingPlace));
			text = correctTextForDelimeter(text, theDelimeter);
		}
    return text;
  }

  public static String correctTextForDelimeter(String text, String delimeter){
    int kText = 5;
    text = text.substring(delimeter.length() + kText);
    text = replace(text,delimeter,",");
    return text;
  }

  public static String[] splitNumbers(String text, String separators){
    return text.split(separators);
  }

  public static int sumOfMultipleNumbers(String [] numbers){

    int total = 0;
    String negatives = "";
    for(String number : numbers){
        if (isNegativeNumber(toInt(number))){
          negatives += number + ",";
        }
        else if (isBigNumber(toInt(number))){
          continue;
        }
         total += toInt(number);
    }
    if (!negatives.equals("")) {
        handleNegatives(negatives);
    }
    return total;
  }

  public static Boolean isNegativeNumber(int number){
    return number < 0;
  }

  public static Boolean isBigNumber(int number){
    return number > 1000;
  }
  public static int toInt(String text){
    return Integer.parseInt(text);
  }

  public static void handleNegatives(String negatives){
    throw new IllegalArgumentException("Negatives not allowed: " + negatives);
  }
}
