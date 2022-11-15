import java.util.*;

class Main {
  public static void main(String[] args) {
    ArrayList<String[]>  test = new ArrayList<String[]>();
    String[] template = 
      {"[ISSUE]", "[IDENTIFIED BY]", "[DATE IDNETIFIED]", "[RESOLVED BY]", "[DATE]", "[LONG DESCRIPTION]"}; // initiallize more
    test.add(template);
    printIssues(test, "all");
  }

  static void duplicateArray() {
    System.out.println("some stuff here");
  }

  static void addItem() {
    
  }

  // INFO: pass "all", or "unresolved" as issue to print all items from the respective sets
  static void printIssues(ArrayList<String[]> dataStruct, String issue) {
    if (issue.compareTo("all") == 0) { // prints all issues, reguardless of status
      System.out.println("printing all issues...\n");
      for (String[] i : dataStruct) { // each issue
        for (String j : i) { // each item in issue
          System.out.print(j + ", ");
        }
        System.out.print("\n");
      }
    } else if (issue.compareTo("unresolved") == 0) { // prints only unresolved issues
      boolean allResolved = true;
      System.out.println("printing unresolved issues...\n");
      for (String[] i : dataStruct) {
        if (i[3].compareTo("(unresolved)") == 0) {
          for (String j : i) {
            System.out.print(j + ", ");
          }
          allResolved = false;
        }
        System.out.print("\n");
      }
      if (allResolved == true) {
        System.out.println("\nall issues have been resolved, yay!!!"); // all issues resolved
      }
    } else { // find the specific issue requested
      int duplicateIssue = 0;
      for (String[] i : dataStruct) {
        if (i[0].compareTo(issue) == 0) {
          for (String j : i) {
            System.out.print(j + ", ");
          }
          duplicateIssue++;
        }
        System.out.print("\n");
      }
      switch (duplicateIssue) {
        case 0:
          System.out.println("issue not found.");
          break;
        case 1:
          break;
        default: // duplicate case(s)
          System.out.println("duplicate cases found, please address this.");
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