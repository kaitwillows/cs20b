import java.util.*;

class Main {
  public static void main(String[] args) {
    ArrayList<String[]>  test = new ArrayList<String[]>();
    String[] template = 
      {"[ISSUE DESCRIPTION]", "[IDENTIFIED BY]", "[DATE IDNETIFIED]", "[RESOLVED BY]", "[DATE]",};
    test.add(template);
    System.out.println(test);
  }

  static void duplicateArray() {
    System.out.println("some stuff here");
  }
}

/* 
- use the first index as a save name?
- active ussue tracker 
- show all or only unresolved issues
*/