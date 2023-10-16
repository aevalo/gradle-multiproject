package multiproject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * XMLResourceBundleUnitTest
 */
public class XMLResourceBundleUnitTest {
  /**
   * Test loading properties from XML resource
   * @throws IOException - if resource loading fails
   */
  @Test
  public void loadPropertiesAsXmlStream() throws IOException {
    try(InputStream inputstream = this.getClass().getResourceAsStream("/labels_fr.xml")) {
      Properties props = new Properties();
      props.loadFromXML(inputstream);
      assertEquals("La valeur de la clé 1", props.getProperty("myKey1"));
      assertEquals("La valeur de la clé 2", props.getProperty("myKey2"));
      assertEquals("La valeur de la clé 3", props.getProperty("myKey3"));
      assertEquals(null, props.getProperty("myKey4"));
    }
  }

  /**
   * Test loading resource bundle for root locale
   */
  @Test
  public void loadPropertiesAsResourceBundle() {
    ResourceBundle bundle = ResourceBundle.getBundle("labels", Locale.ROOT, new XMLResourceBundleControl());
    assertEquals("value of key 1", bundle.getString("myKey1"));
    assertEquals("value of key 2", bundle.getString("myKey2"));
    assertEquals("value of key 3", bundle.getString("myKey3"));
    assertEquals("value of key 4", bundle.getString("myKey4"));
  }

  /**
   * Test loading resource bundle for English locale
   */
  @Test
  public void loadPropertiesAsResourceBundle_en() {
    ResourceBundle bundle = ResourceBundle.getBundle("labels", Locale.ENGLISH, new XMLResourceBundleControl());
    assertEquals("The value of key 1", bundle.getString("myKey1"));
    assertEquals("The value of key 2", bundle.getString("myKey2"));
    assertEquals("The value of key 3", bundle.getString("myKey3"));
    assertEquals("value of key 4", bundle.getString("myKey4"));
  }

  /**
   * Test loading resource bundle for French locale
   */
  @Test
  public void loadPropertiesAsResourceBundle_fr() {
    ResourceBundle bundle = ResourceBundle.getBundle("labels", Locale.FRENCH, new XMLResourceBundleControl());
    assertEquals("La valeur de la clé 1", bundle.getString("myKey1"));
    assertEquals("La valeur de la clé 2", bundle.getString("myKey2"));
    assertEquals("La valeur de la clé 3", bundle.getString("myKey3"));
    assertEquals("value of key 4", bundle.getString("myKey4"));
  }
}
