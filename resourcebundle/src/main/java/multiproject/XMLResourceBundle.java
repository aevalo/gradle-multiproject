package multiproject;

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Stream;
import java.util.Map;
import java.net.URL;
import java.net.URLConnection;

/**
 * XMLResourceBundle
 */
public class XMLResourceBundle extends ResourceBundle {
  /**
   * Properties in loaded XML resource
   */
  private Properties props;

  /**
   * Constructor for XMLResourceBundle
   * @param stream stream to read XML resource from
   * @throws IOException when resource reading fails
   */
  public XMLResourceBundle(InputStream stream) throws IOException {
    props = new Properties();
    props.loadFromXML(stream);
  }

  /**
   * Handle reading property value
   * @param key the key for the desired object
   * @return value of property
   */
  @Override
  protected Object handleGetObject(String key) {
    return props.getProperty(key);
  }

  /**
   * Get keys associated with this resource bundle
   * @return enumeration containing keys for this resource bundle
   */
  @Override
  public Enumeration<String> getKeys() {
    Set<String> handleKeys = props.stringPropertyNames();
    return Collections.enumeration(handleKeys);
  }
}
