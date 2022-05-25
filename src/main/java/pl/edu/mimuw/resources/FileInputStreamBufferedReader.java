package pl.edu.mimuw.resources;

import java.io.*;
import java.nio.CharBuffer;

public class FileInputStreamBufferedReader implements Readable, Closeable {
  private final BufferedReader bufferedReader;
  private final FileInputStream stream;
  private final InputStreamReader streamReader;

  public FileInputStreamBufferedReader(String path) throws FileNotFoundException {
    var file = new File(path);
    stream = new FileInputStream(file);
    streamReader = new InputStreamReader(stream);
    bufferedReader = new BufferedReader(streamReader);
  }

  public String readText() throws IOException {
    CharBuffer buffer = CharBuffer.allocate(100);
    StringBuilder result = new StringBuilder();
    while (read(buffer) != -1) {
      for (var ch : buffer.array())
        if (ch != 0)
          result.append(ch);
      buffer.clear();
    }

    return result.toString();
  }

  @Override
  public void close() throws IOException {
    bufferedReader.close();
    streamReader.close();
    stream.close();
  }

  @Override
  public int read(CharBuffer charBuffer) throws IOException {
    return bufferedReader.read(charBuffer);
  }
}
