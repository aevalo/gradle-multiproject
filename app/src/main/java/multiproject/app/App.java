package multiproject.app;

import multiproject.list.LinkedList;

import static multiproject.utilities.StringUtils.join;
import static multiproject.utilities.StringUtils.split;
import static multiproject.app.MessageUtils.getMessage;

import org.apache.commons.text.WordUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class App {
  public static void main(String[] args) {
    printLocale("Default locale", Locale.getDefault());
    printLocale("Root locale", Locale.ROOT);
    printLocale("English locale", Locale.ENGLISH);
    printLocale("French locale", Locale.FRENCH);
    printLocale("US locale", Locale.US);
    printLocale("UK locale", Locale.UK);
    printLocale("France locale", Locale.FRANCE);
    List<Locale> sortedLocales = Arrays.stream(Locale.getAvailableLocales())
      .sorted(Comparator.comparing(Locale::toString))
      .collect(Collectors.toList());
    System.out.println("Available locales:");
    for (Locale locale : sortedLocales) {
      printLocale("Locale", locale);
    }
    LinkedList tokens;
    tokens = split(getMessage());
    String result = join(tokens);
    System.out.println(WordUtils.capitalize(result));
  }

  private static void printLocale(String label, Locale locale) {
    System.out.printf("%s: %s%n\tName: %s%n", label, locale, locale.getDisplayName());
    if (!locale.getLanguage().isBlank()) {
      System.out.printf("\tLanguage: %s (%s)%n", locale.getDisplayLanguage(), locale.getLanguage());
    }
    if (!locale.getCountry().isBlank()) {
      System.out.printf("\tCountry: %s (%s)%n", locale.getDisplayCountry(), locale.getCountry());
    }
    if (!locale.getVariant().isBlank()) {
      System.out.printf("\tVariant: %s (%s)%n", locale.getDisplayVariant(), locale.getVariant());
    }
    if (!locale.getScript().isBlank()) {
      System.out.printf("\tScript: %s (%s)%n", locale.getDisplayScript(), locale.getScript());
    }
  }
}
