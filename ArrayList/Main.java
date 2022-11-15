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

  static void addItem() {
    
  }

  static void printIssues(ArrayList<String[]> dataStruct, String issue) {
    // if issue is all or unresolved, loop through printing all
    // else loop through untill the issue requested is found
    // strcomp 0 = the same
    if (issue.compareTo("all") == 0) {
      System.out.println("printing all issues...\n");
      for (String[] i : dataStruct) {
        for (String j : i) {
          System.out.println(j);
        }
      }
    }
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