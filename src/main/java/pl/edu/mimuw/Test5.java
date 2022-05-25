package pl.edu.mimuw;

public class Test5 {
  public static void someFunction(String str) {
    System.out.println(str.length());
  }

  public static void main(String[] args) throws Exception {
    try {
      someFunction(null);
    } catch (NullPointerException exception) {
      for (var trace : exception.getStackTrace())
        System.out.println(trace);
      throw new Exception();
    }
  }
}
