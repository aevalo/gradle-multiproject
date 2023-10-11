package multiproject.app;

import multiproject.list.LinkedList;

import static multiproject.utilities.StringUtils.join;
import static multiproject.utilities.StringUtils.split;
import static multiproject.app.MessageUtils.getMessage;

import org.apache.commons.text.WordUtils;

public class App {
  public static void main(String[] args) {
    LinkedList tokens;
    tokens = split(getMessage());
    String result = join(tokens);
    System.out.println(WordUtils.capitalize(result));
  }
}
