interface Sports {
  void method1();

  void method2();

  int method3(double d);
}

class Baseball implements Sports {
public Baseball( )
 { . . . }

 public void method1( )
 { // some code…}

 public void method2( )
 {}

 public int method3(double c )
 { // some code…}

  public int statevar1;
}

class Football implements Sports {
 public Football( )
 {}

 public void method1( )
 {}

 public void method2( )
 {}

 public int method3(double c )
 {}

  public int statevar1;
}

class Tester {
public static void main(String[] args)
 {
 Sports x = new Baseball( );
 Sports y = new Football( );


 x.method2( );
 y.method2( );
 . . . more code . . .
 }
}

/*
 * 1. method1(), method2(), and method3() are abstracted in the Sports interface
 * 2. method1(), method2(), and method3() are required to be in hockey, as it
 * implements these methods
 * 3.
 */