interface Sports { void method1();

  void method2();

}

interface Sports2 {
  int method3(double d);
}

class Baseball implements Sports {
public Baseball( )
 {}

 public void method1( )
 {System.out.println("owo this code is different what");}

 public void method2( )
 {}

 public int method3(double c )
 {return 7;}

  public int statevar1;
}

class Football extends Baseball implements Sports, Sports2 {
 public Football( )
 {}

 public void method1( )
 {System.out.println("hahahah whyu");}

 public void method2( )
 {}

 public int method3(double c )
 {return 7;}

  public int statevar1;
}

class Tester {
public static void main(String[] args)
 {
 Sports x = new Baseball( );
 Sports y = new Football( );


 x.method2( );
 y.method2( );
 System.out.println(y instanceof Football);
 }
}

/*
 * 1. method1(), method2(), and method3() are abstracted in the Sports interface
 * 2. method1(), method2(), and method3() are required to be in hockey, as it implements these methods
 * 3. NO AND I DONT KNOW WHY
 * 4. true
 * 5. true
 * 6. polymorphism
 * 
 * wait okay the stars work but what if i make a sin tax error haha
 */
