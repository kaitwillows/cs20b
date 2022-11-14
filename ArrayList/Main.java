import java.util.*;

class Main {
  public static void main(String[] args) {
    ArrayList<String[]>  test = new ArrayList<String[]>();
    String[] template = 
      {"[ISSUE SUMMARY]", "[IDENTIFIED BY]", "[DATE IDNETIFIED]", "[RESOLVED BY]", "[DATE]", "[LONG DESCRIPTION"};
    test.add(template);
    System.out.println(test);
  }

  static void duplicateArray() {
    System.out.println("some stuff here");
  }
}

/* 
from menu: (all methods essensially)
- print all issues
  - or unresolved
- print specific issue in plain english
- add issue
  - loop for each thingy
- mark as resolved
  - pull time and user info

- use the first index as a save name?
- active ussue tracker 
- show all or only unresolved issues
*/