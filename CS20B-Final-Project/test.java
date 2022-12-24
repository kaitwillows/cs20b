public class test {
  public static final String ANSI_BG_LIGHT_GREY = "\u001B[47m";
public static final String ANSI_BG_DARK_GREY = "\u001B[100m";

public static final String ANSI_WHITE = "\u001B[37m";
public static final String ANSI_BLACK = "\u001B[30m";

public static void main(String[] args) {
    System.out.println(ANSI_BG_LIGHT_GREY + ANSI_WHITE + "This text has a light grey background and white text.");
    System.out.println(ANSI_BG_DARK_GREY + ANSI_WHITE + "This text has a dark grey background and white text.");
    System.out.println(ANSI_BG_LIGHT_GREY + ANSI_BLACK + "This text has a light grey background and black text.");
    System.out.println(ANSI_BG_DARK_GREY + ANSI_BLACK + "This text has a dark grey background and black text.");
}

}
