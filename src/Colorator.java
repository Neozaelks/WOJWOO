public class Colorator {
  public static String coloredPrint(String string, String color){
    //allows for BLACK,RED,GREEN,YELLOW,BLUE,PURPLE,CYAN,WHITE
    switch (color) {
      case "BLACK" -> {
        return "\u001B[30m" + string + "\u001B[0m";
      }
      case "RED" -> {
        return "\u001B[31m" + string + "\u001B[0m";
      }
      case "GREEN" -> {
        return "\u001B[32m" + string + "\u001B[0m";
      }
      case "YELLOW" -> {
        return "\u001B[33m" + string + "\u001B[0m";
      }
      case "BLUE" -> {
        return "\u001B[34m" + string + "\u001B[0m";
      }
      case "PURPLE" -> {
        return "\u001B[35m" + string + "\u001B[0m";
      }
      case "CYAN" -> {
        return "\u001B[36m" + string + "\u001B[0m";
      }
      case "WHITE" -> {
        return "\u001B[37m" + string + "\u001B[0m";
      }
      default -> {
        return "ERROR";
      }
    }
  }

  public static String decoratedPrint(String string, String decoration){
    //allows for BOLD, ITALIC, UNDERLINE, CROSSED-OUT
    switch (decoration) {
      case "BOLD" -> {
        return "\u001B[1m" + string + "\u001B[0m";
      }
      case "ITALIC" -> {
        return "\u001B[3m" + string + "\u001B[0m";
      }
      case "UNDERLINE" -> {
        return "\u001B[4m" + string + "\u001B[0m";
      }
      case "CROSSED-OUT" -> {
        return "\u001B[9m" + string + "\u001B[0m";
      }
      default -> {
        return "ERROR";
      }
    }
  }

  public static String coloredAndDecoratedPrint(String string, String color, String decoration){
    return decoratedPrint(coloredPrint(string, color), decoration);
  }
}
