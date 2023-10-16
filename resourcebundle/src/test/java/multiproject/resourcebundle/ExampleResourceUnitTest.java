package multiproject.resourcebundle;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ExampleResourceUnitTest
 */
public class ExampleResourceUnitTest {
  /**
   * Test loading resource bundle with pl_PL locale
   */
  @Test
  public void whenGetBundleExampleResourceForLocalePlPl_thenItShouldInheritPropertiesGreetingAndLanguage() {
    Locale plLocale = new Locale("pl", "PL");

    ResourceBundle exampleBundle = ResourceBundle.getBundle("multiproject.resourcebundle.ExampleResource", plLocale);

    assertTrue(exampleBundle.keySet()
      .containsAll(Arrays.asList("toUsdRate", "cities", "greeting", "currency", "language")));
    assertEquals(exampleBundle.getString("greeting"), "cześć");
    assertEquals(exampleBundle.getObject("toUsdRate"), new BigDecimal("3.401"));
    assertArrayEquals(exampleBundle.getStringArray("cities"), new String[] { "Warsaw", "Cracow" });
  }

  /**
   * Test loading resource bundle with en_US locale
   */
  @Test
  public void whenGetBundleExampleResourceForLocaleUs_thenItShouldContainOnlyGreeting() {
    Locale usLocale = Locale.US;

    ResourceBundle exampleBundle = ResourceBundle.getBundle("multiproject.resourcebundle.ExampleResource", usLocale);

    assertFalse(exampleBundle.keySet()
      .containsAll(Arrays.asList("toUsdRate", "cities", "currency", "language")));
    assertTrue(exampleBundle.keySet()
      .containsAll(Arrays.asList("greeting")));
  }
}
