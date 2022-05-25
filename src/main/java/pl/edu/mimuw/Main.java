package pl.edu.mimuw;

import pl.edu.mimuw.resources.FileInputStreamBufferedReader;

import java.io.IOException;
import java.util.Random;

class UnknownException extends Exception {
  UnknownException() {
    super("Unknown message");
  }
}

class UnexpectedException extends UnknownException {
}

class UncheckedException extends RuntimeException {
  UncheckedException() {
    super("I am unchecked");
  }
}

class CoolException extends Exception {
  CoolException() {
    super("I am cool");
  }
}

public class Main {

  public static void main(String[] args) throws IOException {
    try {
      someFunction();
    } catch (UnknownException | UncheckedException | CoolException exception) {
      System.out.print("I caught ");
      System.out.println(exception.getClass().getName());
      System.out.println(exception.getMessage());
    }

    System.out.println(read("./file.input"));
  }

  public static String read(String path) throws IOException {
    try (var reader = new FileInputStreamBufferedReader(path)) {
      return reader.readText();
    }
  }

  public static void someFunction() throws UnknownException, CoolException {
    switch (new Random().nextInt(4)) {
      case 0:
        throw new UnknownException();
      case 1:
        throw new UnexpectedException();
      case 2:
        throw new UncheckedException();
      case 3:
        throw new CoolException();
    }
  }
}
