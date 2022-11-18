import java.util.*;



// local compile < 0.7s
// replit compile < 6.8s
// replit run ~= 0.9s
// local run ~= 0.1s


class Main {
  public static void main(String[] args) {
    System.out.print("\033[H\033[2J"); // clear screen
    ArrayList<String[]> test = new ArrayList<String[]>();
    ArrayList<String[]> backup = new ArrayList<String[]>();
    String[] template = 
      {"[ISSUE]", "[LINE #]", "[DESCRIPTION]", "[RESOLVED STATUS]"}; // initiallize more issues
    String[] exampleIssue1 = 
      {"issue1", "12", "my code no work :(", "unresolved"};
    String[] exampleIssue2 = 
      {"issue2", "12", "guysss the code doesnt work!!!!!!", "unresolved"};
    String[] exampleIssue3 = 
      {"ommit template", "18", "optional ommitence of the template issue should be included when printing", "unresolved"};
    test.add(template);
    test.add(exampleIssue1);
    test.add(exampleIssue2);
    test.add(exampleIssue3);
    // printIssues(test, "unresolved");
    // printIssues(test, "all");
    while (true) {
      ArrayList<String[]> returnedStruct = callMenu(test);
      if (returnedStruct.get(0)[0].compareTo("backup") == 0) { // recieving backup
        backup = new ArrayList<String[]>(returnedStruct);
      } else if (returnedStruct.get(0)[0].compareTo("[ISSUE]") == 0) {
        test = new ArrayList<String[]>(backup);
      }
    }

  }

  static ArrayList<String[]> callMenu(ArrayList<String[]> dataStruct) {
    ArrayList<String[]> emptyList = new ArrayList<String[]>();
    String[] placeHolder = {"placeholder"};
    emptyList.add(placeHolder);
    Scanner menuScanner = new Scanner(System.in);
    Scanner strScanner = new Scanner(System.in);
    System.out.print("menu: \n  [1] print all issues \n  [2] print unresolved issues \n  [3] print a specific issue \n  [4] add an issue \n  [5] mark an issue as resolved \n  [6] backup issue list \n  [7] recover issue list\n  [8] quit \nenter an option from the menu above: ");
    int choice = menuScanner.nextInt();
    String issue = "NULL";
    switch (choice) {
      case 1:
        printIssues(dataStruct, "all");
        break;
      case 2:
        printIssues(dataStruct, "unresolved");
        break;
      case 3:
        System.out.print("\nenter issue name: ");
        issue = strScanner.nextLine();
        System.out.print("\n");
        printIssues(dataStruct, issue);
        break;
      case 4:
        addItem(dataStruct);
        break;
      case 5: // mark as resolved
        System.out.print("\nenter issue name: ");
        issue = strScanner.nextLine();
        resolveIssue(dataStruct, issue);
        break;
      case 6: // copy list to backup
        System.out.println("\nthe list has been backed up");
        dataStruct.get(0)[0] = "backup";
        return dataStruct;
      case 7: // recover
      System.out.println("\nthe list has been restored from backup");
        return dataStruct;
      case 8:
        System.out.println("\nquitting...\n");
        System.exit(0);
      default:
        System.out.println("\nayo invalid choice buddy\n");
        break;
    }
    return emptyList;
    // menuScanner.close();
    // strScanner.close();
  }

  static void resolveIssue(ArrayList<String[]> dataStruct, String issue) {
    boolean issueFound = false;
    for (String[] i : dataStruct) {
      if (i[0].compareTo(issue) == 0) {
        if (i[3].compareTo("resolved") == 0) {
          System.out.println("\n the issue is allready resolved\n");
          break;
        }
        i[3] = "resolved";
        System.out.println("\nsuccessfully resolved issue\n");
        issueFound = true;
        break;
      }
    }
    if (!issueFound) {
      System.out.println("\nissue not found, ensure the name is entered correctly\n");
    }
  }


  static ArrayList<String[]> duplicateArray(ArrayList<String[]> dataStruct) {
    dataStruct.get(0)[0] = "backup";
    return dataStruct;
  }

  static void addItem(ArrayList<String[]> dataStruct) {
    // "[ISSUE]", "[LINE #]", "[DESCRIPTION]", "[RESOLVED STATUS]"
    // get the things from the user
    
    Scanner scanner = new Scanner(System.in);
    boolean duplicateIssueName = false;
    String issue = "NULL";

    do {
      duplicateIssueName = false;
      System.out.print("\nissue (short name): ");
      issue = scanner.nextLine();

      // check if the name already exists
      for (String[] i : dataStruct) {
        if (i[0].compareTo(issue) == 0) {
          duplicateIssueName = true;
          System.out.println("issue already exists, please enter a unique name.");
        }
      }
    } while (duplicateIssueName);

    System.out.print("line number: ");
    String lineNum = scanner.nextLine();
    System.out.print("description (longish name): "); // POSSIBLY WE COULD INITIALIZE THIS BY USING THE ACTUAL DATE IDK 
    String description = scanner.nextLine();
    System.out.print("\n");


    // pop them in ig
    String[] addedIssue = {issue, lineNum, description, "unresolved"}; // fix this shtuff
    dataStruct.add(addedIssue);
    // scanner.close();

    System.out.println("issue added successfully\n");
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
          System.out.print("\n");
        }
        
      }
      switch (duplicateIssue) {
        case 0:
          System.out.println("issue not found.\n");
          break;
        case 1:
          System.out.println("\nissue found successfully\n");
          break;
        default: // duplicate case(s)
          System.out.println("duplicate cases found, please address this.\n"); // THIS CODE SHOULD NEVER RUN IF THE PROGRAM IS DONE RIGHT
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