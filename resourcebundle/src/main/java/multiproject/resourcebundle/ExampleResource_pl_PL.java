package multiproject.resourcebundle;

import java.math.BigDecimal;
import java.util.ListResourceBundle;

/**
 * ExampleResource_pl_PL
 */
public class ExampleResource_pl_PL extends ListResourceBundle {
  /**
   * Get contents for the resource bundle with pl_PL locale
   * @return Array of name and value pairs for properties
   */
  @Override
  protected Object[][] getContents() {
    return new Object[][] {
      { "currency", "polish zloty" },
      { "toUsdRate", new BigDecimal("3.401") },
      { "cities", new String[] { "Warsaw", "Cracow" } }
    };
  }
}
