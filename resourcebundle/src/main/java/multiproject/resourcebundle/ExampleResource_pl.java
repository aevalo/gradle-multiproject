package multiproject.resourcebundle;

import java.util.ListResourceBundle;

/**
 * ExampleResource_pl
 */
public class ExampleResource_pl extends ListResourceBundle {
  /**
   * Get contents for the resource bundle with pl locale
   * @return Array of name and value pairs for properties
   */
  @Override
  protected Object[][] getContents() {
    return new Object[][] {
      { "greeting", "cześć" },
      { "language", "polish" },
    };
  }
}
