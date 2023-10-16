package multiproject.resourcebundle;

import java.util.ListResourceBundle;

/**
 * ExampleResource
 */
public class ExampleResource extends ListResourceBundle {
  /**
   * Get contents for the resource bundle with root locale
   * @return Array of name and value pairs for properties
   */
  @Override
  protected Object[][] getContents() {
    return new Object[][] {
      { "greeting", "hello" }
    };
  }
}
