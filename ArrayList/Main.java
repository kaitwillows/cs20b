import java.util.*;

class Main {
  public static void main(String[] args) {
    ArrayList<String[]>  test = new ArrayList<String[]>();
    String[] template = 
      {"[ISSUE]", "[IDENTIFIED BY]", "[DATE IDNETIFIED]", "[RESOLVED BY]", "[DATE]"}; // initiallize more issues
    String[] exampleIssue1 = 
      {"the code doesnt work and im sad", "sad_c0d3r_609", "11/10/2022", "(unresolved)", "(unresolved)"};
    String[] exampleIssue2 = 
      {"WHY DOESNT MY CODE WORKKKK", "sad_c0d3r_609", "11/09/2022", "jonnyhacker", "11/10/2022"};
    String[] exampleIssue3 = 
      {"optional ommitence of the template issue should be included when printing", "tim", "11/10/2022", "(unresolved)", "(unresolved)"};
    test.add(template);
    test.add(exampleIssue1);
    test.add(exampleIssue2);
    test.add(exampleIssue3);
    printIssues(test, "unresolved");
    printIssues(test, "all");
  }

  static void duplicateArray() {
    System.out.println("to do");
  }

  static void addItem(ArrayList<String[]> dataStruct) {
    // get the things from the user
    Scanner scanner = new Scanner(System.in);
    System.out.print("Issue: ");
    String issue = scanner.nextLine();
    System.out.print("Name: ");
    String name = scanner.nextLine();
    System.out.print("date: "); // POSSIBLY WE COULD INITIALIZE THIS BY USING THE ACTUAL DATE IDK 
    String date = scanner.nextLine();
	 
	 // pop them in ig
	 String[] addedIssue = {issue, name, date, "(unresolved)", "(unresolved)"};
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
      System.out.print("\n");
    } else if (issue.compareTo("unresolved") == 0) { // prints only unresolved issues
      boolean allResolved = true;
      System.out.println("printing unresolved issues...\n");
      for (String[] i : dataStruct) {
        if (i[3].compareTo("(unresolved)") == 0 || i[0].compareTo("[ISSUE]") == 0 ) {
          for (String j : i) {
            System.out.print(j + ", ");
          }
          System.out.print("\n");
          allResolved = false;
        }
        
      }
      if (allResolved == true) {
        System.out.println("\nall issues have been resolved, yay!!!"); // all issues resolved
      }
      System.out.print("\n");
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