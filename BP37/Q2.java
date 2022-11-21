class Q2 {
  // precondition: score must be between 0 and 100
  String studentName; 
  public static void main(String[] args) {
    setStudentScore(2);
  }
  static void setStudentScore(int score) {
    if (score < 0 || score > 100) {
      String s = "Score must be between 0 and 100";
      IllegalArgumentException e = new IllegalArgumentException(s);
      throw e;
    }
    System.out.println("Set score successfully"); // in reality, nothing happened
  }
}