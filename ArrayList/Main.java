import java.util.*;


// yippie you're probably on the right branch unless its farther in the future tbh


class Main {
  public static void main(String[] args) {
    System.out.print("\033[H\033[2J"); // clear screen
    ArrayList<String[]>  test = new ArrayList<String[]>();
    String[] template = 
      {"[ISSUE]", "[LINE #]", "[DESCRIPTION]", "[RESOLVED STATUS]"}; // initiallize more issues
    String[] exampleIssue1 = 
      {"issue1", "12", "my code no work :(", "unresolved"};
    String[] exampleIssue2 = 
      {"WHY DOESNT MY CODE WORKKKK", "sad_c0d3r_609", "11/09/2022", "jonnyhacker", "11/10/2022"};
    String[] exampleIssue3 = 
      {"optional ommitence of the template issue should be included when printing", "tim", "11/10/2022", "(unresolved)", "(unresolved)"};
    test.add(template);
    test.add(exampleIssue1);
    test.add(exampleIssue2);
    test.add(exampleIssue3);
    // printIssues(test, "unresolved");
    // printIssues(test, "all");
    callMenu(test);
  }

  static void callMenu(ArrayList<String[]> dataStruct) {
    Scanner menuScanner = new Scanner(System.in);
    Scanner strScanner = new Scanner(System.in);
    System.out.print("menu: \n  [1] print all issues \n  [2] print unresolved issues \n  [3] print a specific issue \n  [4] add an issue \n  [5] mark an issue as resolved \n  [6] backup entire issue list \n  [7] quit \n  [8] display help \nenter an option from the menu above: ");
    int choice = menuScanner.nextInt();
    switch (choice) {
      case 1:
        printIssues(dataStruct, "all");
        break;
      case 2:
        printIssues(dataStruct, "unresolved");
      case 3:
        System.out.print("enter issue name: \n");
        String issue = strScanner.nextLine();
        printIssues(dataStruct, issue);

      default:
        System.out.println("ayo invalid choice buddy");
        break;
    }
    menuScanner.close();
    strScanner.close();
  }

  static void duplicateArray() {
    System.out.println("to do");
  }

  static void addItem(ArrayList<String[]> dataStruct) {
    // "[ISSUE]", "[LINE #]", "[DESCRIPTION]", "[RESOLVED STATUS]"
    // get the things from the user
    Scanner scanner = new Scanner(System.in);
    System.out.print("issue (short name): ");
    String issue = scanner.nextLine();
    System.out.print("line number: ");
    String lineNum = scanner.nextLine();
    System.out.print("description (longish name): "); // POSSIBLY WE COULD INITIALIZE THIS BY USING THE ACTUAL DATE IDK 
    String description = scanner.nextLine();
	 
	 // pop them in ig
	 String[] addedIssue = {issue, lineNum, description, "unresolved"}; // fix this shtuff
   dataStruct.add(addedIssue);
   scanner.close();
  }

  // INFO: pass "all", or "unresolved" as issue to print all items from the respective sets
  static void printIssues(ArrayList<String[]> dataStruct, String issue) {
    if (issue.compareTo("all") == 0) { // prints all issues, reguardless of status
      System.out.println("\nprinting all issues...\n");
      for (String[] i : dataStruct) { // each issue
        for (String j : i) { // each item in issue
          System.out.print(j + ", ");
        }
        System.out.print("\n");
      }
      System.out.print("\n");
    } else if (issue.compareTo("unresolved") == 0) { // prints only unresolved issues
      boolean allResolved = true;
      System.out.println("\nprinting unresolved issues...\n");
      for (String[] i : dataStruct) {
        if (i[3].compareTo("unresolved") == 0 || i[0].compareTo("[ISSUE]") == 0 ) {
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
          System.out.println("issue found successfully");
          break;
        default: // duplicate case(s)
          System.out.println("duplicate cases found, please address this."); // THIS CODE SHOULD NEVER RUN IF THE PROGRAM IS DONE RIGHT
      }
    }
  }
}

/* 
backup array thing
  - copy array to backup
recall array
  - copy backup to array
*/

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