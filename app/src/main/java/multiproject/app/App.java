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
import java.util.Properties;
import java.util.stream.Collectors;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;

public class App {
  public static void main(String[] args) {
    Locale defaultLocale = defaultLocaleFromResource();
    printLocale("Default locale", Locale.getDefault());
    printLocale("Default display locale", Locale.getDefault(Locale.Category.DISPLAY));
    printLocale("Default format locale", Locale.getDefault(Locale.Category.FORMAT));
    printLocale("Default locale from resource", defaultLocale);
    printLocale("Root locale", Locale.ROOT);
    printLocale("English locale", Locale.ENGLISH);
    printLocale("French locale", Locale.FRENCH);
    printLocale("US locale", Locale.US);
    printLocale("UK locale", Locale.UK);
    printLocale("France locale", Locale.FRANCE);
    printLocale("fi language tag", Locale.forLanguageTag("fi"));
    Console console = System.console();
    if (console != null) {
      console.printf("Do you want to see all available locales? (y/n): ");
      String answer = console.readLine();
      console.printf("Answer given: %s%n", answer);
      if (answer.toLowerCase().equals("y")) {
        List<Locale> sortedLocales = Arrays.stream(Locale.getAvailableLocales())
          .sorted(Comparator.comparing(Locale::toString))
          .collect(Collectors.toList());
        System.out.println("Available locales:");
        for (Locale locale : sortedLocales) {
          printLocale("Locale", locale);
        }
      }
    }
    LinkedList tokens;
    tokens = split(getMessage());
    String result = join(tokens);
    System.out.println(WordUtils.capitalize(result));
  }

  private static Locale defaultLocaleFromResource() {
    Properties prop = new Properties();
    Locale.Builder builder = new Locale.Builder();
    try {
      InputStream defaultProperties = App.class.getResourceAsStream("/defaults.properties");
      prop.load(defaultProperties);
    }
    catch (IOException ex) {
      System.err.printf("Failed to read default properties:", ex);
    }
    return builder
      .setLanguage(prop.getProperty("app.defaultLanguage"))
      .setRegion(prop.getProperty("app.defaultCountry"))
      .setVariant(prop.getProperty("app.defaultVariant"))
      .setScript(prop.getProperty("app.defaultScript"))
      .build();
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
    if (locale.hasExtensions()) {
      for (Character extensionKey : locale.getExtensionKeys()) {
        System.out.printf("\tExtension key %c: %s%n", extensionKey, locale.getExtension(extensionKey));
      }
    }
  }
}
