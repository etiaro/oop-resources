package pl.edu.mimuw;

public class Test1 {
  public static void someFunction(String str) {
    System.out.println(str.length());
  }

  public static void main(String[] args) {
    someFunction(null);
  }
}
