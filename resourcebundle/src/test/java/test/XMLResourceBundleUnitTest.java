package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class XMLResourceBundleUnitTest {
  @Test
  public void loadPropertiesAsXmlStream() throws IOException {
    try(InputStream inputstream = this.getClass().getResourceAsStream("/labels_fr.xml")) {
      Properties props = new Properties();
      props.loadFromXML(inputstream);
      assertEquals("la valeur de la cle 1", props.getProperty("maCle1"));
      assertEquals("la valeur de la cle 2", props.getProperty("maCle2"));
      assertEquals("la valeur de la cle 3", props.getProperty("maCle3"));
    }
  }

  @Test
  public void loadPropertiesAsResourceBundle() {
    Locale frLocale = new Locale("fr");
    ResourceBundle bundle = ResourceBundle.getBundle("labels", frLocale, new XMLResourceBundleControl());
    assertEquals("la valeur de la cle 1", bundle.getString("maCle1"));
    assertEquals("la valeur de la cle 2", bundle.getString("maCle2"));
    assertEquals("la valeur de la cle 3", bundle.getString("maCle3"));
  }
}
