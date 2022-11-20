class Q2 {
    // precondition: score must be between 0 and 100
    String studentName; 
    public Q2(String studentName) {
        studentName = this.studentName;
    }
    public void setStudentScore(int score) {
        if (score < 0 || score > 100) {
            String s = "Score must be between 0 and 100";
            IllegalArgumentException e = new IllegalArgumentException(s);
            throw e;
        }
    }
}